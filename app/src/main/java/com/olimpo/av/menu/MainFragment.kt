package com.olimpo.av.menu

import android.content.Context
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.olimpo.av.R
import com.olimpo.av.dialog.DialogGeneric
import com.olimpo.av.dialogModMount.DialogModAmount
import com.olimpo.av.incidence.IncidenceDialog
import kotlinx.android.synthetic.main.fragment_main.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MainFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

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
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onStart() {
        super.onStart()

        btn_frag2.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_login)
        }

        btn_menu.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_menuFragment)
        }

        btn_dialog.setOnClickListener {
            val dialogGen : DialogGeneric = DialogGeneric()
            dialogGen.show(fragmentManager!!, "DialogGen")
        }

        btn_status.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_fragment_status_delivery)
        }

        btn_entrega.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_deliveryFragment)
        }

        btn_score_delivery.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_scoreDeliveryFragment)
        }

        btn_wo_order.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_withOutOrderFragment)
        }

        btn_terms.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_fragmentTerms)
        }

        btn_scanner.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_scannerFragment)
        }

        btn_detail_driver.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_deliveryDetailFragment)
        }

        btn_incidence.setOnClickListener {
            val dialogIncidenceDialog = IncidenceDialog()
            dialogIncidenceDialog.show(fragmentManager!!, "DialogIncidence")
        }

        btn_special.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_specialDeliveryFragment2)
        }

        btn_incidence_fragment.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_incidenceFragment)
        }

        btn_firma.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_paintFragment)
        }

        btn_mont_mod.setOnClickListener {
            val dialog = DialogModAmount()
            dialog.show(fragmentManager!!, "dialogmodamount")
        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
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
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
