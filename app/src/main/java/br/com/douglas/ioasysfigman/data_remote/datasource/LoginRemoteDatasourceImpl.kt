package br.com.douglas.ioasysfigman.data_remote.datasource

import br.com.douglas.ioasysfigman.data.datasource.remote.LoginRemoteDatasource
import br.com.douglas.ioasysfigman.data_remote.mappers.toDomain
import br.com.douglas.ioasysfigman.data_remote.model.LoginRequest
import br.com.douglas.ioasysfigman.data_remote.service.AuthService
import br.com.douglas.ioasysfigman.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRemoteDatasourceImpl(
    private val authService: AuthService
): LoginRemoteDatasource {

    override fun login(email: String, password: String): Flow<User> = flow {

        val response = authService.signIn(LoginRequest(email, password))
        val accessToken = response.headers()["authorization"]

        if (response.isSuccessful)
            response.body()?.let {loginResponse ->
                emit(loginResponse.toDomain(accessToken?: ""))
            }
    }
}