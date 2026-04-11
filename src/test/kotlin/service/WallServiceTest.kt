package service

import abstractclass.Attachment
import abstractclass.File
import abstractclass.FileAttachment
import data.Comments
import data.Likes
import data.Post
import org.junit.Before
import org.junit.Test
import java.nio.file.Files
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {

        val file = File(1, 12, "file", 123)
        val fileAttach = FileAttachment(file)
        val mutList = mutableListOf<Attachment>(fileAttach)

        val post = Post(
            0,
            1,
            1,
            Likes(),
            0,
            0,
            Comments(),
            false,
            false,
            false,
            0,
            attachment = mutList
        )
        val result = WallService.add(post)
        assertEquals(WallService.posts[0], result)
    }

    @Test
    fun updateTrue() {
        val post = Post(
            0,
            1,
            1,
            Likes(),
            0,
            0,
            Comments(),
            false,
            false,
            false,
            0,
            attachment = emptyList()
        )
        val addedPost = WallService.add(post)

        val post2 = Post(
            addedPost.id,
            1,
            1,
            Likes(),
            12,
            0,
            Comments(),
            false,
            false,
            false,
            0,
            attachment = emptyList()
        )
        val result = WallService.update(post2)
        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        val post = Post(
            0,
            1,
            0,
            Likes(),
            0,
            0,
            Comments(),
            false,
            false,
            false,
            0,
            attachment = emptyList()
        )

        val post2 = Post(
            post.id,
            13,
            1,
            Likes(),
            0,
            0,
            Comments(),
            false,
            false,
            false,
            0,
            attachment = emptyList()
        )
        val result = WallService.update(post2)
        assertFalse(result)
    }
}