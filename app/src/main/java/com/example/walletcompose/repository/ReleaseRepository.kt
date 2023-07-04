package com.example.walletcompose.repository

import androidx.annotation.WorkerThread
import com.example.walletcompose.dao.ReleaseDAO
import com.example.walletcompose.model.Release
import kotlinx.coroutines.flow.Flow

/**
 * @Author:  Vitor Rey
 * @Date: 02,julho,2023
 * @Email: vitorrey.dev@gmail.com
 **/
class ReleaseRepository(private val releaseDAO: ReleaseDAO) {

    val allReleases: Flow<List<Release>> = releaseDAO.getReleases();

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(release: Release){
        releaseDAO.insert(release);
    }
}