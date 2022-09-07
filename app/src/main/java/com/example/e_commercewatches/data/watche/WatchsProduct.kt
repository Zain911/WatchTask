package com.example.e_commercewatches.data.watche

import android.os.Parcel
import android.os.Parcelable
import com.example.e_commercewatches.R

data class Watches(
    var name: String?,
    var image: Int,
    var priceAfterSale: String?,
    var priceBeforeSale: String?,
    var Description: String?,
    var percentSale: String?,
    var rating: Float,
    var size: ArrayList<String>? = arrayListOf()

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.createStringArrayList()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(image)
        parcel.writeString(priceAfterSale)
        parcel.writeString(priceBeforeSale)
        parcel.writeString(Description)
        parcel.writeString(percentSale)
        parcel.writeFloat(rating)
        parcel.writeStringList(size)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Watches> {
        override fun createFromParcel(parcel: Parcel): Watches {
            return Watches(parcel)
        }

        override fun newArray(size: Int): Array<Watches?> {
            return arrayOfNulls(size)
        }
    }
}

fun getWatches() = listOf(
    Watches(name = "Apple Watch- M2",
        image = R.drawable.watch1,
        priceAfterSale = "$140",
        priceBeforeSale = "$200",
        percentSale = "30% OFF",
        Description = description,
        rating = 5f, size = sizeNumber),
    Watches(name = "Apple Watch- M1",
        image = R.drawable.watch2,
        priceAfterSale = "$100",
        priceBeforeSale = "$130",
        percentSale = "30% OFF",
        Description = description,
        rating = 4f, size = sizeNumber),
    Watches(name = "Apple Watch- GS",
        image = R.drawable.watch3,
        priceAfterSale = "$70",
        priceBeforeSale = "$100",
        percentSale = "30% OFF",
        Description = description,
        rating = 3f, size = sizeNumber),
    Watches(name = "Apple Watch- S6",
        image = R.drawable.watch4,
        priceAfterSale = "$180",
        priceBeforeSale = "$200",
        percentSale = "10% OFF",
        Description = description,
        rating = 2f, size = size),
    Watches(name = "Apple Watch- S2",
        image = R.drawable.watch5,
        priceAfterSale = "$160",
        priceBeforeSale = "$200",
        percentSale = "20% OFF",
        Description = description,
        rating = 5f, size = sizeNumber),
    Watches(name = "Samsung Watch- S1",
        image = R.drawable.watch6,
        priceAfterSale = "$140",
        priceBeforeSale = "$200",
        percentSale = "30% OFF",
        Description = description,
        rating = 5f, size = size),
    Watches(name = "Huawei Watch - 9C",
        image = R.drawable.watch7,
        priceAfterSale = "$1760",
        priceBeforeSale = "$220",
        percentSale = "20% OFF",
        Description = description,
        rating = 3f, size = sizeNumber),
    Watches(name = "Apple Watch- M5",
        image = R.drawable.watch8,
        priceAfterSale = "$300",
        priceBeforeSale = "$330",
        percentSale = "10% OFF",
        Description = description,
        rating = 3f, size = size),
    Watches(name = "Apple Watch- M2",
        image = R.drawable.watch1,
        priceAfterSale = "$140",
        priceBeforeSale = "$200",
        percentSale = "30% OFF",
        Description = description,
        rating = 5f, size = sizeNumber),
    Watches(name = "Apple Watch- M1",
        image = R.drawable.watch2,
        priceAfterSale = "$100",
        priceBeforeSale = "$130",
        percentSale = "30% OFF",
        Description = description,
        rating = 2f, size = sizeNumber),
    Watches(name = "Apple Watch- GS",
        image = R.drawable.watch3,
        priceAfterSale = "$70",
        priceBeforeSale = "$100",
        percentSale = "30% OFF",
        Description = description,
        rating = 3f, size = size),
    Watches(name = "Apple Watch- S6",
        image = R.drawable.watch4,
        priceAfterSale = "$180",
        priceBeforeSale = "$200",
        percentSale = "10% OFF",
        Description = description,
        rating = 5f, size = size),
    Watches(name = "Apple Watch- S2",
        image = R.drawable.watch5,
        priceAfterSale = "$160",
        priceBeforeSale = "$200",
        percentSale = "20% OFF",
        Description = description,
        rating = 4.5f, size = sizeNumber),
    Watches(name = "Samsung Watch- S1",
        image = R.drawable.watch6,
        priceAfterSale = "$140",
        priceBeforeSale = "$200",
        percentSale = "30% OFF",
        Description = description,
        rating = 3.5f, size = sizeNumber),
    Watches(name = "Huawei Watch - 9C",
        image = R.drawable.watch7,
        priceAfterSale = "$1760",
        priceBeforeSale = "$220",
        percentSale = "20% OFF",
        Description = description,
        rating = 2.5f, size = sizeNumber),
    Watches(name = "Apple Watch- M5",
        image = R.drawable.watch8,
        priceAfterSale = "$300",
        priceBeforeSale = "$330",
        percentSale = "10% OFF",
        Description = description,
        rating = 5f, size = size)


)

const val description =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris in libero mollis, rutrum lectus eu, varius justo. Quisque pellentesque eget ,Mauris in libero mollis, varius justo."
val size = arrayListOf("S", "M", "L")
val sizeNumber = arrayListOf("25", "28", "30", "32", "34", "35", "39", "38", "40")
