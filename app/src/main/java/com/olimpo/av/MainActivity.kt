package com.olimpo.av

import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView
import dagger.Module
import dagger.Provides
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Scope


@Qualifier
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class Choose(val value: String = "")



class MainActivity : AppCompatActivity(),
    MainFragment.OnFragmentInteractionListener,
    PaintFragment.OnFragmentInteractionListener,
    BFragment.OnFragmentInteractionListener,
    MenuFragment.OnFragmentInteractionListener,
    NavigationView.OnNavigationItemSelectedListener {

    @Inject
    @field:Choose("Love")
    lateinit var info: Info
    @Inject
    @field:Choose("Hello")
    lateinit var info2: Info

    private lateinit var magicBox: MagicBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMagicBox.create().poke(this)
        magicBox = DaggerMagicBox.create()


        textView.text = info.text
        textView.append("--------" + info2.text)

        btn_dagger.setOnClickListener {
            val storage = Storage()
            magicBox.pokeStore(storage)
            textView.text = "Unique ${storage.uniqueMagic.count} " +
                    "\nNormal ${storage.normalMagic.count}"
        }
//        val manager: FragmentManager = supportFragmentManager
//        val mainFragment: Fragment = MainFragment()
//
//        manager.beginTransaction().add(R.id.nav_host_fragment, mainFragment).commit()

    }

    override fun onFragmentInteraction(uri: Uri) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class Info(val text: String) {

//    @Provides
//    fun sayLove(): Info {
//        return Info("Love Dagger")
//    }

}

var staticCounter = 0

@ScopeFragment
class UniqueMagic @Inject constructor() {
    val count = staticCounter++
}


class NormalMagic @Inject constructor() {
    val count = staticCounter++
}
