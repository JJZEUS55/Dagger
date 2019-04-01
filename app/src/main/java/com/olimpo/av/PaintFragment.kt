package com.olimpo.av

import android.Manifest
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.github.gcacace.signaturepad.views.SignaturePad
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_paint.*
import java.io.File
import java.io.IOException
import android.os.Environment.DIRECTORY_PICTURES
import android.os.Environment.getExternalStoragePublicDirectory
import android.util.Log
import java.io.FileOutputStream
import android.content.Intent
import androidx.core.app.ActivityCompat
import android.content.pm.PackageManager
import android.Manifest.permission
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.navigation.Navigation


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [PaintFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [PaintFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class PaintFragment : Fragment() {
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

    override fun onStart() {
        super.onStart()
        btn_save.setOnClickListener {
            //            Bitmap signatureBitmap = mSignaturePad . getSignatureBitmap ()

            val signatureBitmap: Bitmap = signature_pad.signatureBitmap

            if (addJpgSignatureToGallery(signatureBitmap)) {
                Toast.makeText(context, "Signature saved into the Gallery", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Unable to store the signature", Toast.LENGTH_SHORT).show()
            }
        }

        btn_clear.setOnClickListener {
            signature_pad.clear()
//            Toast.makeText(context, "FRAG 2", Toast.LENGTH_SHORT).show()
        }

        btn_close.setOnClickListener { v ->
            Navigation.findNavController(v).popBackStack()
            Toast.makeText(context, "Before Fragment", Toast.LENGTH_SHORT).show()

        }

        signature_pad.setOnSignedListener(object : SignaturePad.OnSignedListener {
            override fun onStartSigning() {
//                Toast.makeText(context, "OnStartSigning", Toast.LENGTH_SHORT).show();
            }

            override fun onClear() {
                btn_save.isEnabled = false
                btn_clear.isEnabled = true
            }

            override fun onSigned() {
                btn_save.isEnabled = true
                btn_clear.isEnabled = true
            }
        })
    }

    fun getAlbumStorageDir(albumName: String): File {
        // Get the directory for the user's public pictures directory.
        val file = File(
            Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES
            ), albumName
        )
        if (!file.mkdirs()) {
            Log.e("SignaturePad", "Directory not created")
        }
        return file
    }

    @Throws(IOException::class)
    fun saveBitmapToJPG(bitmap: Bitmap, photo: File) {
        val newBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(newBitmap)
        canvas.drawColor(Color.WHITE)
        canvas.drawBitmap(bitmap, 0.toFloat(), 0.toFloat(), null)
        val stream = FileOutputStream(photo)
        newBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream)
        stream.close()
    }

    fun addJpgSignatureToGallery(signature: Bitmap): Boolean {
        var result = false
        try {
            //TODO CAMBIAR signature por nombre de la persona
            val photo =
                File("/storage/emulated/0/DCIM", String.format("Signature_%d.jpg", System.currentTimeMillis()))
            saveBitmapToJPG(signature, photo)
            scanMediaFile(photo)
            result = true
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return result
    }

    private fun scanMediaFile(photo: File) {
        val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
        val contentUri = Uri.fromFile(photo)
        mediaScanIntent.data = contentUri
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        return inflater.inflate(R.layout.fragment_paint, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = activity as OnFragmentInteractionListener
            listener!!.onFragmentInteraction(Uri.parse("doWhatYouWant"))
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener")
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
         * @return A new instance of fragment PaintFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PaintFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

//    fun verifyStoragePermissions(activity: Activity) {
//        // Check if we have write permission
//        val permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//
//        if (permission != PackageManager.PERMISSION_GRANTED) {
//            // We don't have permission so prompt the user
//            ActivityCompat.requestPermissions(
//                activity,
//                PERMISSIONS_STORAGE,
//                REQUEST_EXTERNAL_STORAGE
//            )
//        }
//    }

}
