package br.com.ericserafim.kjogovelha

import android.transition.Explode
import android.transition.Visibility.MODE_IN
import android.transition.Visibility.MODE_OUT

open class ExplodeTransition {

    companion object {

        fun builder(): Explode {
            return Explode()
        }

        fun builderModeIn(): Explode {
            val e = Explode()
            e.mode = MODE_IN
            return e
        }

        fun builderModeOut(): Explode {
            val e = Explode()
            e.mode = MODE_OUT
            return e
        }
    }

}
