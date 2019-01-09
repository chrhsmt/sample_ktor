package com.chrhsmt.example.ktor.data

data class PostSnippet(val snippet: PostSnippet.Text) {
    data class Text(val text: String)
}