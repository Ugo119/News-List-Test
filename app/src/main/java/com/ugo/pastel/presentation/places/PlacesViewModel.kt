package com.ugo.pastel.presentation.places

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.windly.limbo.mvvm.lifecycle.SingleLiveEvent
import co.windly.limbo.mvvm.viewmodel.LimboViewModel
import com.ugo.pastel.domain.manager.NewsDomainManager
import com.ugo.pastel.domain.model.base.Meta
import com.ugo.pastel.domain.model.user.News
import com.ugo.pastel.presentation.places.adapter.NewsItem
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class PlacesViewModel @Inject constructor(
    private val newsDomainManager: NewsDomainManager
) : LimboViewModel() {

    //region Paging

    private var meta: Meta = Meta()

    var currentPage = 1L

    fun loadNextPage() {

//        currentPage += 1
//
//        val isNextAvailable: Boolean =
//        meta.articles.size <= meta.total_count
//
//        // Do nothing if all data downloaded.
//        if (!isNextAvailable) {
//            return
//        }
//
//        // Calculate next page.
//        val next: Long = currentPage
//
//        Log.e("TAG_Profiles", "Next = $next")

        // Download next page of data.
        fetchNewsArticles()
    }

    //endregion

    // region DownloadUsers Meta

    fun fetchNewsArticles() {
        newsDomainManager
            .downloadNewsArticles(LOCATION, API_KEY)
            .doOnSubscribe { updateProgress(true) }
            .doFinally { updateProgress(false) }
            .subscribe(
                this::handleDownloadUsersSuccess,
                this::handleDownloadUsersError
            ).addTo(disposables)
    }

    private fun handleDownloadUsersSuccess(meta: Meta) {
        observeUsers()
        // Save meta for later use.
        this.meta = meta
    }

    private fun handleDownloadUsersError(throwable: Throwable) {

        // Show error message
        Log.e("TAG_Download_Meta", "$throwable")

    }

    // endregion

    //region Observe Users

    private val _users: MutableLiveData<List<NewsItem>> = MutableLiveData(emptyList())

    val users: LiveData<List<NewsItem>> = _users

    fun observeUsers() {
        newsDomainManager
            .observeNews()
            .subscribe(
                this::handleObserveUsersSuccess,
                this::handleObserveUsersError
            ).addTo(disposables)
    }

    private fun handleObserveUsersSuccess(list: List<News>) {
        Log.e("TAG_Download_Meta", "UPDATED: $list")
        _users.postValue(list.map { NewsItem(it) })
    }

    private fun handleObserveUsersError(throwable: Throwable) {
        // Show error message
        Log.e("TAG_Download_Meta", "$throwable")
        Log.e("TAG_Download_Meta","An error occurred while fetching users from db.")
    }

    //endregion

    // region News Item Clicked

    private val _newsClickAction: SingleLiveEvent<News> = SingleLiveEvent()
    internal val newsClickAction: LiveData<News> = _newsClickAction

    fun onUserItemClicked(news: News) {
        _newsClickAction.postValue(news)
    }

    // endregion

    // region Delete All Users

    fun deleteAllUsers() {
        newsDomainManager
            .deleteAllUsers()
            .subscribe(
                ::onDeleteAllUsersSuccess,
                ::onDeleteAllUsersError
            ).addTo(disposables)
    }

    fun onDeleteAllUsersSuccess() {
        Log.e("TAG_Users", "All users deleted successfully!")
    }

    fun onDeleteAllUsersError(throwable: Throwable) {
        Log.e("TAG_Users","An error occurred while deleting users from db!!")
    }

    // endregion

    companion object {
        const val FIRST_PAGE = 1L
        const val LOCATION = "us"
        const val API_KEY = "2d021085c2e64c23927ff485d9f4299b"
    }

    //region Loading

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    private fun updateProgress(inProgress: Boolean) {
        _loading.postValue(inProgress)
    }

    //endregion


}