package service

import data.Comments
import data.Likes
import data.Post

object WallService {

    var posts = emptyArray<Post>()
    private var id = 0

    fun clear(){
        posts = emptyArray()
        id = 0
    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++id, likes = post.likes.copy(), comments = post.comments.copy())
        postid(post)
        return posts.last()
    }

    fun postid(post: Post){
        post.id = id
    }

    fun update(postss: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == postss.id) {
                posts[index] = postss.copy(likes = postss.likes.copy(), comments = postss.comments.copy())
                return true
            }
        }
        return false
    }

    fun like(id: Int) {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(likes = Likes(post.id, 1))
            }
        }
    }

    fun comment(id: Int, text: String) {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(comments = Comments(text))
            }
        }
    }
}