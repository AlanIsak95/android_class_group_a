package royal.master.academy.grupo_a.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import royal.master.academy.grupo_a.data.User
import royal.master.academy.grupo_a.data.UserLoginStatus
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
            btnActivityLoginLogin.isEnabled = false
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

        /* */
        binding.etActivityLoginUser.doOnTextChanged { text, _, _, _ ->

            val valorDelEditText = text.toString().trim()
            val passwordValue = binding.etActivityLoginPassword.text.toString().trim()

            binding.btnActivityLoginLogin.isEnabled =
                valorDelEditText.isNotEmpty() &&  valorDelEditText.length >= 6 && passwordValue.isNotEmpty() && passwordValue.length >= 10

        }

        /* */
        binding.etActivityLoginPassword.doOnTextChanged{ text, _, _, _ ->

            val valorDelEditText = text.toString().trim()
            val userValue = binding.etActivityLoginUser.text.toString().trim()

            binding.btnActivityLoginLogin.isEnabled =
                valorDelEditText.isNotEmpty() && valorDelEditText.length >= 10 && userValue.isNotEmpty() &&  userValue.length >= 6

        }

        /* */
        binding.etActivityLoginUser.setOnFocusChangeListener { _ , _ ->
            binding.tvActivityLoginError.visibility = View.GONE
        }

        /* */
        binding.etActivityLoginPassword.setOnFocusChangeListener { _ , _ ->
            binding.tvActivityLoginError.visibility = View.GONE
        }



    }

    /** */
    private fun onLogin() {

        with(binding){

            val userText = etActivityLoginUser.text.toString()
            val passwordText = etActivityLoginPassword.text.toString()

            val user = User(
                name = "Alan Altamira",
                password = passwordText,
                userName = userText
            )

            when(user.validateCredentials()){
                UserLoginStatus.SUCCESS -> goToWelcomeView()
                UserLoginStatus.FAILURE -> showLoginTvError()
            }

            /*TODO hideKeyBoard()*/

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
    private fun showLoginTvError() {

        with(binding){

            etActivityLoginUser.setText("")
            etActivityLoginPassword.setText("")

            etActivityLoginUser.clearFocus()
            etActivityLoginPassword.clearFocus()

            tvActivityLoginError.visibility = View.VISIBLE

        }


    }

}