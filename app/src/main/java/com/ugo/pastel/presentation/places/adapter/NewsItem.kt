package com.ugo.pastel.presentation.places.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.mikepenz.fastadapter.binding.ModelAbstractBindingItem
import com.ugo.pastel.R
import com.ugo.pastel.databinding.ItemNewsArticleBinding
import com.ugo.pastel.domain.model.user.News

class NewsItem(
    news: News,
) : ModelAbstractBindingItem<News, ItemNewsArticleBinding>(news) {

    //region Initialization

    init {
//        // Set identifier
//        identifier = model.id
    }

    //endregion

    //region Type

    override val type: Int
        get() = R.id.itemUser

    //endregion

    //region Binding

    override fun bindView(binding: ItemNewsArticleBinding, payloads: List<Any>) {
        binding.descriptionText.text = this.model.description
        binding.authorText.text = this.model.author
        if (this.model.urlToImage.isNotEmpty()) {
            Glide.with(binding.newsImage)
                .load(this.model.urlToImage)
                .into(binding.newsImage)
        } else {
            binding.newsImage.setImageResource(R.drawable.ic_holder_img)
        }

    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ItemNewsArticleBinding {
        return ItemNewsArticleBinding.inflate(inflater, parent, false)
    }

    //endregion

}
