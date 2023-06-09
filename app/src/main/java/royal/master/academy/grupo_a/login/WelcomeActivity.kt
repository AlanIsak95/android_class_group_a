package royal.master.academy.grupo_a.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import royal.master.academy.grupo_a.databinding.ActivityWelcomeBinding
import royal.master.academy.grupo_a.splash.SplashActivity
import royal.master.academy.grupo_a.utils.extension_fun.setBooleanSharedPreferences

class WelcomeActivity : AppCompatActivity() {

    // TODO: Agregar Lottie

    /* */
    private lateinit var binding : ActivityWelcomeBinding

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpView()

        binding.tvActivityWelcomeTitle.setOnClickListener {

            setBooleanSharedPreferences("login",false)
            Intent(this,SplashActivity::class.java).also { startActivity(it) }
            finish()

        }

    }

    private fun setUpView() {

        binding.tvActivityWelcomeTitle.text = "Alan"


    }


}