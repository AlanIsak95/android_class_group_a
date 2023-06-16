package royal.master.academy.grupo_a.recycler.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import royal.master.academy.grupo_a.data.retrofit.RetrofitConnection
import royal.master.academy.grupo_a.data.retrofit.entity.get_character.GetCharacterResponse
import royal.master.academy.grupo_a.data.retrofit.entity.get_character.Result
import royal.master.academy.grupo_a.databinding.FragmentRecyclerBinding
import royal.master.academy.grupo_a.recycler.adapter.MyAdapter
import royal.master.academy.grupo_a.recycler.data.Address
import royal.master.academy.grupo_a.recycler.data.ItemSelectedValue
import royal.master.academy.grupo_a.recycler.data.UserItem
import royal.master.academy.grupo_a.recycler.enums.SetData
import royal.master.academy.grupo_a.utils.extension_fun.showToast
import royal.master.academy.grupo_a.utils.extension_fun.toUserItemList


class RecyclerFragment : Fragment() {

    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    /* Variable para seleccionar de donde llenar el Recycler*/
    private val getDataSource = SetData.Retrofit

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

        when(getDataSource){
            SetData.Retrofit -> getFromRetrofit()
            SetData.Dummy -> getDummyData()
        }

    }

    private fun getFromRetrofit() {
        RetrofitConnection().apiService.getCharacters().enqueue(object : Callback<GetCharacterResponse>{
            override fun onResponse(
                call: Call<GetCharacterResponse>,
                response: Response<GetCharacterResponse>
            ) {
                val characterList = response.body()?.results?: emptyList()
                showInRecycler(characterList)
            }

            override fun onFailure(call: Call<GetCharacterResponse>, t: Throwable) {
                showToast("Error")
            }

        })
    }

    // Cargar datos remotos en lista
    private fun showInRecycler(list : List<Result>) {

        val myAdapter = MyAdapter(dataList =  list.toUserItemList())

        with(binding){

            rvFragmentRecycler.layoutManager = LinearLayoutManager(requireContext())
            rvFragmentRecycler.adapter = myAdapter

        }


    }

    /** Cargar datos locales, no de Room*/
    private fun getDummyData() {

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
            address = address1,
            imageURLValue = "https://static.fundacion-affinity.org/cdn/farfuture/PVbbIC-0M9y4fPbbCsdvAD8bcjjtbFc0NSP3lRwlWcE/mtime:1643275542/sites/default/files/los-10-sonidos-principales-del-perro.jpg"
        )

        val user2 = UserItem(
            name = "Juan",
            age = 15,
            address = addressDefault,
            imageURLValue = "https://www.purina-latam.com/sites/default/files/styles/social_share_large/public/purina-10-datos-curiosos-sobre-los-gatos.png?itok=SRb_m7Tx"
        )

        val user3 = UserItem(
            name = "Alma",
            age = 28,
            address = address2,
            imageURLValue ="https://img.freepik.com/foto-gratis/primer-plano-pato-cerca-estanque-zoologico_181624-51048.jpg?w=2000"
        )

        val user4 = UserItem(
            name = "Angel",
            age = 46,
            address = address1,
            imageURLValue = "https://www.nationalgeographic.com.es/medio/2022/12/12/leon-1_b21b27e1_221212155936_1280x720.jpg"
        )

        val user5 = UserItem(
            imageURLValue = "https://t2.ea.ltmcdn.com/es/posts/4/9/9/curiosidades_del_tigre_25994_orig.jpg"
        )

        user5.toString()

        return listOf(user1,user2,user3,user4,user5)

    }

    override fun onDetach() {
        super.onDetach()
        ItemSelectedValue.clearUser()
    }


}