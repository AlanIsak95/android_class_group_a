package royal.master.academy.grupo_a.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import royal.master.academy.grupo_a.databinding.ActivityLoginNcActivityBinding
import royal.master.academy.grupo_a.utils.extension_fun.showToast

class LoginNCActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginNcActivityBinding

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginNcActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setOnClickListener()

    }

    /** */
    private fun setOnClickListener() {

    }

}