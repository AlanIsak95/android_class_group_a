package royal.master.academy.grupo_a.login.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import royal.master.academy.grupo_a.R
import royal.master.academy.grupo_a.data.Data
import royal.master.academy.grupo_a.data.UserLogged
import royal.master.academy.grupo_a.databinding.FragmentLoginBinding
import royal.master.academy.grupo_a.login.LoginViewModel
import royal.master.academy.grupo_a.login.status.LoginEnum
import royal.master.academy.grupo_a.utils.Tools
import royal.master.academy.grupo_a.utils.extension_fun.setBooleanSharedPreferences
import royal.master.academy.grupo_a.utils.extension_fun.showToast

class LoginFragment : Fragment() {

    private val loginViewModel : LoginViewModel by activityViewModels()

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    /** */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
        setUpListeners()
        setUpLiveDataListeners()

    }

    /** */
    private fun setUpLiveDataListeners() {

            loginViewModel.appVersion.observe(viewLifecycleOwner){textUpdated ->

                /* Se ejecuta esta parte del codigo cuando se obtiene algun cambio de la variable*/
                binding.tvFragmentLoginVersion.text = textUpdated

            }

    }


    /** */
    private fun setUpView() {

        Data.clearLoginUserList()

        with(binding){
            btnFragmentLoginLogin.isEnabled = false

            tvFragmentLoginError.text    = getString(R.string.activity_login_tv_error_text)
            tvFragmentLoginRegister.text = getString(R.string.activity_login_btn_register_text)
            btnFragmentLoginLogin.text   = getString(R.string.activity_login_btn_login_text)

            tvFragmentLoginError.visibility = View.GONE
        }

    }


    /** */
    private fun setUpListeners() {

        /* */
        binding.tvFragmentLoginList.setOnClickListener{

            //val name = binding.tilFragmentLoginUser.editText?.text.toString()
            //loginViewModel.name = name
            //showToast(loginViewModel.name)


            //val listCount = Data.getUserList().count().toString()
            //Tools.createToast(requireContext(), listCount)


            //val version = binding.tilFragmentLoginVersion.editText?.text.toString()
            //loginViewModel.appVersion.value = version

            findNavController().navigate(R.id.action_loginFragment_to_recyclerFragment)

        }

        /* */
        binding.tvFragmentLoginRegister.setOnClickListener {
            goToRegisterView()
        }

        /* */
        binding.btnFragmentLoginLogin.setOnClickListener {
            onLogin()
        }

        /* */
        binding.tilFragmentLoginVersion.editText?.doOnTextChanged { text, _, _, _ ->

            val valorDelEditText = text.toString().trim()
            loginViewModel.appVersion.value = valorDelEditText

        }

        /* */
        binding.tilFragmentLoginUser.editText?.doOnTextChanged { text, _, _, _ ->

            val valorDelEditText = text.toString().trim()
            val passwordValue = binding.tilFragmentLoginPassword.editText?.text.toString().trim()

            binding.btnFragmentLoginLogin.isEnabled =
                valorDelEditText.isNotEmpty() &&  valorDelEditText.length >= 6 && passwordValue.isNotEmpty() && passwordValue.length >= 4

        }

        /* */
        binding.tilFragmentLoginPassword.editText?.doOnTextChanged{ text, _, _, _ ->

            val valorDelEditText = text.toString().trim()
            val userValue = binding.tilFragmentLoginUser.editText?.text.toString().trim()

            binding.btnFragmentLoginLogin.isEnabled =
                valorDelEditText.isNotEmpty() && valorDelEditText.length >= 4 && userValue.isNotEmpty() &&  userValue.length >= 6

        }

        /* */
        binding.tilFragmentLoginUser.editText?.setOnFocusChangeListener { _ , _ ->
            binding.tvFragmentLoginError.visibility = View.GONE
            binding.tilFragmentLoginUser.error = null
            binding.tilFragmentLoginPassword.error = null
        }

        /* */
        binding.tilFragmentLoginPassword.editText?.setOnFocusChangeListener { _ , _ ->
            binding.tvFragmentLoginError.visibility = View.GONE
            binding.tilFragmentLoginUser.error = null
            binding.tilFragmentLoginPassword.error = null
        }



    }

    /** */
    private fun goToRegisterView() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

    /** */
    private fun onLogin() {

        with(binding){

            val userText = tilFragmentLoginUser.editText?.text.toString()
            val passwordText = tilFragmentLoginPassword.editText?.text.toString()


            Tools.loginWithCredentials(
                userName = userText,
                password = passwordText
            ){ loginEnum , userLogged ->

                when(loginEnum){
                    LoginEnum.SUCCESS -> {

                        setBooleanSharedPreferences(
                            sharedPreferenceId = "login",
                            loginSession = true
                        )

                        UserLogged.setUserLogged(userLogged)
                        goToWelcomeView()
                    }
                    LoginEnum.FAILURE -> showLoginTvError()

                }

            }

        }

    }


    /** */
    private fun goToWelcomeView() {

        binding.tvFragmentLoginError.visibility = View.GONE
        showToast("Ir a pantalla de Welcome")
        //findNavController().navigate(R.id.action_loginFragment_to_registerFragment)

    }


    /** */
    private fun showLoginTvError() {

        with(binding){

            tilFragmentLoginUser.editText?.setText("")
            tilFragmentLoginPassword.editText?.setText("")

            tilFragmentLoginUser.clearFocus()
            tilFragmentLoginPassword.clearFocus()

            tvFragmentLoginError.visibility = View.VISIBLE

            tilFragmentLoginUser.error = "Introduce tu usuario"
            tilFragmentLoginPassword.error = "Introduce tu contraseña"

        }


    }




    /** */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}