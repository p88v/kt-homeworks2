package abstractclass

class LinkAttachment(
    val link: Link
) : Attachment() {
    override val type: String = "Link"
}

data class Link(
    val url: String,
    val title: String,
    val caption: String,
    val desription: String,
)