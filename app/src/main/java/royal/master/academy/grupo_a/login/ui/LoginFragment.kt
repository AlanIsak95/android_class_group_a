package royal.master.academy.grupo_a.login.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import royal.master.academy.grupo_a.R
import royal.master.academy.grupo_a.databinding.FragmentLoginBinding
import royal.master.academy.grupo_a.utils.extension_fun.showToast

class LoginFragment : Fragment() {

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

        setUpListeners()

    }

    /** */
    private fun setUpListeners() {

        binding.tvFragmentLoginList.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }


    /** */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}