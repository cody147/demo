package id.cody.demo.ui.register;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import id.cody.demo.R;
import id.cody.demo.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding registerBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerBinding= DataBindingUtil.setContentView(this, R.layout.activity_register);


        User2 user2=new User2();
        registerBinding.setUser2(user2);
        user2.username.set("123");
        user2.password.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(RegisterActivity.this,s,Toast.LENGTH_LONG).show();
            }
        });
        user2.password.setValue("5656");

        new Handler().postDelayed(()->{
            user2.username.set("99999");
            user2.password.setValue("99999");
        },5000);


    }
}
