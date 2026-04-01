package service

import data.Comments
import data.Likes
import data.Post

object WallService {

    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun like(id: Int){
        for((index, post) in posts.withIndex()){
            if(post.id == id){
                posts[index] = post.copy(likes = Likes(post.id, 1))
            } else println("Такого поста нет")
        }
    }

    fun comment(id: Int, text: String){
        for((index, post) in posts.withIndex()){
            if(post.id == id){
                posts[index] = post.copy(comments = Comments(text))
            } else println("Такого поста нет")
        }
    }



}