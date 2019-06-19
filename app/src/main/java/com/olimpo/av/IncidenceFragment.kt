package com.olimpo.av

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olimpo.av.incidence.IncidenceAdapter
import com.olimpo.av.score.QuestItem
import kotlinx.android.synthetic.main.dialog_incidence.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [IncidenceFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [IncidenceFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class IncidenceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private val adapter by lazy { IncidenceAdapter(emptyList()) }
    private lateinit var linearLayoutManager: LinearLayoutManager

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
        return inflater.inflate(R.layout.dialog_incidence, container, false)
    }

    override fun onStart() {
        super.onStart()
        lyt_title_dialog.setBackgroundResource(R.color.colorWhite)
        btn_photo_evidence.visibility = View.GONE
        val list: MutableList<QuestItem> = ArrayList()
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val params = rv_option_refund.layoutParams as ConstraintLayout.LayoutParams
        params.matchConstraintPercentHeight = 0.72f
        rv_option_refund.layoutParams = params
        adapter.list = list
        rv_option_refund.adapter = adapter
        rv_option_refund.layoutManager = linearLayoutManager

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
         * @return A new instance of fragment IncidenceFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            IncidenceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
