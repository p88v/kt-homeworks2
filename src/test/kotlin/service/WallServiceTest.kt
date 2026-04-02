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
        WallService.add(post)
        val post2 = Post(
            post.id,
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
        val result = WallService.update(post2)
        assertEquals(true, result)
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
        val result = WallService.update(post2)
        assertEquals(true, result)
    }
}