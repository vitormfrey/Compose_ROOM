package com.example.walletcompose.db

import android.content.Context
import androidx.room.CoroutinesRoom
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.walletcompose.dao.ReleaseDAO
import com.example.walletcompose.model.Release
import com.example.walletcompose.model.enums.ReleaseType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.math.BigDecimal

/**
 * @Author:  Vitor Rey
 * @Date: 02,julho,2023
 * @Email: vitorrey.dev@gmail.com
 **/
@Database(entities = arrayOf(Release::class), version = 1, exportSchema = false)
public abstract class WalletDB : RoomDatabase() {

    abstract fun releaseDao(): ReleaseDAO

    private class WalletDBCallback(private val scope: CoroutineScope) : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {database ->
                scope.launch {
                    var releaseDAO = database.releaseDao()

                    releaseDAO.deleteAll()

                    var release = Release(0, "Vivo", ReleaseType.EXPENSE, false)
                    releaseDAO.insert(release);
                    release = Release(0, "Viv", ReleaseType.EXPENSE, false)
                    releaseDAO.insert(release);
                    release = Release(0, "Vo", ReleaseType.EXPENSE, false)
                    releaseDAO.insert(release);
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: WalletDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): WalletDB {
            return INSTANCE ?: synchronized(this) {
                val instantce = Room.databaseBuilder(
                    context.applicationContext,
                    WalletDB::class.java,
                    "walletDB"
                )
                    .addCallback(WalletDBCallback(scope))
                    .build()
                INSTANCE = instantce

                instantce
            }
        }
    }
}