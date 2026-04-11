package abstractclass

class UserGiftAttachment(
    val gift: UserGift
): Attachment() {
    override val type: String = "User gift"
}
data class UserGift(
    val id: Int,
    val fromId: Int,
    val message: String,
)