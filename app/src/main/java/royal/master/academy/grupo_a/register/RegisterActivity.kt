package royal.master.academy.grupo_a.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.google.android.material.textfield.TextInputLayout
import royal.master.academy.grupo_a.data.Data
import royal.master.academy.grupo_a.databinding.ActivityRegisterBinding
import royal.master.academy.grupo_a.utils.Tools
import royal.master.academy.grupo_a.utils.Tools.createToast

class RegisterActivity : AppCompatActivity() {

    /* */
    private lateinit var binding : ActivityRegisterBinding

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpView()
        setUpListeners()

    }

    /** Funcion normal */
    fun getText2(ed : TextInputLayout):String{
        return ed.editText?.text.toString()
    }

    /** Funcion de Ext*/
    fun TextInputLayout.getText() = this.editText?.text.toString()


    /** */
    private fun setUpListeners() {

        binding.btnActivityRegisterRegister.setOnClickListener {

            binding.clActivityRegisterContainer.visibility = View.VISIBLE
            binding.btnActivityRegisterRegister.isEnabled = false

            val name     = binding.tilActivityRegisterName.getText()
            val email    = binding.tilActivityRegisterEmail.getText()
            val phone    = binding.tilActivityRegisterPhoneNumber.getText()
            val password = getText2(binding.tilActivityRegisterPassword)

            val userToSaveInCache = Tools.createUser(
                name = name,
                email = email,
                phoneNumber = phone,
                password = password
            )

            Handler(Looper.getMainLooper()).postDelayed({

                val userName = userToSaveInCache.userName

                createToast(this,"Registro Exitoso, tu usuario es : $userName")

            },1_000)


            Handler(Looper.getMainLooper()).postDelayed({

                Data.addUser(userToSaveInCache)
                finish()

            },2_000)


        }

    }

    /** */
    private fun setUpView() {

        binding.tvActivityRegisterTitle.text = "Registrate es gratis"
        binding.btnActivityRegisterRegister.text = "Registrar Usuario"

    }



}