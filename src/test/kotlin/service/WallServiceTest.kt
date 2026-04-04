package service

import data.Comments
import data.Likes
import data.Post
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
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
            0
        )
        WallService.add(post)
        assertTrue(post.id != 0)
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
            0
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
            0
        )
        WallService.update(post2)
        assertEquals(12, WallService.posts[0].reposts)
    }

    @Test
    fun updateFalse() {
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
            0
        )
        WallService.add(post)
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
            0
        )
        WallService.update(post2)
        assertEquals(1, post.ownerId)
    }
}