package ar.edu.unlam.mobile.scaffolding.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AndroidDao {
    @Query("SELECT * FROM androids")
    fun listAndroids(): Flow<List<AndroidEntity>>

    @Insert
    suspend fun createAndroid(android: AndroidEntity)

    @Query("SELECT * FROM androids WHERE id = :id")
    fun getById(id: Int): Flow<AndroidEntity>
}
