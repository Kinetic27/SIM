package kr.co.highton.slacks.sim;

import com.google.gson.annotations.SerializedName;

/**
 * SIM
 * Created by KimWonJun on 6/3/2018.
 */
public class QuestionRepo {
    @SerializedName("id")
    String id;
    @SerializedName("writer")
    String writer;
    @SerializedName("content")
    String content;
    @SerializedName("date")
    String date;
}