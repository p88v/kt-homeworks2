package abstractclass

class FileAttachment(val file: File) : Attachment() {
    override val type: String = "File"
}

data class File(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
)