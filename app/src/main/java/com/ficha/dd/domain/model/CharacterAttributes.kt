package com.ficha.dd.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class CharacterAttributes (
    var strength: Int,
    var dexterity: Int,
    var constitution: Int,
    var intelligence: Int,
    var wisdom: Int,
    var charism: Int,
) : Parcelable {
    fun setAttributeValue(attributeName: String, attributeValue: Int) {
        when (attributeName) {
            "strength" -> {
                this.strength = attributeValue
            }

            "dexterity" -> {
                this.dexterity = attributeValue
            }

            "constitution" -> {
                this.constitution = attributeValue
            }

            "intelligence" -> {
                this.intelligence = attributeValue
            }

            "wisdom" -> {
                this.wisdom = attributeValue
            }

            "charism" -> {
                this.charism = attributeValue
            }
        }
    }
}
