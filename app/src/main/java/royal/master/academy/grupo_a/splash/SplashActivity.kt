package royal.master.academy.grupo_a.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import royal.master.academy.grupo_a.databinding.ActivitySplashBinding
import royal.master.academy.grupo_a.login.LoginActivity
import royal.master.academy.grupo_a.login.WelcomeActivity
import royal.master.academy.grupo_a.utils.extension_fun.getBooleanSharedPreferences

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    /* */
    private lateinit var binding : ActivitySplashBinding

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        redirection()

    }

    /** */
    private fun redirection() {

        val userLogged = getBooleanSharedPreferences("login")


        Handler(Looper.getMainLooper()).postDelayed({

           if (userLogged)
               Intent(this,WelcomeActivity::class.java).also { startActivity(it) }
           else
               Intent(this,LoginActivity::class.java).also { startActivity(it) }

            finish()

        },2_000)


    }


}