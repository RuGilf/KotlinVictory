package `fun`.kotlinvictory.kotlinvictory

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform