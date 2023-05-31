package royal.master.academy.grupo_a.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import royal.master.academy.grupo_a.data.Data
import royal.master.academy.grupo_a.databinding.ActivitySplashBinding
import royal.master.academy.grupo_a.login.LoginNCActivity
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
        setUpListeners()
        Data.clearLoginUserList()

    }
   /** */
    private fun setUpListeners() {

       /* */
       binding.animationView.setOnClickListener{

           with(binding.animationView){

               if (isAnimating.not())
                   playAnimation()

           }

       }

    }

    /** */
    private fun redirection() {

        val userLogged = getBooleanSharedPreferences("login")


        Handler(Looper.getMainLooper()).postDelayed({

           if (userLogged)
               Intent(this,WelcomeActivity::class.java).also { startActivity(it) }
           else
               Intent(this,LoginNCActivity::class.java).also { startActivity(it) }

            finish()

        },1_000)


    }


}