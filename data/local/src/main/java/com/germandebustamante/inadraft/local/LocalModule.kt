package com.germandebustamante.inadraft.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.germandebustamante.inadraft.datasource.FormationLocalDataSource
import com.germandebustamante.inadraft.datasource.game.GameLocalDataSource
import com.germandebustamante.inadraft.datasource.player.PlayerLocalDataSource
import com.germandebustamante.inadraft.datasource.position.PositionLocalDataSource
import com.germandebustamante.inadraft.datasource.team.TeamLocalDataSource
import com.germandebustamante.inadraft.local.datasource.FormationLocalDataSourceImpl
import com.germandebustamante.inadraft.local.datasource.GameLocalDataSourceImpl
import com.germandebustamante.inadraft.local.datasource.PlayerLocalDataSourceImpl
import com.germandebustamante.inadraft.local.datasource.PositionLocalDataSourceImpl
import com.germandebustamante.inadraft.local.datasource.TeamLocalDataSourceImpl
import com.germandebustamante.inadraft.local.room.dao.FormationDao
import com.germandebustamante.inadraft.local.room.dao.GameDao
import com.germandebustamante.inadraft.local.room.dao.PlayerDao
import com.germandebustamante.inadraft.local.room.dao.PositionDao
import com.germandebustamante.inadraft.local.room.dao.TeamDao
import com.germandebustamante.inadraft.local.room.database.InaDraftDatabase
import javax.inject.Singleton

/**
 * Modulo de inyección de dependencias sobre el módulo data:local
 */
@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    private const val INADRAFT_DATABASE_NAME = "inadraft_database"

    //region room

    @Singleton
    @Provides
    fun roomDatabaseProvider(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, InaDraftDatabase::class.java, INADRAFT_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()


    @Singleton
    @Provides
    fun playerDaoProvider(database: InaDraftDatabase) = database.getPlayerDao()
    @Singleton
    @Provides
    fun teamDaoProvider(database: InaDraftDatabase) = database.getTeamDao()

    @Singleton
    @Provides
    fun positionDaoProvider(database: InaDraftDatabase) = database.getPositionDao()

    @Singleton
    @Provides
    fun formationDaoProvider(database: InaDraftDatabase) = database.getFormationDao()

    @Singleton
    @Provides
    fun gameDaoProvider(database: InaDraftDatabase) = database.getGameDao()

    //endregion

    //region datasources

    @Provides
    fun teamLocalDataSourceProvider(teamDao: TeamDao): TeamLocalDataSource = TeamLocalDataSourceImpl(teamDao)

    @Provides
    fun playerLocalDataSourceProvider(playerDao: PlayerDao): PlayerLocalDataSource = PlayerLocalDataSourceImpl(playerDao)

    @Provides
    fun positionLocalDataSourceProvider(positionDao: PositionDao): PositionLocalDataSource = PositionLocalDataSourceImpl(positionDao)

    @Provides
    fun formationLocalDataSourceProvider(formationDao: FormationDao): FormationLocalDataSource = FormationLocalDataSourceImpl(formationDao)

    @Provides
    fun gameLocalDataSourceProvider(gameDao: GameDao): GameLocalDataSource = GameLocalDataSourceImpl(gameDao)

    //endregion
}