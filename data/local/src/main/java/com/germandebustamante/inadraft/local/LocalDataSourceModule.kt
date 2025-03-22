package com.germandebustamante.inadraft.local

import com.germandebustamante.inadraft.datasource.formation.FormationLocalDataSource
import com.germandebustamante.inadraft.datasource.game.GameLocalDataSource
import com.germandebustamante.inadraft.datasource.player.PlayerLocalDataSource
import com.germandebustamante.inadraft.datasource.position.PositionLocalDataSource
import com.germandebustamante.inadraft.datasource.team.TeamLocalDataSource
import com.germandebustamante.inadraft.local.datasource.FormationLocalDataSourceImpl
import com.germandebustamante.inadraft.local.datasource.GameLocalDataSourceImpl
import com.germandebustamante.inadraft.local.datasource.PlayerLocalDataSourceImpl
import com.germandebustamante.inadraft.local.datasource.PositionLocalDataSourceImpl
import com.germandebustamante.inadraft.local.datasource.TeamLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindPlayerLocalDataSource(playerLocalDataSourceImpl: PlayerLocalDataSourceImpl): PlayerLocalDataSource

    @Binds
    abstract fun bindTeamLocalDataSource(teamLocalDataSourceImpl: TeamLocalDataSourceImpl): TeamLocalDataSource

    @Binds
    abstract fun bindPositionLocalDataSource(positionLocalDataSourceImpl: PositionLocalDataSourceImpl): PositionLocalDataSource

    @Binds
    abstract fun bindFormationLocalDataSource(formationLocalDataSourceImpl: FormationLocalDataSourceImpl): FormationLocalDataSource

    @Binds
    abstract fun bindGameLocalDataSource(gameLocalDataSourceImpl: GameLocalDataSourceImpl): GameLocalDataSource
}