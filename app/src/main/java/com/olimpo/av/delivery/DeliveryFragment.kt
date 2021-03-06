package com.olimpo.av.delivery

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olimpo.av.R
import com.olimpo.av.unit.DeliveryItem
import kotlinx.android.synthetic.main.fragment_delivery.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DeliveryFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [DeliveryFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DeliveryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: DeliveryAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delivery, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onStart() {
        super.onStart()
        val list: MutableList<DeliveryItem> = ArrayList()
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))
        list.add(DeliveryItem(12345678, "CAJA-35PZAS", 1))

        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter = DeliveryAdapter(list)
        rv_order.adapter = adapter
//        rv_order.isNestedScrollingEnabled = false
        rv_order.layoutManager = linearLayoutManager

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DeliveryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DeliveryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
