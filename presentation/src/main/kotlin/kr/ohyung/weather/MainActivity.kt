package kr.ohyung.weather

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import kr.ohyung.weather.base.BaseActivity
import kr.ohyung.weather.databinding.ActivityMainBinding
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    companion object {

        fun start(context: Context) =
            context.startActivity(
                context.intentFor<MainActivity>()
                    .singleTop()
            )
    }

    override val resourceId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun setBindingVariable() {
        binding.viewModel = viewModel
    }

    override fun doOnStart() {
        /* explicitly empty */
    }

}
