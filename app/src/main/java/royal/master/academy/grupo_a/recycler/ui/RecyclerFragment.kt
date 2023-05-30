package royal.master.academy.grupo_a.recycler.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import royal.master.academy.grupo_a.R
import royal.master.academy.grupo_a.databinding.FragmentRecyclerBinding
import royal.master.academy.grupo_a.recycler.adapter.MyAdapter


class RecyclerFragment : Fragment() {

    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* */
        setUpView()

    }

    /** */
    private fun setUpView() {

        val data = listOf("Alan","Juan","Oscar","Maria","Xime","Saul","Roberto",
            "Alan","Juan","Oscar","Maria","Xime","Saul","Roberto",
            "Alan","Juan","Oscar","Maria","Xime","Saul","Roberto",
            "Alan","Juan","Oscar","Maria","Xime","Saul","Roberto",
            "Alan","Juan","Oscar","Maria","Xime","Saul","Roberto")
        val myAdapter = MyAdapter(dataList = data)

        with(binding){

            rvFragmentRecycler.layoutManager = LinearLayoutManager(requireContext())
            rvFragmentRecycler.adapter = myAdapter

        }

    }


}