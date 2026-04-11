package abstractclass

class PhotoAttachment(
    val photo: Photo
) : Attachment() {
    override val type: String = "Photo"
}

data class Photo(
    val id: Int,
    val album_id: Int,
    val userId: Int,
)