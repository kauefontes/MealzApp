package dev.quewui.mealzapp.model.api

import dev.quewui.mealzapp.model.response.CategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class CategoriesWebService {
    private var api: CategoriesApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(CategoriesApi::class.java)
    }

    suspend fun getCategories(): CategoriesResponse {
        return api.getCategories()
    }

    interface CategoriesApi {
        @GET("categories.php")
        suspend fun getCategories(): CategoriesResponse
    }
}