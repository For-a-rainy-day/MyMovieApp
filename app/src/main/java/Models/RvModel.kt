package Models

import java.io.Serializable

class RvModel : Serializable{
    var title: String? = null
    var actor: String? = null
    var about: String? = null
    var date: String? = null

    constructor(title: String?, actor: String?, about: String?, date: String?) {
        this.title = title
        this.actor = actor
        this.about = about
        this.date = date
    }

    constructor()
}