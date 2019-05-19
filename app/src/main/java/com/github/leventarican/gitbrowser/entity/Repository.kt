package com.github.leventarican.gitbrowser.entity

/**
 * not that type of repository you think (architecture)
 * just the git repository.
 *
 * sample data:
 *  "updated_at": "2019-03-10T20:13:29Z",
 *  "clone_url": "https://github.com/leventarican/GitBrowser.git",
 *  "language": "Kotlin",
 */
data class Repository(val name: String, val description: String?, val updatedAt: String, val language: String?)