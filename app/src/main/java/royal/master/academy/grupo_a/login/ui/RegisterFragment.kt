package royal.master.academy.grupo_a.login.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.textfield.TextInputLayout
import royal.master.academy.grupo_a.data.room.entities.UserEntity
import royal.master.academy.grupo_a.databinding.FragmentRegisterBinding
import royal.master.academy.grupo_a.login.LoginViewModel
import royal.master.academy.grupo_a.login.status.InsertUserDBStatus
import royal.master.academy.grupo_a.utils.extension_fun.showToast

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

            with(binding){

                btnFragmentRegisterRegister.isEnabled = false

                registerViewModel.insertUserVM(
                    context = requireContext(),
                    userEntity = getUserByTILs()
                ){

                    when(it){
                        InsertUserDBStatus.Load -> clFragmentRegisterContainer.visibility = View.VISIBLE
                        InsertUserDBStatus.HideLoader -> clFragmentRegisterContainer.visibility = View.GONE
                        is InsertUserDBStatus.Failure -> {
                            btnFragmentRegisterRegister.isEnabled = true
                            showToast(it.errorMessage)
                        }
                        is InsertUserDBStatus.Success -> {
                            showToast(it.successMessage)
                            activity?.onBackPressedDispatcher?.onBackPressed()
                        }
                    }

                }

            }

        }

    }

    private fun getUserByTILs(): UserEntity {

        with(binding){
            val name = tilFragmentRegisterName.getText()
            val email = tilFragmentRegisterEmail.getText()
            val phone = tilFragmentRegisterPhoneNumber.getText()
            val password = tilFragmentRegisterPassword.getText()

            return UserEntity(
                userID = phone,
                name = name,
                email = email,
                phoneNumber = phone,
                password = password
            )

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