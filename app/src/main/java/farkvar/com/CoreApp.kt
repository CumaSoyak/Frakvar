package farkvar.com

import android.app.Application
import android.content.Context
//import com.crashlytics.android.Crashlytics
//import com.google.android.gms.maps.model.LatLng

import farkvar.com.di.appModule
import farkvar.com.utils.AppConstants
import farkvar.com.utils.PrefUtils
//import io.fabric.sdk.android.Fabric
import org.koin.android.ext.android.startKoin

class CoreApp : Application() {
    companion object {
        lateinit var context: Context
        var appType = AppConstants.retail
        var basketPrice = 0.0
        var sellerId: Int = 0
     }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        configureDi()
     //   configureFabric()
    }

    private fun configureDi() = startKoin(this, appModule)

//    private fun configureFabric() {
//        Fabric.with(context, Crashlytics())
//        if (PrefUtils.isLoggedUser()) {
//            PrefUtils.createFabricUser(
//                PrefUtils.getUser().user.id.toString(),
//                PrefUtils.getUser().user.email,
//                PrefUtils.getUser().user.full_name
//            )
//        } else {
//            PrefUtils.createFabricUser("2013", "mobilliumuser@mobillium.com", "Mobillium User")
//        }
//    }

}