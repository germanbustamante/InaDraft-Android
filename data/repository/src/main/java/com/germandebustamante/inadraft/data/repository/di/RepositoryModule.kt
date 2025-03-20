package com.germandebustamante.inadraft.data.repository.di

import com.germandebustamante.inadraft.data.repository.FormationRepository
import com.germandebustamante.inadraft.data.repository.GameRepository
import com.germandebustamante.inadraft.data.repository.PlayerRepository
import com.germandebustamante.inadraft.data.repository.PositionRepository
import com.germandebustamante.inadraft.data.repository.TeamRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.germandebustamante.inadraft.datasource.FormationLocalDataSource
import com.germandebustamante.inadraft.datasource.FormationRemoteDataSource
import com.germandebustamante.inadraft.datasource.game.GameLocalDataSource
import com.germandebustamante.inadraft.datasource.game.GameRemoteDataSource
import com.germandebustamante.inadraft.datasource.player.PlayerLocalDataSource
import com.germandebustamante.inadraft.datasource.player.PlayerRemoteDataSource
import com.germandebustamante.inadraft.datasource.position.PositionLocalDataSource
import com.germandebustamante.inadraft.datasource.position.PositionRemoteDataSource
import com.germandebustamante.inadraft.datasource.team.TeamLocalDataSource
import com.germandebustamante.inadraft.datasource.team.TeamRemoteDataSource

/**
 * Modulo de inyección de dependencias sobre el módulo data:repository
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun teamRepositoryProvider(
        teamRemoteDataSource: TeamRemoteDataSource,
        teamLocalDataSource: TeamLocalDataSource,
    ) =
        TeamRepository(teamRemoteDataSource, teamLocalDataSource)

    @Provides
    fun playerRepositoryProvider(
        playerRemoteDataSource: PlayerRemoteDataSource,
        playerLocalDataSource: PlayerLocalDataSource,
        teamRepository: TeamRepository,
        positionRepository: PositionRepository,
        formationRepository: FormationRepository,
        gameRepository: GameRepository
    ) =
        PlayerRepository(
            playerRemoteDataSource,
            playerLocalDataSource,
            teamRepository,
            positionRepository,
            formationRepository,
            gameRepository
        )

    @Provides
    fun positionRepositoryProvider(
        positionRemoteDataSource: PositionRemoteDataSource,
        positonLocalDataSource: PositionLocalDataSource,
    ) =
        PositionRepository(positionRemoteDataSource, positonLocalDataSource)

    @Provides
    fun formationRepositoryProvider(
        formationRemoteDataSource: FormationRemoteDataSource,
        formationLocalDataSource: FormationLocalDataSource,
    ) =
        FormationRepository(formationRemoteDataSource, formationLocalDataSource)

    @Provides
    fun gameRepositoryProvider(
        gameRemoteDataSource: GameRemoteDataSource,
        gameLocalDataSource: GameLocalDataSource,
        formationRepository: FormationRepository
    ) =
        GameRepository(gameLocalDataSource, gameRemoteDataSource, formationRepository)
}