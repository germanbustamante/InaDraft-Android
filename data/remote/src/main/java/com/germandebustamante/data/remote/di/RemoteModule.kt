package com.germandebustamante.data.remote.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.germandebustamante.inadraft.datasource.FormationRemoteDataSource
import com.germandebustamante.inadraft.datasource.game.GameRemoteDataSource
import com.germandebustamante.inadraft.datasource.player.PlayerRemoteDataSource
import com.germandebustamante.inadraft.datasource.position.PositionRemoteDataSource
import com.germandebustamante.data.remote.DateRemoteAdapter
import com.germandebustamante.data.remote.datasource.FormationRemoteDataSourceImpl
import com.germandebustamante.data.remote.datasource.GameRemoteDataSourceImpl
import com.germandebustamante.data.remote.datasource.PlayerRemoteDataSourceImpl
import com.germandebustamante.data.remote.datasource.TeamRemoteDataSourceImpl
import com.germandebustamante.data.remote.api.InaDraftApiService
import com.germandebustamante.data.remote.datasource.PositionRemoteDataSourceImpl
import com.germandebustamante.inadraft.datasource.team.TeamRemoteDataSource
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val MAX_TIME_CONNECT_TIMEOUT_RETROFIT = 30L
private const val MAX_TIME_READ_TIMEOUT_RETROFIT = 30L

/**
 * Modulo de inyección de dependencias sobre el módulo data:remote
 */
@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    private const val RETROFIT_PRODUCTS_API_BASE_URL = "https://inadraft.azurewebsites.net/api/"

    //region datasources

    @Provides
    fun teamRemoteDataSourceProvider(apiService: InaDraftApiService): TeamRemoteDataSource =
        TeamRemoteDataSourceImpl(apiService)

    @Provides
    fun playerRemoteDataSourceProvider(apiService: InaDraftApiService): PlayerRemoteDataSource =
        PlayerRemoteDataSourceImpl(apiService)

    @Provides
    fun positionRemoteDataSourceProvider(apiService: InaDraftApiService): PositionRemoteDataSource =
        PositionRemoteDataSourceImpl(apiService)

    @Provides
    fun formationRemoteDataSourceProvider(apiService: InaDraftApiService): FormationRemoteDataSource =
        FormationRemoteDataSourceImpl(apiService)

    @Provides
    fun gameRemoteDataSourceProvider(apiService: InaDraftApiService): GameRemoteDataSource =
        GameRemoteDataSourceImpl(apiService)

    //endregion

    //region retrofit + moshi

    @Provides
    fun httpClientProvider(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(MAX_TIME_CONNECT_TIMEOUT_RETROFIT, TimeUnit.SECONDS)
            .readTimeout(MAX_TIME_READ_TIMEOUT_RETROFIT, TimeUnit.SECONDS)
            .build()

    @Provides
    fun moshiProvider(): Moshi =
        Moshi.Builder()
            .add(DateRemoteAdapter())
            .build()

    @Singleton
    @Provides
    fun retrofitProvider(moshi: Moshi, client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(RETROFIT_PRODUCTS_API_BASE_URL)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Singleton
    @Provides
    fun apiServiceProvider(retrofit: Retrofit): InaDraftApiService =
        retrofit.create(InaDraftApiService::class.java)

    //endregion
}