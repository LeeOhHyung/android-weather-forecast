/*
 * Created by Lee Oh Hyoung on 2020/07/12 .. 
 */
package kr.ohyung.domain.entity

enum class AddressType(val value: String, val description : String) {
    LEGAL("legalcode", "법정동"),
    ADM("admcode", "행정동"),
    ADDR("addr", "지번주소"),
    ROAD("roadaddr", "도로명주소")
}
