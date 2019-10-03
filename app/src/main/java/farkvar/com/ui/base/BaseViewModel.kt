package farkvar.com.ui.base

 import androidx.lifecycle.ViewModel
 import farkvar.com.data.repository.DataManager
import java.lang.ref.WeakReference


abstract class BaseViewModel<N>(val dataManager: DataManager) : ViewModel() {

    private var navigator: WeakReference<N>? = null

    fun getNavigator(): N? {
        return navigator?.get()
    }

    fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }

}
