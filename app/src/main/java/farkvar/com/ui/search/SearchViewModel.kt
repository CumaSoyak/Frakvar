package farkvar.com.ui.search

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import farkvar.com.CoreApp
import farkvar.com.data.remote.model.buslist.karanoktalari.KaraNoktalari
import farkvar.com.data.remote.network.ResultWrapper
import farkvar.com.data.repository.DataManager
import farkvar.com.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel(dataManager: DataManager) : BaseViewModel<ISearchNavigator>(dataManager) {

    val karaNoktaData: MutableLiveData<ArrayList<KaraNoktalari>> = MutableLiveData()

    fun karaNoktalari() {


        GlobalScope.launch(Dispatchers.Main) {

            when (val result = withContext(Dispatchers.IO)

            { dataManager.karanoktalariAsync() }) {

                is ResultWrapper.Success -> {
                    getNavigator()?.hideLoading()
                    karaNoktaData.value = result.data.karaNokta
                }

                is ResultWrapper.Error -> {
                    Toast.makeText(CoreApp.context, "dwad", Toast.LENGTH_LONG).show()
                    getNavigator()?.onError(result.exception.message, result.exception.code)
                }
            }
        }

    }

}
