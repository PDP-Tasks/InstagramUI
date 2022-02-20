package dev.matyaqubov.instagramui.model

class Post(var profile: Int, var fullname: String, var photo: Int) {
    var photos = ArrayList<Int>()

    constructor(profile: Int, fullname: String, photos: ArrayList<Int>) : this(profile, fullname, photos[0]) {
        this.photos = photos
    }
}