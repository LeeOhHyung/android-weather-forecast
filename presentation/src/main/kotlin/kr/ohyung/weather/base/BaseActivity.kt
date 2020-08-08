package kr.ohyung.weather.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Lee Oh Hyoung on 2020/07/08.
 */
abstract class BaseActivity<T: ViewDataBinding, VM: BaseViewModel>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity(layoutId) {

    protected lateinit var binding: T

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return false
    }

    private fun setBinding() {
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
    }

    protected fun setToolbar(title: String) { /* explicitly empty */ }

}
