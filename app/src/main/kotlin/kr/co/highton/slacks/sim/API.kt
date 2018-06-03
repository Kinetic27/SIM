package kr.co.highton.slacks.sim

import retrofit2.Call
import retrofit2.http.*

/**
 * Created by Kinetic on 2018-06-02.
 */

interface API {

    @GET("/place")
    fun getPlace() :  Call<ArrayList<LocationRepo>>

    @POST("/user/signin")
    @FormUrlEncoded
    fun logIn(@Field("id") id : String, @Field("pw") pw : String) :  Call<Void>

    @POST("/user/signup")
    @FormUrlEncoded
    fun logUp(@Field("name") name : String, @Field("id") id : String, @Field("pw") pw : String) :  Call<Void>

    @GET("/qna")
    fun getQuestionList() : Call<ArrayList<QuestionRepo>>

    @POST("/qna")
    @FormUrlEncoded
    fun writeQuestion(@Field("writer") writer : String, @Field("content") content : String)

    @GET("/qna/{id}")
    fun getQuestionDetail(@Path("id") id : String)

    @POST("/qna/{id}")
    @FormUrlEncoded
    fun writeAnswer(@Path("id") id : String, @Field("writer") writer: String, @Field("content") content: String)
}