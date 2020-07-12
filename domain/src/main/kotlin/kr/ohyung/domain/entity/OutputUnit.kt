/*
 * Created by Lee Oh Hyoung on 2020/07/12 .. 
 */
package kr.ohyung.domain.entity

import kr.ohyung.domain.Entity

enum class OutputUnit(val value: String) : Entity {
    XML("xml"),
    JSON("json")
}
