package leavesc.hello.dokv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import leavesc.hello.dokv.model.Book;
import leavesc.hello.dokv.model.CustomKeyUserDoKV;
import leavesc.hello.dokv.model.User;
import leavesc.hello.dokv.model.UserDoKV;

/**
 * 作者：leavesC
 * 时间：2019/1/4 23:15
 * 描述：
 * GitHub：https://github.com/leavesC
 * Blog：https://www.jianshu.com/u/9df45b87cfdf
 */
public class MainActivity extends AppCompatActivity {

    private EditText et_userName;

    private EditText et_userAge;

    private EditText et_bookName;

    private EditText et_userSex;

    private Button btn_serializeAll;

    private EditText et_singleUserName;

    private Button btn_serializeSingle;

    private Button btn_remove;

    private Button btn_clear;

    private Button btn_print;

    private TextView tv_hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btn_serializeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = et_userName.getText().toString();
                String ageStr = et_userAge.getText().toString();
                int age = 0;
                if (!TextUtils.isEmpty(ageStr)) {
                    age = Integer.parseInt(ageStr);
                }
                User user = new User();
                user.setAge(age);
                user.setName(userName);
                user.setSex(et_userSex.getText().toString());
                List<String> stringList = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    stringList.add(String.valueOf(i));
                }
                user.setStringList(stringList);
                Book book = new Book();
                book.setName(et_bookName.getText().toString());
                user.setBook(book);
                UserDoKV.get().setUser(user);
            }
        });
        btn_serializeSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = et_singleUserName.getText().toString();
                UserDoKV.get().setName(userName);
            }
        });
        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDoKV.get().remove();
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoKV.clear();
            }
        });
        btn_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                sb.append("User : ----->").append(UserDoKV.get().getUser());
                sb.append("\n\n");
                sb.append("User Name : ----->").append(UserDoKV.get().getName());

                sb.append("\n\n");
                sb.append("CustomKeyUser : ----->").append(CustomKeyUserDoKV.get().getCustomKeyUser());

                tv_hint.setText(sb);
            }
        });

        CustomKeyUserDoKV.get().setKey("这是默认赋予的值");
    }

    private void initView() {
        et_userName = findViewById(R.id.et_userName);
        et_userAge = findViewById(R.id.et_userAge);
        et_bookName = findViewById(R.id.et_bookName);
        et_userSex = findViewById(R.id.et_userSex);
        btn_serializeAll = findViewById(R.id.btn_serializeAll);
        et_singleUserName = findViewById(R.id.et_singleUserName);
        btn_serializeSingle = findViewById(R.id.btn_serializeSingle);
        btn_remove = findViewById(R.id.btn_remove);
        btn_clear = findViewById(R.id.btn_clear);
        btn_print = findViewById(R.id.btn_print);
        tv_hint = findViewById(R.id.tv_hint);
    }

}