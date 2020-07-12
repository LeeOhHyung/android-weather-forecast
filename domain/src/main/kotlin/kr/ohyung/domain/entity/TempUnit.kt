/*
 * Created by Lee Oh Hyoung on 2020/07/12 .. 
 */
package kr.ohyung.domain.entity

import kr.ohyung.domain.Entity

enum class TempUnit(val value: String) : Entity {
    IMPERIAL("imperial"),
    METRIC("metric"),
    KELVIN("kelvin")
}
