package royal.master.academy.grupo_a.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import royal.master.academy.grupo_a.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    /* */
    private lateinit var binding : ActivityWelcomeBinding

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpView()

    }

    private fun setUpView() {

        val nameByLogin = intent.getStringExtra("nameByLogin")
        val ageByLogin = intent.getIntExtra("age",50)
        binding.tvActivityWelcomeTitle.text = "Bienvenido $nameByLogin tu edad es $ageByLogin"

    }


}