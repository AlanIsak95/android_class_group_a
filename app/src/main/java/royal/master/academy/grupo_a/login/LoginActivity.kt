package royal.master.academy.grupo_a.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import royal.master.academy.grupo_a.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    /* */
    private lateinit var binding : ActivityLoginBinding

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpView()
        setUpListeners()

    }


    /** */
    private fun setUpView() {

        with(binding){
            tvActivityLoginError.text = "El usuario o contraseña estan mal."
            btnActivityLoginLogin.text = "Login"
            tvActivityLoginError.visibility = View.GONE
        }


    }


    /** */
    private fun setUpListeners() {

        /* */
        binding.btnActivityLoginLogin.setOnClickListener {
            onLogin()
        }

    }

    /** */
    private fun onLogin() {

        with(binding){

            val user = etActivityLoginUser.text.toString()
            val password = etActivityLoginPassword.text.toString()

            if (user == "aaltamira" && password == "123")
                goToWelcomeView()
            else
                hideLoginTvError()

        }

    }

    /** */
    private fun goToWelcomeView() {

        binding.tvActivityLoginError.visibility = View.GONE

        /*
        val welcomeScreen = Intent(this@LoginActivity , WelcomeActivity::class.java)
        val name = "Alan Altamira"
        welcomeScreen.putExtra("nameByLogin", name )
        welcomeScreen.putExtra("age", 15 )
        startActivity(welcomeScreen) */

        Intent(this@LoginActivity,WelcomeActivity::class.java).apply{
            putExtra("nameByLogin", "Alan Altamira" )
            putExtra("age", 15 )
        }.also { startActivity(it) }

        finish()
    }

    /** */
    private fun hideLoginTvError() {
        binding.tvActivityLoginError.visibility = View.VISIBLE
    }

}