package farkvar.com.ui.bus.buslist

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import farkvar.com.CoreApp.Companion.context
import farkvar.com.data.remote.model.buslist.koltuksatilabilirlikonaylama.KoltukSatilabilirlikOnaylamaRequest
import farkvar.com.data.remote.model.buslist.seferlistesi.Table
import farkvar.com.data.remote.network.ResultWrapper
import farkvar.com.data.repository.DataManager
import farkvar.com.ui.base.BaseViewModel
import farkvar.com.ui.base.IBaseNavigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BusListViewModel(dataManager: DataManager) : BaseViewModel<IBusListNavigator>(dataManager) {

    val seferListesiData: MutableLiveData<ArrayList<Table>> = MutableLiveData()


    fun seferListesi(kalkisNokta: Int, varisNoktaID: Int, tarih: String, yolcuSayisi: Int) {
        getNavigator()?.showLoading()
        GlobalScope.launch(Dispatchers.Main) {

            when (val result = withContext(Dispatchers.IO)

            { dataManager.seferListesiAsync(kalkisNokta, varisNoktaID, tarih, yolcuSayisi) }) {

                is ResultWrapper.Success -> {
                    getNavigator()?.hideLoading()
                    seferListesiData.value=result.data.table
                }

                is ResultWrapper.Error -> {
                    Toast.makeText(context, "dwad", Toast.LENGTH_LONG).show()
                    getNavigator()?.hideLoading()
                    getNavigator()?.onError(result.exception.message, result.exception.code)
                }
            }
        }
    }

    fun seferDetayi(seferId:String) {
        getNavigator()?.showLoading()
        GlobalScope.launch(Dispatchers.Main) {

            when (val result = withContext(Dispatchers.IO)

            { dataManager.seferDetayiAsync(seferId) }) {

                is ResultWrapper.Success -> {
                    getNavigator()?.hideLoading()
                    val come=result.data
                    getNavigator()?.getSeferDetayiSucces(come.sefer,come.koltuk,come.seyahatTipleri,come.oTipOzellik,come.odemeKurallari)
                    Toast.makeText(context, "Oldu", Toast.LENGTH_LONG).show()

                }

                is ResultWrapper.Error -> {
                    Toast.makeText(context, "dwad", Toast.LENGTH_LONG).show()
                    getNavigator()?.hideLoading()
                    getNavigator()?.onError(result.exception.message, result.exception.code)
                }
            }
        }
    }
    fun otobusFirmaListesi() {
        getNavigator()?.showLoading()
        GlobalScope.launch(Dispatchers.Main) {

            when (val result = withContext(Dispatchers.IO)

            { dataManager.otobusFirmalariListesiAsync() }) {

                is ResultWrapper.Success -> {
                    getNavigator()?.hideLoading()
                    Toast.makeText(context, "Oldu", Toast.LENGTH_LONG).show()

                }

                is ResultWrapper.Error -> {
                    Toast.makeText(context, "dwad", Toast.LENGTH_LONG).show()
                    getNavigator()?.hideLoading()
                    getNavigator()?.onError(result.exception.message, result.exception.code)
                }
            }
        }
    }
    fun koltukSatılabilirlikOnay(seferId: Int,request: KoltukSatilabilirlikOnaylamaRequest) {
        getNavigator()?.showLoading()
        GlobalScope.launch(Dispatchers.Main) {

            when (val result = withContext(Dispatchers.IO)

            { dataManager.koltukSatilabilirlikOnaylamaAsync(seferId,request) }) {

                is ResultWrapper.Success -> {
                    getNavigator()?.hideLoading()
                    Toast.makeText(context, "Oldu", Toast.LENGTH_LONG).show()

                }

                is ResultWrapper.Error -> {
                    Toast.makeText(context, "dwad", Toast.LENGTH_LONG).show()
                    getNavigator()?.hideLoading()
                    getNavigator()?.onError(result.exception.message, result.exception.code)
                }
            }
        }
    }



}