package royal.master.academy.grupo_a.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import royal.master.academy.grupo_a.data.Data
import royal.master.academy.grupo_a.databinding.ActivityRegisterBinding
import royal.master.academy.grupo_a.utils.Tools

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

            Data.addUser(userToSaveInCache)
            finish()

        }

    }

    /** */
    private fun setUpView() {

        binding.tvActivityRegisterTitle.text = "Registrate es gratis"
        binding.btnActivityRegisterRegister.text = "Registrar Usuario"

    }


    /*
    data class User(
    val name : String,
    val email : String = "invitado@royal.com",
    val phoneNumber : String = "11111111",
    val password : String,
    val userName : String
)
     */




}