package com.Developer.Android_Native;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.Developer.Android_Native.model.Comments;
import com.Developer.Android_Native.model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    JsonPlaceHolder jsonPlaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    textView=findViewById(R.id.my_TextView);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
      jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);

      //getDataMOdel();
        //getCommentSData();
         getMyQueryData();

    }
    private void getMyQueryData(){
        Call<List<DataModel>> call =jsonPlaceHolder.getQueryData(4,"id","desc");
        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                if(!response.isSuccessful()){
                    textView.setText("code:" + response.code());
                    return;
                }
                List<DataModel> dataModelList =response.body();
                for(DataModel dataModel : dataModelList){
                    String content=" ";
                    content += "ID:" + dataModel.getId()+"\n";
                    content += "userId:" + dataModel.getUserId()+"\n";
                    content += "title:" + dataModel.getTitle()+"\n";
                    content += "body:" + dataModel.getText()+"\n";
                    content+="\n\n";
                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                textView.setText(t.getMessage());

            }
        });

    }

    private void getCommentSData(){
            Call<List<Comments>> call = jsonPlaceHolder.getCommentsData( 3);
            call.enqueue(new Callback<List<Comments>>() {
                @Override
                public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                    if (!response.isSuccessful()) {
                        textView.setText("code:" + response.code());
                        return;
                    }
                    List<Comments> commentsList = response.body();
                    for (Comments dataModel : commentsList) {
                        String content = " ";
                        content += "ID:" +dataModel.getId() +"\n";
                        content += "Post ID:" + dataModel.getPostId() + "\n";
                    content += "Email:" + dataModel.getEmail()+"\n";
                    content += "Name:" + dataModel.getName()+"\n";
                    content += "body:" + dataModel.getText()+"\n";
                        content += "\n\n";
                        textView.append(content);
                    }
                }

                @Override
                public void onFailure(Call<List<Comments>> call, Throwable t) {
                    textView.setText(t.getMessage());

                }
            });

    }
    private  void getDataMOdel(){
        Call<List<DataModel>> call =jsonPlaceHolder.getData();
        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                if(!response.isSuccessful()){
                    textView.setText("code:" + response.code());
                    return;
                }
                List<DataModel> dataModelList =response.body();
                for(DataModel dataModel : dataModelList){
                    String content=" ";
                    content += "ID:" + dataModel.getId()+"\n";
                    content += "userId:" + dataModel.getUserId()+"\n";
                    content += "title:" + dataModel.getTitle()+"\n";
                    content += "body:" + dataModel.getText()+"\n";
                    content+="\n\n";
                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                textView.setText(t.getMessage());

            }
        });

    }
}
