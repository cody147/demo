package id.cody.demo.ui.me;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import id.cody.demo.R;
import id.cody.demo.databinding.ActivityMeBinding;

public class MeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        ActivityMeBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_me);
        MeViewModel viewModel=ViewModelProviders.of(this).get(MeViewModel.class);
        viewModel.inject();
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
        getLifecycle().addObserver(viewModel);
    }


}
