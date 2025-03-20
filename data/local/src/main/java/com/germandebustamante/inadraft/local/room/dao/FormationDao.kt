package com.germandebustamante.inadraft.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.germandebustamante.inadraft.local.room.dbo.entity.FormationDBO

@Dao
interface FormationDao {

    //region queries

    @Query("SELECT * FROM formations")
    suspend fun getFormations(): List<FormationDBO>
    //endregion

    //region insert

    @Insert
    suspend fun insertFormations(formations : List<FormationDBO>)

    //endregion

}