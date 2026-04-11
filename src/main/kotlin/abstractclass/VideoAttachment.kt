package abstractclass

class VideoAttachment : Attachment() {
    override val type: String = "Video"
}
data class video(
    val id: Int,
    val ownerId: Int,
    val title: String,
)