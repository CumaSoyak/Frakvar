package farkvar.com

class Definition {
    companion object {
        @JvmStatic lateinit var instance:Definition
        var selectedDay = 0
        var selectedMonth: String? = null
        var selectedNameOfDay: String? = null
        var returnAir:Boolean =false
    }
    init {
        instance=this
    }

}