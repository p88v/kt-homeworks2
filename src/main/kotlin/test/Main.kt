package test

import data.Comments
import data.Likes
import data.Post
import service.WallService
import java.util.Arrays

fun main(){
val post = Post(
    0,
    1,
    12,
    Likes(1),
    123,
    12312,
    Comments(),
    true,
    false,
    true,
    12
)
    WallService.add(post)

    val post12 = Post(
        post.id,
        1,
        12,
        Likes(1),
        123123,
        12312,
        Comments(),
        true,
        false,
        true,
        12
    )

    println(Arrays.toString(WallService.posts))
    WallService.like(1)
    WallService.comment(1, "Проверка комментария")
    println(Arrays.toString(WallService.posts))
    println( WallService.update(post12))
    println(post)
}