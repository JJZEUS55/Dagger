package com.olimpo.av.incidence

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olimpo.av.R
import com.olimpo.av.score.QuestItem
import com.olimpo.av.score.ScoreAdapter
import kotlinx.android.synthetic.main.dialog_incidence.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class IncidenceDialog : DialogFragment() {
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

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onStart() {
        super.onStart()
        dialog?.let {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            it.window?.setLayout(width, height)
        }

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

        rv_option_refund.adapter = adapter
        rv_option_refund.layoutManager = linearLayoutManager

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
}
