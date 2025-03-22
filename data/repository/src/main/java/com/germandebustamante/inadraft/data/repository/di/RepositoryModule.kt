package com.germandebustamante.inadraft.data.repository.di

import com.germandebustamante.inadraft.data.repository.formation.FormationRepositoryImpl
import com.germandebustamante.inadraft.data.repository.game.GameRepositoryImpl
import com.germandebustamante.inadraft.data.repository.player.PlayerRepositoryImpl
import com.germandebustamante.inadraft.data.repository.position.PositionRepositoryImpl
import com.germandebustamante.inadraft.data.repository.team.TeamRepositoryImpl
import com.germandebustamante.inadraft.domain.formation.repository.FormationRepository
import com.germandebustamante.inadraft.domain.game.repository.GameRepository
import com.germandebustamante.inadraft.domain.player.repository.PlayerRepository
import com.germandebustamante.inadraft.domain.position.repository.PositionRepository
import com.germandebustamante.inadraft.domain.team.repository.TeamRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindPlayerRepository(playerRepository: PlayerRepositoryImpl): PlayerRepository

    @Binds
    abstract fun bindTeamRepository(teamRepository: TeamRepositoryImpl): TeamRepository

    @Binds
    abstract fun bindPositionRepository(positionRepository: PositionRepositoryImpl): PositionRepository

    @Binds
    abstract fun bindFormationRepository(formationRepository: FormationRepositoryImpl): FormationRepository

    @Binds
    abstract fun bindGameRepository(gameRepository: GameRepositoryImpl): GameRepository
}