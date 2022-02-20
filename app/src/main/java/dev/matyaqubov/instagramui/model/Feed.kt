package dev.matyaqubov.instagramui.model

class Feed {
    var post: Post? = null
    var isads=false
    var stories = ArrayList<Story>()

    constructor(post: Post,isads:Boolean=false) {
        this.post = post
        this.isads=isads
    }

    constructor(stories: ArrayList<Story>) {
        this.stories = stories
    }
}