package test

import abstractclass.Attachment
import abstractclass.File
import abstractclass.FileAttachment
import abstractclass.Link
import abstractclass.LinkAttachment
import data.Comments
import data.Likes
import data.Post
import service.WallService
import java.util.Arrays

fun main() {


    val file = File(1, 12, "Title", 12)
    val fileAttach = FileAttachment(file)

    val link = Link("url", "link","sd","about link")
    val linkAttach = LinkAttachment(link)
    var mutList = mutableListOf<Attachment>(fileAttach, linkAttach)


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
        commentsOwnerId = 12,
        attachment = mutList,
    )
    println(WallService.add(post))

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
        12,
        attachment = mutList,
    )

    println(Arrays.toString(WallService.posts))
    WallService.like(1)
    WallService.comment(1, "Проверка комментария")
    println(Arrays.toString(WallService.posts))
    println(WallService.update(post12))

}