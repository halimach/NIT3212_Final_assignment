package com.vu.nit3212_final_assignment.data

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
//Data class representing an entity with detailed information.
// This class implements [Parcelable] to allow passing instances between Android components.
//sportName Name of the sport associated with the entity.
//  playerCount Number of players for the sport.
//  fieldType Type of field where the sport is played.
//  olympicSport Indicates if the sport is an Olympic sport.
//  description Description of the entity
data class Entity(
    @Json(name = "sportName") val sportName: String,
    @Json(name = "playerCount") val playerCount: String,
    @Json(name = "fieldType") val fieldType: String,
    @Json(name = "olympicSport") val olympicSport: String,
    @Json(name = "description") val description: String
) : Parcelable {
//Constructor to create an [Entity] from a [Parcel].

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )
//Writes the object's data to the provided [Parcel].
// parcel The parcel to write data to.
//flags Additional flags about how the object should be written.

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(sportName)
        parcel.writeString(playerCount)
        parcel.writeString(fieldType)
        parcel.writeString(olympicSport)
        parcel.writeString(description)
    }
//Describes the contents of the [Parcel].
    override fun describeContents(): Int {
        return 0
    }
//Companion object for creating [Entity] instances from a [Parcel].
    companion object CREATOR : Parcelable.Creator<Entity> {
//        Creates a new instance of [Entity] from a [Parcel].

        override fun createFromParcel(parcel: Parcel): Entity {
            return Entity(parcel)
        }
//Creates a new array of [Entity] objects.
        override fun newArray(size: Int): Array<Entity?> {
            return arrayOfNulls(size)
        }
    }
}
