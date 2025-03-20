package com.germandebustamante.inadraft.usecases.di

import com.germandebustamante.inadraft.data.repository.FormationRepository
import com.germandebustamante.inadraft.data.repository.GameRepository
import com.germandebustamante.inadraft.data.repository.PlayerRepository
import com.germandebustamante.inadraft.data.repository.PositionRepository
import com.germandebustamante.inadraft.data.repository.TeamRepository
import com.germandebustamante.inadraft.usecases.GetBestGamesUseCase
import com.germandebustamante.inadraft.usecases.GetFormationsUseCase
import com.germandebustamante.inadraft.usecases.GetPlayerByIdUseCase
import com.germandebustamante.inadraft.usecases.GetPlayersByTeamUseCase
import com.germandebustamante.inadraft.usecases.GetPositionsUseCase
import com.germandebustamante.inadraft.usecases.GetRandomPlayersByPositionUseCase
import com.germandebustamante.inadraft.usecases.GetTeamsUseCase
import com.germandebustamante.inadraft.usecases.InsertFinishedGameUseCase
import com.germandebustamante.inadraft.usecases.PopulateDatabaseUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Modulo de inyección de dependencias sobre el módulo data:usescases
 */
@Module
@InstallIn(SingletonComponent::class)
object UsesCasesModule {

    @Provides
    fun populateDatabaseUseCaseProvider(playerRepository: PlayerRepository) =
        PopulateDatabaseUseCase(playerRepository)

    @Provides
    fun loadTeamsUseCaseProvider(teamRepository: TeamRepository): GetTeamsUseCase =
        GetTeamsUseCase(teamRepository)

    @Provides
    fun getPlayerListByTeamUseCaseProvider(playerRepository: PlayerRepository) =
        GetPlayersByTeamUseCase(playerRepository)

    @Provides
    fun getPositionListUseCaseProvider(positionRepository: PositionRepository) =
        GetPositionsUseCase(positionRepository)

    @Provides
    fun getFormationsUseCaseProvider(formationRepository: FormationRepository) =
        GetFormationsUseCase(formationRepository)

    @Provides
    fun getRandomPlayersByPositionUseCaseProvider(repository: PlayerRepository) =
        GetRandomPlayersByPositionUseCase(repository)

    @Provides
    fun getPlayerByIdUseCaseProvider(repository: PlayerRepository) =
        GetPlayerByIdUseCase(repository)

    @Provides
    fun getGamesUseCaseProvider(repository: GameRepository) =
        GetBestGamesUseCase(repository)

    @Provides
    fun insertFinishedGameUseCaseProvider(repository: GameRepository) =
        InsertFinishedGameUseCase(repository)

}