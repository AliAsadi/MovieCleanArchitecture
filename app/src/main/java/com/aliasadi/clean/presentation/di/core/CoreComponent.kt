package com.aliasadi.clean.presentation.di.core

import com.aliasadi.clean.presentation.di.core.module.AppModule
import com.aliasadi.clean.presentation.di.core.module.DataModule
import com.aliasadi.clean.presentation.di.core.module.DatabaseModule
import com.aliasadi.clean.presentation.di.core.module.NetworkModule
import com.aliasadi.clean.presentation.di.details.MovieDetailsModule
import com.aliasadi.clean.presentation.di.details.MovieDetailsSubComponent
import com.aliasadi.clean.presentation.di.feed.FeedModule
import com.aliasadi.clean.presentation.di.feed.FeedSubComponent
import com.aliasadi.clean.presentation.di.main.MainModule
import com.aliasadi.clean.presentation.di.main.MainSubComponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Ali Asadi on 15/05/2020
 **/
@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        DataModule::class
    ]
)

interface CoreComponent {
    fun plus(movieDetailsModule: MovieDetailsModule): MovieDetailsSubComponent
    fun plus(feedModule: FeedModule): FeedSubComponent
    fun plus(mainModule: MainModule): MainSubComponent
}