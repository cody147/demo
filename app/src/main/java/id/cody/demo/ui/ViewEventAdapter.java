package id.cody.demo.ui;

import android.view.View;

import androidx.databinding.BindingAdapter;

import id.cody.demo.ui.binding.command.BindingCommand;

public class ViewEventAdapter {

    @BindingAdapter(value = {"onClickCommand"},requireAll = false)
    public static void onClickCommand(View view, BindingCommand bindingCommand){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindingCommand.execute();
            }
        });
    }


    @BindingAdapter(value = {"onClickCommand"},requireAll = false)
    public static void onClickCommand(View view,View.OnClickListener listener){
        view.setOnClickListener(listener);
    }




}
