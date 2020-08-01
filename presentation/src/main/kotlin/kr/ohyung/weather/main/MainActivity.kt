package kr.ohyung.weather.main

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.Observer
import kr.ohyung.weather.R
import kr.ohyung.weather.base.BaseActivity
import kr.ohyung.weather.databinding.ActivityMainBinding
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.toast
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLiveDataObserver()
    }

    private fun setLiveDataObserver() {
        viewModel.uiState.observe(this, Observer(::updateUi))
    }

    private fun updateUi(state: MainUiState) {
        when(state) {
            MainUiState.Loading -> { /* explicitly empty */ }
            is MainUiState.Content -> {
                binding.textView.text = state.toString()
            }
            is MainUiState.Error -> toast(state.errorMessage)
        }
    }
}
