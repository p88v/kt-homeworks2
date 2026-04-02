package data

import data.Likes
import data.Comments


data class Post(
    var id: Int = 0,
    val ownerId: Int,
    val date: Int,
    val likes: Likes,
    val reposts: Int,
    val replyOwnerId: Int,
    val comments: Comments,
    val isFavorite: Boolean,
    val onlyForFriends: Boolean,
    val isPinned: Boolean,
    val commentsOwnerId: Int,
)