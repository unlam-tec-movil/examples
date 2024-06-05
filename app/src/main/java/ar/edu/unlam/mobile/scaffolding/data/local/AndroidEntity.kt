package ar.edu.unlam.mobile.scaffolding.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid

@Entity(tableName = "androids")
data class AndroidEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val picture: String = "",
)

fun AndroidEntity.asModel() =
    RealAndroid(
        name = name,
        id = id.toUInt(),
        description = description,
        picture = picture,
    )

fun RealAndroid.asEntity() =
    AndroidEntity(
        name = name,
        description = description,
        picture = picture,
    )
