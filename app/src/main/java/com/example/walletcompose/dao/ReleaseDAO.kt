package com.example.walletcompose.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.walletcompose.model.Release
import kotlinx.coroutines.flow.Flow

/**
 * @Author:  Vitor Rey
 * @Date: 02,julho,2023
 * @Email: vitorrey.dev@gmail.com
 **/

@Dao
interface ReleaseDAO {
    @Query("SELECT * FROM releases ORDER BY id ASC")
    fun getReleases(): Flow<List<Release>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(release: Release)

    @Query("DELETE from releases")
    suspend fun deleteAll()

}