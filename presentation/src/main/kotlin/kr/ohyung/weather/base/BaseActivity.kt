package kr.ohyung.weather.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Lee Oh Hyoung on 2020/07/08.
 */
abstract class BaseActivity<T: ViewDataBinding, VM: BaseViewModel> : AppCompatActivity() {

    abstract val resourceId: Int

    protected lateinit var binding: T

    abstract val viewModel: VM

    abstract fun setBindingVariable()

    abstract fun doOnStart()

    open fun setRecyclerView() { /* explicitly empty */ }

    open fun observeLiveData() { /* explicitly empty */ }

    open fun setListener() { /* explicitly empty */ }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setBindingVariable()
        observeLiveData()
        setRecyclerView()
        setListener()
        doOnStart()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return false
    }

    private fun setBinding() {
        binding = DataBindingUtil.setContentView(this, resourceId)
        binding.lifecycleOwner = this
    }

    protected fun setToolbar(title: String) { /* explicitly empty */ }

}
