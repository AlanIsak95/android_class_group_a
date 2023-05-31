package royal.master.academy.grupo_a.recycler.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import royal.master.academy.grupo_a.databinding.FragmentRecyclerBinding
import royal.master.academy.grupo_a.recycler.adapter.MyAdapter
import royal.master.academy.grupo_a.recycler.data.Address
import royal.master.academy.grupo_a.recycler.data.UserItem


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

        val myAdapter = MyAdapter(dataList =  getUserItem())

        with(binding){

            rvFragmentRecycler.layoutManager = LinearLayoutManager(requireContext())
            rvFragmentRecycler.adapter = myAdapter

        }

    }

    /** Obtiene los valores en duro de una lista de usuarios */
    private fun getUserItem():List<UserItem> {

        val address1 = Address(
            number = 10,
            streetName = "Calle 20",
            zipCode = "01180"
        )

        val addressDefault = Address()

        val address2 = Address(
            number = 605,
            streetName = "Benito",
            zipCode = "56874"
        )


        val user1 = UserItem(
            name = "Alan",
            age = 50,
            address = address1
        )

        val user2 = UserItem(
            name = "Juan",
            age = 15,
            address = addressDefault
        )

        val user3 = UserItem(
            name = "Alma",
            age = 28,
            address = address2
        )

        val user4 = UserItem(
            name = "Angel",
            age = 46,
            address = address1
        )

        val user5 = UserItem()
        user5.toString()

        return listOf(user1,user2,user3,user4,user5)

    }


}