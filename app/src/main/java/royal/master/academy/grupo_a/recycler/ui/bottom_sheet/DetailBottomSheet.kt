package royal.master.academy.grupo_a.recycler.ui.bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import royal.master.academy.grupo_a.databinding.FragmentDetailBottomSheetBinding
import royal.master.academy.grupo_a.recycler.data.ItemSelectedValue


class DetailBottomSheet : BottomSheetDialogFragment() {

    private var _binding: FragmentDetailBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
        setUpListener()
    }

    /** */
    private fun setUpListener() {
        binding.tvFragmentDetailBottomSheetExit.setOnClickListener {
            dismiss()
        }
    }

    /** */
    private fun setUpView() {
        isCancelable = false

        val name = ItemSelectedValue.getUser().name
        binding.tvFragmentDetailBottomSheetName.text = name

    }

}