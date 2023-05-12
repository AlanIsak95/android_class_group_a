package royal.master.academy.grupo_a.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import royal.master.academy.grupo_a.R
import royal.master.academy.grupo_a.data.Data
import royal.master.academy.grupo_a.data.UserLogged
import royal.master.academy.grupo_a.databinding.ActivityLoginBinding
import royal.master.academy.grupo_a.login.status.LoginEnum
import royal.master.academy.grupo_a.register.RegisterActivity
import royal.master.academy.grupo_a.utils.Tools
import royal.master.academy.grupo_a.utils.Tools.createToast
import royal.master.academy.grupo_a.utils.extension_fun.setBooleanSharedPreferences

class LoginActivity : AppCompatActivity() {

    /* Aprendiendo GIT basico*/

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

        Data.clearLoginUserList()

        with(binding){
            btnActivityLoginLogin.isEnabled = false

            tvActivityLoginError.text    = getString(R.string.activity_login_tv_error_text)
            tvActivityLoginRegister.text = getString(R.string.activity_login_btn_register_text)
            btnActivityLoginLogin.text   = getString(R.string.activity_login_btn_login_text)

            tvActivityLoginError.visibility = View.GONE
        }

    }


    /** */
    private fun setUpListeners() {

        /* */
        binding.tvActivityLoginList.setOnClickListener{

            val listCount = Data.getUserList().count().toString()
            createToast(this,listCount)

        }

        /* */
        binding.tvActivityLoginRegister.setOnClickListener {
            goToRegisterView()
        }

        /* */
        binding.btnActivityLoginLogin.setOnClickListener {
            onLogin()
        }

        /* */
        binding.tilActivityLoginUser.editText?.doOnTextChanged { text, _, _, _ ->

            val valorDelEditText = text.toString().trim()
            val passwordValue = binding.tilActivityLoginPassword.editText?.text.toString().trim()

            binding.btnActivityLoginLogin.isEnabled =
                valorDelEditText.isNotEmpty() &&  valorDelEditText.length >= 6 && passwordValue.isNotEmpty() && passwordValue.length >= 4

        }

        /* */
        binding.tilActivityLoginPassword.editText?.doOnTextChanged{ text, _, _, _ ->

            val valorDelEditText = text.toString().trim()
            val userValue = binding.tilActivityLoginUser.editText?.text.toString().trim()

            binding.btnActivityLoginLogin.isEnabled =
                valorDelEditText.isNotEmpty() && valorDelEditText.length >= 4 && userValue.isNotEmpty() &&  userValue.length >= 6

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


            Tools.loginWithCredentials(
                userName = userText,
                password = passwordText
            ){ loginEnum , userLogged ->

                when(loginEnum){
                    LoginEnum.SUCCESS -> {

                        setBooleanSharedPreferences(
                            sharedPreferenceId = "login",
                            loginSession = true
                        )

                        /*TODO guardar datos nombre y telefono en SP.*/

                        UserLogged.setUserLogged(userLogged)
                        goToWelcomeView()
                    }
                    LoginEnum.FAILURE -> showLoginTvError()

                }

            }

        }

    }

    /** */
    private fun goToWelcomeView() {

        binding.tvActivityLoginError.visibility = View.GONE

        Intent(this@LoginActivity,WelcomeActivity::class.java)
            .also{startActivity(it)}

        finish()
    }

    /** */
    private fun goToRegisterView() {

        Intent(this@LoginActivity,RegisterActivity::class.java).also { startActivity(it) }

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