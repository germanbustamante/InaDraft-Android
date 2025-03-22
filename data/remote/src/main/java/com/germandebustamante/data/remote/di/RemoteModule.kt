package com.germandebustamante.data.remote.di

import com.germandebustamante.data.remote.formation.datasource.FormationRemoteDataSource
import com.germandebustamante.data.remote.formation.datasource.FormationRemoteDataSourceImpl
import com.germandebustamante.data.remote.game.datasource.GameRemoteDataSource
import com.germandebustamante.data.remote.game.datasource.GameRemoteDataSourceImpl
import com.germandebustamante.data.remote.player.datasource.PlayerRemoteDataSource
import com.germandebustamante.data.remote.player.datasource.PlayerRemoteDataSourceImpl
import com.germandebustamante.data.remote.position.datasource.PositionRemoteDataSource
import com.germandebustamante.data.remote.position.datasource.PositionRemoteDataSourceImpl
import com.germandebustamante.data.remote.team.datasource.TeamRemoteDataSource
import com.germandebustamante.data.remote.team.datasource.TeamRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    //region Data Sources
    @Binds
    abstract fun bindTeamRemoteDataSource(
        teamRemoteDataSourceImpl: TeamRemoteDataSourceImpl,
    ): TeamRemoteDataSource

    @Binds
    abstract fun bindPlayerRemoteDataSource(
        playerRemoteDataSourceImpl: PlayerRemoteDataSourceImpl,
    ): PlayerRemoteDataSource

    @Binds
    abstract fun bindPositionRemoteDataSource(
        positionRemoteDataSourceImpl: PositionRemoteDataSourceImpl,
    ): PositionRemoteDataSource

    @Binds
    abstract fun bindFormationRemoteDataSource(
        formationRemoteDataSourceImpl: FormationRemoteDataSourceImpl,
    ): FormationRemoteDataSource

    @Binds
    abstract fun bindGameRemoteDataSource(
        gameRemoteDataSourceImpl: GameRemoteDataSourceImpl,
    ): GameRemoteDataSource
    //endregion
}