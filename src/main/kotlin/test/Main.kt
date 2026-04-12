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
    println(WallService.posts.last().id)


    WallService.comment(WallService.posts.last().id, "Проверка комментария")

    println("-----------------------")

    println(Arrays.deepToString(WallService.comments))

    println("-----------------------")

    println(WallService.reportComments(WallService.posts.last().id, 2))

}