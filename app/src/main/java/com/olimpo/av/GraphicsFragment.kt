package com.olimpo.av

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lecho.lib.hellocharts.view.LineChartView
import android.graphics.Color.parseColor
import android.R.attr.top
import androidx.databinding.adapters.TextViewBindingAdapter.setTextSize
import kotlinx.android.synthetic.main.fragment_graphics.*
import lecho.lib.hellocharts.model.*
import lecho.lib.hellocharts.model.LineChartData
import lecho.lib.hellocharts.model.PointValue


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

var lineChartView: LineChartView? = null
var axisData = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec")
var yAxisData = intArrayOf(50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18)

var axisData2 = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec")
var yAxisData2 = intArrayOf(10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21)


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [GraphicsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [GraphicsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class GraphicsFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_graphics, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onStart() {
        super.onStart()
//        val yAxisValues: MutableList<PointValue> = ArrayList()
//        val axisValues: MutableList<AxisValue> = ArrayList()
//
//        val yAxisValues2: MutableList<PointValue> = ArrayList()
//        val axisValues2: MutableList<AxisValue> = ArrayList()
//
//
//        val line = Line(yAxisValues).setColor(Color.parseColor("#9C27B0"))
//        val line2 = Line(yAxisValues2).setColor(Color.parseColor("#FF336D"))
//
//        for (i in 0 until axisData.size) {
//            axisValues.add(i, AxisValue(i.toFloat()).setLabel(axisData[i]))
//        }
//
//        for (i in 0 until yAxisData.size) {
//            yAxisValues.add(PointValue(i.toFloat(), yAxisData[i].toFloat()))
//        }
//
//
//        for (i in 0 until axisData2.size) {
//            axisValues2.add(i, AxisValue(i.toFloat()).setLabel(axisData2[i]))
//        }
//
//        for (i in 0 until yAxisData2.size) {
//            yAxisValues2.add(PointValue(i.toFloat(), yAxisData2[i].toFloat()))
//        }
//
//        val lines: MutableList<Line> = ArrayList()
//        lines.add(line)
//
//        val lines2: MutableList<Line> = ArrayList()
//        lines2.add(line2)
//
//        val data = LineChartData()
//        data.lines = lines
//
//        val data2 = LineChartData()
//        data2.lines = lines2
//
        val axis = Axis()
//        axis.setValues(axisValues)
        axis.name = "DIA DEL MES"
//        axis.setTextSize(16)
        axis.setTextColor(Color.parseColor("#03A9F4"))
        axis.setHasLines(true)
//        data.axisXBottom = axis
//
        val yAxis = Axis()
        yAxis.setName("TOTALES")
        yAxis.setHasLines(true)
        yAxis.setTextColor(Color.parseColor("#03A9F4"))
//        yAxis.setTextSize(16)
//        data.axisYLeft = yAxis
//
//
//
//        line_chart.setLineChartData(data)
//        line_chart.setLineChartData(data2)
//        val viewport = Viewport(line_chart.getMaximumViewport())
//        line_chart.top = 110
//        line_chart.setMaximumViewport(viewport)
//        line_chart.setCurrentViewport(viewport)

        val values = ArrayList<PointValue>()
        values.add(PointValue(0f, 2f))
        values.add(PointValue(1f, 4f))
        values.add(PointValue(2f, 3f))
        values.add(PointValue(3f, 4f))

        val values2 = ArrayList<PointValue>()
        values2.add(PointValue(0f, 2f))
        values2.add(PointValue(8f, 10f))
        values2.add(PointValue(9f, 11f))
        values2.add(PointValue(10f, 12f))

        //In most cased you can call data model methods in builder-pattern-like manner.
        val line = Line(values).setColor(Color.BLUE).setCubic(true)
        val line2 = Line(values2).setColor(Color.RED).setCubic(true)

        line.setHasPoints(false)
        line.setFilled(true)

        line2.setHasPoints(false)
        line2.setFilled(true)


        val lines = ArrayList<Line>()
        lines.add(line)
        lines.add(line2)



        val data = LineChartData()
        data.lines = lines
        data.axisXBottom =axis
        data.axisYLeft = yAxis


//        val chart = LineChartView(context)
//        chart.lineChartData = data

        line_chart.lineChartData = data
//        line_chart.grid


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
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
         * @return A new instance of fragment GraphicsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GraphicsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
