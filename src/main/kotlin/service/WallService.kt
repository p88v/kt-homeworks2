package service

import data.Comments
import data.Likes
import data.Post
import exepthion.PostNotFoundException
import service.WallService.comments
import service.WallService.posts

object WallService {

   var posts = emptyArray<Post>()
    var comments = emptyArray<Comments>()

    private var id = 0
    private var flag = false


    fun clear() {
        posts = emptyArray()
        id = 0
    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++id, likes = post.likes.copy(), comments = post.comments.copy())
        return posts.last()
        flag = true
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

    fun createComment(postId: Int, comment: Comments): Comments {

        for ((index, post) in posts.withIndex()) {
            if (postId == post.id) {
                comments += comment.copy()
                return comments.last()
            } else{
                throw PostNotFoundException("Пост с таким (id: $postId) отсутствует.")
            }
        }
        return throw PostNotFoundException(":(")
    }

}