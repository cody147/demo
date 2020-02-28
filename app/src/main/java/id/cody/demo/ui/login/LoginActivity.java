package id.cody.demo.ui.login;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zhangyue.we.x2c.ano.Xml;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.cody.demo.MyApplication;
import id.cody.demo.R;
import id.cody.demo.di.DaggerLoginComponent;
import id.cody.demo.di.LoginModule;
import id.cody.domain.login.model.UserInfo;

@Xml(layouts = "activity_login")
public class LoginActivity extends AppCompatActivity implements LoginContract.View{

    @BindView(R.id.et_username)
    EditText usernameEt;
    @BindView(R.id.et_password)
    EditText passwordEt;


    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        X2C.setContentView(this, R.layout.activity_login);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        findViewById(R.id.btn_login).setOnClickListener((view -> {
            loginPresenter.login(usernameEt.getText().toString(),passwordEt.getText().toString());
        }));

        DaggerLoginComponent.builder()
                .loginModule(new LoginModule(this))
                .appComponent(MyApplication.provideAppComponent())
                .build().inject(this);
    }

    @Override
    public void loginSuccess(UserInfo user) {
        Toast.makeText(this,user.toString(),Toast.LENGTH_LONG).show();
    }


    //闪退，待查问题
//    @OnClick(R.id.btn_login)
//    public void testclick(){
////                Toast.makeText(this,"点击测试",Toast.LENGTH_LONG).show();
//    }


}
