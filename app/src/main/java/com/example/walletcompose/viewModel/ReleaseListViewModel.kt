package com.example.walletcompose.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.walletcompose.model.Release
import com.example.walletcompose.repository.ReleaseRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

/**
 * @Author:  Vitor Rey
 * @Date: 02,julho,2023
 * @Email: vitorrey.dev@gmail.com
 **/
class ReleaseListViewModel(private val repository: ReleaseRepository) : ViewModel() {

    val allReleases: LiveData<List<Release>> = repository.allReleases.asLiveData();

    fun insert(release: Release) = viewModelScope.launch {
        repository.insert(release);
    }
}

class ReleaseListViewModelFactory(private val repository: ReleaseRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReleaseListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ReleaseListViewModel(repository) as T;
        }
        throw IllegalArgumentException("Unknown ViewModel class");
    }
}