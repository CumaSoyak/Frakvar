package farkvar.com.ui.base

interface IBaseNavigator {
    fun showLoading()

    fun hideLoading()

    fun onError(message: String, code: Int)

    fun onSucces(message: String)

 }