package com.germandebustamante.inadraft.local

import android.content.Context
import androidx.room.Room
import com.germandebustamante.inadraft.local.room.database.InaDraftDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

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
}