package com.vu.nit3212_final_assignment.data

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

data class Entity(
    @Json(name = "sportName") val sportName: String,
    @Json(name = "playerCount") val playerCount: String,
    @Json(name = "fieldType") val fieldType: String,
    @Json(name = "olympicSport") val olympicSport: String,
    @Json(name = "description") val description: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(sportName)
        parcel.writeString(playerCount)
        parcel.writeString(fieldType)
        parcel.writeString(olympicSport)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Entity> {
        override fun createFromParcel(parcel: Parcel): Entity {
            return Entity(parcel)
        }

        override fun newArray(size: Int): Array<Entity?> {
            return arrayOfNulls(size)
        }
    }
}
