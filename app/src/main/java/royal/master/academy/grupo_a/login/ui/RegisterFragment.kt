package royal.master.academy.grupo_a.login.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.textfield.TextInputLayout
import royal.master.academy.grupo_a.data.Data
import royal.master.academy.grupo_a.databinding.FragmentRegisterBinding
import royal.master.academy.grupo_a.login.LoginViewModel
import royal.master.academy.grupo_a.utils.Tools


class RegisterFragment : Fragment() {

    /* */
    private val registerViewModel : LoginViewModel by activityViewModels()

    private var _binding: FragmentRegisterBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    /** */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
        setUpLiveDataListeners()
        setUpListeners()

    }


    /** */
    private fun setUpView() {

        binding.tvFragmentRegisterTitle.text = "Registrate es gratis"
        binding.btnFragmentRegisterRegister.text = "Registrar Usuario"

    }

    /** Funcion normal */
    private fun getText2(ed : TextInputLayout):String{
        return ed.editText?.text.toString()
    }

    /** Funcion de Ext*/
    private fun TextInputLayout.getText() = this.editText?.text.toString()


    /** */
    private fun setUpListeners() {

        binding.btnFragmentRegisterRegister.setOnClickListener {

            binding.clFragmentRegisterContainer.visibility = View.VISIBLE
            binding.btnFragmentRegisterRegister.isEnabled = false

            val name     = binding.tilFragmentRegisterName.getText()
            val email    = binding.tilFragmentRegisterEmail.getText()
            val phone    = binding.tilFragmentRegisterPhoneNumber.getText()
            val password = getText2(binding.tilFragmentRegisterPassword)

            val userToSaveInCache = Tools.createUser(
                name = name,
                email = email,
                phoneNumber = phone,
                password = password
            )

            Handler(Looper.getMainLooper()).postDelayed({

                val userName = userToSaveInCache.userName
                Tools.createToast(requireContext(), "Registro Exitoso, tu usuario es : $userName")

            },1_000)


            Handler(Looper.getMainLooper()).postDelayed({

                Data.addUser(userToSaveInCache)
                activity?.onBackPressedDispatcher?.onBackPressed()

            },2_000)


        }

    }

    /** */
    private fun setUpLiveDataListeners() {

        registerViewModel.appVersion.observe(viewLifecycleOwner){textUpdated ->

            /* Se ejecuta esta parte del codigo cuando se obtiene algun cambio de la variable*/
            binding.tvFragmentRegisterVersion.text = textUpdated

        }

    }


    /** */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}