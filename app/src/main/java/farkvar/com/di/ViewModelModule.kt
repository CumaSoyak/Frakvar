package farkvar.com.di

import farkvar.com.ui.bus.bushome.BusViewModel
import farkvar.com.ui.bus.buslist.BusListViewModel
import farkvar.com.ui.bus.buslist.filtrele.InfoViewModel
import farkvar.com.ui.checkin.CheckInViewModel
import farkvar.com.ui.main.MainViewModel
import farkvar.com.ui.payment.paymentForm.PaymentFormViewModel
import farkvar.com.ui.payment.paymentInfo.PaymentInfoViewModel
import farkvar.com.ui.payment.paymentcash.PaymentCashViewModel
import farkvar.com.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { BusListViewModel(get()) }
    viewModel { PaymentInfoViewModel(get()) }
    viewModel { PaymentFormViewModel(get()) }
    viewModel { PaymentCashViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { CheckInViewModel(get()) }
    viewModel { BusViewModel(get()) }
    viewModel { InfoViewModel(get()) }

}