package fr.esimed.jshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import fr.esimed.jshop.services.ApiInstance
import fr.esimed.jshop.services.ApiInstance.Companion.tokenUser
import fr.esimed.jshop.services.UserAccountService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LoginActivity : AppCompatActivity() {

    private var disposable : Disposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnConnexion = findViewById<Button>(R.id.btnConnexion)
        btnConnexion.setOnClickListener {
            val edtLogin = findViewById<EditText>(R.id.edtConnexionLogin)
            val edtPassword = findViewById<EditText>(R.id.edtConnexionPassword)
            if(!edtLogin.text.toString().isEmpty() && !edtPassword.text.toString().isEmpty()) {

                disposable = ApiInstance.createClient().loginUser(edtLogin.text.toString(),edtPassword.text.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { result ->
                            //On enregistre le token4
                            tokenUser = result.get("token").toString().replace("\"", "")
                            //Toast.makeText(this,"resultat de l'auth : " + tokenUser, Toast.LENGTH_LONG).show()
                            //On redirige vers le MainActivity
                            val intent = Intent(this,MainActivity::class.java)
                            startActivity(intent)
                        }, {
                                error ->
                            //Error
                            Toast.makeText(this,"error", Toast.LENGTH_LONG)
                        })
            } else {

            }
        }
    }
}