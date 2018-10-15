package com.katien.project.remote.util


/**
 * A result monad for server requests with specific error types that we want to handle in the UI
 * */
sealed class Result<T, E> {
    class Success<T, E>(val value: T) : Result<T, E>()
    class Error<T, E>(val value: E) : Result<T, E>()
}