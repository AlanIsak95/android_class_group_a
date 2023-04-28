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
        binding.tilActivityLoginUser.editText?.doOnTextChanged { text, _, _, _ ->

            val valorDelEditText = text.toString().trim()
            val passwordValue = binding.tilActivityLoginPassword.editText?.text.toString().trim()

            binding.btnActivityLoginLogin.isEnabled =
                valorDelEditText.isNotEmpty() &&  valorDelEditText.length >= 6 && passwordValue.isNotEmpty() && passwordValue.length >= 10

        }

        /* */
        binding.tilActivityLoginPassword.editText?.doOnTextChanged{ text, _, _, _ ->

            val valorDelEditText = text.toString().trim()
            val userValue = binding.tilActivityLoginUser.editText?.text.toString().trim()

            binding.btnActivityLoginLogin.isEnabled =
                valorDelEditText.isNotEmpty() && valorDelEditText.length >= 10 && userValue.isNotEmpty() &&  userValue.length >= 6

        }

        /* */
        binding.tilActivityLoginUser.editText?.setOnFocusChangeListener { _ , _ ->
            binding.tvActivityLoginError.visibility = View.GONE
            binding.tilActivityLoginUser.error = null
            binding.tilActivityLoginPassword.error = null
        }

        /* */
        binding.tilActivityLoginPassword.editText?.setOnFocusChangeListener { _ , _ ->
            binding.tvActivityLoginError.visibility = View.GONE
            binding.tilActivityLoginUser.error = null
            binding.tilActivityLoginPassword.error = null
        }



    }

    /** */
    private fun onLogin() {

        with(binding){

            val userText = tilActivityLoginUser.editText?.text.toString()
            val passwordText = tilActivityLoginPassword.editText?.text.toString()

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

        Intent(this@LoginActivity,WelcomeActivity::class.java).apply{
            putExtra("nameByLogin", "Alan Altamira" )
            putExtra("age", 15 )
        }.also { startActivity(it) }

        finish()
    }

    /** */
    private fun showLoginTvError() {

        with(binding){

            tilActivityLoginUser.editText?.setText("")
            tilActivityLoginPassword.editText?.setText("")

            tilActivityLoginUser.clearFocus()
            tilActivityLoginPassword.clearFocus()

            tvActivityLoginError.visibility = View.VISIBLE

            tilActivityLoginUser.error = "Introduce tu usuario"
            tilActivityLoginPassword.error = "Introduce tu contraseña"

        }


    }

}