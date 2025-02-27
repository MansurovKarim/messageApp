package com.example.messageapp.data.service

import com.example.messageapp.data.models.MessagesResponse
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ChatApiService {
    @GET("chat/{chatId}")
    suspend fun getChatById(
        @Path("chatId") chatId: Int
    ) : Response<List<MessagesResponse>>

    @POST("chat/send")
    @FormUrlEncoded
    suspend fun sendMessage(
        @Field("chatId") chatId: Int,
        @Field("senderId") senderId: Int,
        @Field("receiverId") receiverId: Int,
        @Field("message") message: String
    ) : Response<MessagesResponse>


    @PUT("chat/{chatId}/message/{messageId}")
    @FormUrlEncoded
    suspend fun editMessage(
        @Path("chatId") chatId: Int,
        @Path("messageId") messageId: Int,
        @Field("newMessage") newMessage: String
    ) : Response<MessagesResponse>

    @DELETE("chat/{chatId}/message/{messageId}")
    suspend fun deleteMessage(
        @Path("chatId") chatId: Int,
        @Path("messageId") messageId: Int,
    ) : Response<Unit>

}