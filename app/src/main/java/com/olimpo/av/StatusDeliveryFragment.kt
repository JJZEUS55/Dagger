package com.olimpo.av

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olimpo.av.unit.StatusDelivery
import kotlinx.android.synthetic.main.fragment_status_delivery.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [fragment_status_delivery.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [fragment_status_delivery.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class fragment_status_delivery : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private lateinit var adapter: StatusDeliveryAdapter
    private lateinit var linearLaManager: LinearLayoutManager

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
        return inflater.inflate(R.layout.fragment_status_delivery, container, false)
    }

    override fun onStart() {
        super.onStart()
        val list: MutableList<StatusDelivery> = ArrayList()
        list.add(StatusDelivery("Orden recibida en LDC", "00:13", "17/mayo/19", 8))
        list.add(StatusDelivery("Orden recibida en LDC", "00:13", "17/mayo/19", 0))
        list.add(StatusDelivery("Orden recibida en LDC", "00:13", "17/mayo/19", 0))
        list.add(StatusDelivery("Orden recibida en LDC", "00:13", "17/mayo/19", 8))

        linearLaManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter = StatusDeliveryAdapter(list)
        rv_status_order.adapter = adapter
        rv_status_order.layoutManager = linearLaManager
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
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
         * @return A new instance of fragment fragment_status_delivery.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_status_delivery().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
