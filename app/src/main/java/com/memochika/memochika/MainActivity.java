package com.memochika.memochika;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Key;

public class MainActivity extends Activity {
    private EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //入力されているテキストを取得
        String Keyword = mEditText.getText().toString();

        //連携処理を実施(動かない)
        int id = item.getItemId();
        try {
            if (id == R.id.search) {
                //テキスト連携
                if (!checkEmpty(Keyword)) {
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, Keyword);
                    startActivity(intent);

//                } else if (id == R.id.PlaySerach) {
//                    //PlayStore検索
//                    if (!checkEmpty(Keyword)) {
//                        Uri uri = Uri.parse("https://play.google.com/store/search");
//                    }
                }
            }
            }catch(ActivityNotFoundException e){
                //開こうとしているアプリが見つからないエラー
                Toast.makeText(this, getString(R.string.app_notfound), Toast.LENGTH_LONG).show();
            }
            return super.onOptionsItemSelected(item);
        }
    private boolean checkEmpty(String Keyword){
        if(TextUtils.isEmpty(Keyword)){
            Toast.makeText(this, "キーワード", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}


