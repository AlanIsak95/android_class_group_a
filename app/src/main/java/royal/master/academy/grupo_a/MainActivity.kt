package royal.master.academy.grupo_a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        /*Empezar nuestro codigo*/
        setName("Hola a todos!")

    }

    /** */
    private fun setName(name : String){

        /*Decimos a la vista que queremos poner en el atributo [texto]
        * de nuestro Objeto [TextView](de la vista) por medio del objeto [binding]
        * el cual contiene todas las referencias de nuestra vista (xml)
        * */
        //binding.txtTitle.text = name

    }


}