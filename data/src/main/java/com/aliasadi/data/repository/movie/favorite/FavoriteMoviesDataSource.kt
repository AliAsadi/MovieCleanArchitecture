package com.aliasadi.data.repository.movie.favorite

import com.aliasadi.domain.entities.MovieEntity
import com.aliasadi.domain.util.Result
import kotlinx.coroutines.flow.Flow

/**
 * @author by Ali Asadi on 22/08/2022
 */
interface FavoriteMoviesDataSource {

    interface Local {
        fun favoriteMovies(): Flow<List<MovieEntity>>
        suspend fun getFavoriteMovieIds(): Result<List<Int>>
        suspend fun addMovieToFavorite(movieId: Int)
        suspend fun removeMovieFromFavorite(movieId: Int)
        suspend fun checkFavoriteStatus(movieId: Int): Result<Boolean>
    }

}