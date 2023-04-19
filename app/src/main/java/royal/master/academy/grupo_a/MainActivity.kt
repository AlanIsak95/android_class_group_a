package royal.master.academy.grupo_a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import royal.master.academy.grupo_a.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /* */
    private lateinit var binding : ActivityMainBinding

    /** Un Activy es una vista de tu Aplicacion*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*Indicar que vista se mostrara*/
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpView()
        setUpListeners()

    }

    /** */
    private fun setUpView() {

        Toast.makeText(this,"La vista ha sido cargada",Toast.LENGTH_LONG).show()

    }

    /** */
    private fun setUpListeners() {

        /* */
        binding.btnActivityMainShow.setOnClickListener {


            with(binding){

                val name = etActivityMainTitle.text.toString()

                if (name.trim().isEmpty())
                    Toast.makeText(this@MainActivity,"Necesito tu nombre",Toast.LENGTH_SHORT).show()

                tvActivityMainText.text = name

                if (name == "Alan"){
                    tvActivityMainTextHidden.visibility = View.VISIBLE
                    tvActivityMainTextHidden.text = "HOLA! $name"
                }else{
                    tvActivityMainTextHidden.visibility = View.INVISIBLE
                    tvActivityMainTextHidden.text = ""
                }

            }

        }

    }

}