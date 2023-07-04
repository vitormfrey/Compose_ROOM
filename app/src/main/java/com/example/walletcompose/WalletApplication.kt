package com.example.walletcompose

import android.app.Application
import com.example.walletcompose.db.WalletDB
import com.example.walletcompose.repository.ReleaseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * @Author:  Vitor Rey
 * @Date: 02,julho,2023
 * @Email: vitorrey.dev@gmail.com
 **/
class WalletApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob());

    val database by lazy { WalletDB.getDatabase(this, applicationScope) }
    val repository by lazy { ReleaseRepository(database.releaseDao())}
}