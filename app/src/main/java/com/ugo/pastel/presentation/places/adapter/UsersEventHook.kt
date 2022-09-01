package com.ugo.pastel.presentation.places.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.listeners.ClickEventHook
import com.ugo.pastel.databinding.ItemNewsArticleBinding
import com.ugo.pastel.domain.model.user.News
import com.ugo.pastel.utility.context.asBinding

class UsersEventHook(
    private val listener: (News) -> Unit
) : ClickEventHook<NewsItem>() {

    //region Bind

    override fun onBind(viewHolder: RecyclerView.ViewHolder): View? =
        viewHolder
            .asBinding<ItemNewsArticleBinding>()
            ?.root

    //endregion

    //region Click

    override fun onClick(
        v: View,
        position: Int,
        fastAdapter: FastAdapter<NewsItem>,
        item: NewsItem
    ) {
        // Invoke listener.
        listener.invoke(item.model)
    }

    //endregion
}