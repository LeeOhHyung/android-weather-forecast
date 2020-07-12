package kr.ohyung.weather

import android.content.Context
import kr.ohyung.weather.base.BaseActivity
import kr.ohyung.weather.databinding.ActivityMainBinding
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.koin.android.viewmodel.ext.android.viewModel

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

    override val viewModel: MainViewModel by viewModel()

    override fun setBindingVariable() {
        binding.viewModel = viewModel
    }

    override fun doOnStart() {
        viewModel.getForecast()
    }

}
