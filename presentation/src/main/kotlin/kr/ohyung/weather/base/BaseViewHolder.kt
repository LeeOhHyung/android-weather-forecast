package kr.ohyung.weather.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import kr.ohyung.domain.Entity

/**
 * Created by Lee Oh Hyoung on 2020/07/09.
 */
abstract class BaseViewHolder<M: Entity>(
    private val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun onBind(item: M)

}
