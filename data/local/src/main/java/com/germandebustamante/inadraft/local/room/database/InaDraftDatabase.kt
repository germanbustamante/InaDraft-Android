package com.germandebustamante.inadraft.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.germandebustamante.inadraft.local.room.dao.FormationDao
import com.germandebustamante.inadraft.local.room.dao.GameDao
import com.germandebustamante.inadraft.local.room.dao.PlayerDao
import com.germandebustamante.inadraft.local.room.dao.PositionDao
import com.germandebustamante.inadraft.local.room.dao.TeamDao
import com.germandebustamante.inadraft.local.room.dbo.entity.FormationDBO
import com.germandebustamante.inadraft.local.room.dbo.entity.GameDBO
import com.germandebustamante.inadraft.local.room.dbo.entity.PlayerDBO
import com.germandebustamante.inadraft.local.room.dbo.entity.PositionDBO
import com.germandebustamante.inadraft.local.room.dbo.entity.TeamDBO

@Database(
    entities = [PlayerDBO::class, TeamDBO::class, PositionDBO::class, FormationDBO::class, GameDBO::class],
    version = 1
)
@TypeConverters(DateLocalConverter::class)
abstract class InaDraftDatabase : RoomDatabase() {

    abstract fun getPlayerDao(): PlayerDao

    abstract fun getTeamDao(): TeamDao

    abstract fun getPositionDao(): PositionDao

    abstract fun getFormationDao(): FormationDao

    abstract fun getGameDao(): GameDao

}