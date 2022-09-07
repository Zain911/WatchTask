package com.example.e_commercewatches.data.entity.watche

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.e_commercewatches.R
import java.io.Serializable

@Entity(primaryKeys = ["id", "selectedSize"])
data class Watches(

    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String?,

    @ColumnInfo(name = "image")
    var image: Int = 0,

    @ColumnInfo(name = "priceAfterSale")
    var priceAfterSale: String?,

    @ColumnInfo(name = "priceBeforeSale")
    var priceBeforeSale: String?,

    @ColumnInfo(name = "description")
    var Description: String?,

    @ColumnInfo(name = "percentageSale")
    var percentSale: String?,

    @ColumnInfo(name = "rating")
    var rating: Float = 0.0f,

    @ColumnInfo(name = "selectedSize")
    var selectedSize: String = "",

    @ColumnInfo(name = "quantity")
    var quantity: Int = 1,

    ) : Serializable

fun getWatches() = listOf(
    Watches(name = "Apple Watch- M2",
        image = R.drawable.watch1,
        priceAfterSale = "140",
        priceBeforeSale = "200",
        percentSale = "30% OFF",
        id = 1,
        Description = description,
        rating = 5f),

    Watches(name = "Apple Watch- M1",
        image = R.drawable.watch2,
        priceAfterSale = "100",
        priceBeforeSale = "130",
        percentSale = "30% OFF",
        id = 2,
        Description = description,
        rating = 4f),
    Watches(name = "Apple Watch- GS",
        image = R.drawable.watch3,
        priceAfterSale = "70",
        priceBeforeSale = "100",
        percentSale = "30% OFF",
        id = 3,
        Description = description,
        rating = 3f),
    Watches(name = "Apple Watch- S6",
        image = R.drawable.watch4,
        priceAfterSale = "180",
        priceBeforeSale = "200",
        percentSale = "10% OFF",
        id = 4,
        Description = description,
        rating = 2f),
    Watches(name = "Apple Watch- S2",
        image = R.drawable.watch5,
        priceAfterSale = "160",
        priceBeforeSale = "200",
        percentSale = "20% OFF",
        id = 5,
        Description = description,
        rating = 5f),
    Watches(name = "Samsung Watch- S1",
        image = R.drawable.watch6,
        priceAfterSale = "140",
        priceBeforeSale = "200",
        id = 6,
        percentSale = "30% OFF",
        Description = description,
        rating = 5f),
    Watches(name = "Huawei Watch - 9C",
        image = R.drawable.watch7,
        priceAfterSale = "1760",
        priceBeforeSale = "220",

        id = 7,
        percentSale = "20% OFF",
        Description = description,
        rating = 3f),
    Watches(name = "Apple Watch- M5",
        image = R.drawable.watch8,
        priceAfterSale = "300",
        priceBeforeSale = "330",
        percentSale = "10% OFF",
        id = 8,
        Description = description,
        rating = 3f),
    Watches(name = "Apple Watch- M2",
        image = R.drawable.watch1,
        priceAfterSale = "140",
        priceBeforeSale = "200",
        percentSale = "30% OFF",
        id = 9,
        Description = description,
        rating = 5f),
    Watches(name = "Apple Watch- M1",
        image = R.drawable.watch2,
        priceAfterSale = "100",
        priceBeforeSale = "130",
        percentSale = "30% OFF",
        id = 10,
        Description = description,
        rating = 2f),
    Watches(name = "Apple Watch- GS",
        image = R.drawable.watch3,
        priceAfterSale = "70",
        priceBeforeSale = "100",
        percentSale = "30% OFF",
        id = 11,
        Description = description,
        rating = 3f),
    Watches(name = "Apple Watch- S6",
        image = R.drawable.watch4,
        priceAfterSale = "180",
        priceBeforeSale = "200",
        percentSale = "10% OFF",
        id = 11,
        Description = description,
        rating = 5f),
    Watches(name = "Apple Watch- S2",
        image = R.drawable.watch5,
        priceAfterSale = "160",
        priceBeforeSale = "200",
        percentSale = "20% OFF",
        id = 12,
        Description = description,
        rating = 4.5f),
    Watches(name = "Samsung Watch- S1",
        image = R.drawable.watch6,
        priceAfterSale = "140",
        priceBeforeSale = "200",
        percentSale = "30% OFF",
        id = 13,
        Description = description,
        rating = 3.5f),
    Watches(name = "Huawei Watch - 9C",
        image = R.drawable.watch7,
        priceAfterSale = "1760",
        priceBeforeSale = "220",
        percentSale = "20% OFF",
        id = 14,
        Description = description,
        rating = 2.5f),
    Watches(name = "Apple Watch- M5",
        image = R.drawable.watch8,
        priceAfterSale = "300",
        priceBeforeSale = "330",
        id = 15,
        percentSale = "10% OFF",
        Description = description,
        rating = 5f)


)

const val description =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris in libero mollis, rutrum lectus eu, varius justo. Quisque pellentesque eget ,Mauris in libero mollis, varius justo."

val size = arrayListOf("S", "M", "L")

val sizeNumber = arrayListOf("25", "28", "30", "32", "34", "35", "39", "38", "40")
