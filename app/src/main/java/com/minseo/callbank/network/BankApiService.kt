package com.minseo.callbank.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

// Retrofit 객체 생성
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface BankApiService {
    // 서버에서 응답 문자열을 가져옴
    // Retrofit에 GET 요청임을 알리고 이 웹 서비스 메서드의 엔드포인트를 지정함(반환 유형 String)
    @GET("photos")
    fun getInfo(): String
}

// 공개 객체 BankApi 정의 (앱의 나머지 부분에서 액세스할 수 있는 공개 싱글톤 객체)
object BankApi {
    val retrofitService : BankApiService by lazy {
        retrofit.create(BankApiService::class.java) }
}