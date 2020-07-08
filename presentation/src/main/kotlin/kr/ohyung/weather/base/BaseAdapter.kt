package kr.ohyung.weather.base

import androidx.recyclerview.widget.RecyclerView
import kr.ohyung.domain.Entity

/**
 * Created by Lee Oh Hyoung on 2020/07/09.
 */
abstract class BaseAdapter<M: Entity> : RecyclerView.Adapter<BaseViewHolder<M>>() {

    open fun init() { /* explicitly empty */ }

    open fun update() { /* explicitly empty */ }

}
