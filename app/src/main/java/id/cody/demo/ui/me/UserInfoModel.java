package id.cody.demo.ui.me;

import androidx.databinding.BaseObservable;

public class UserInfoModel extends BaseObservable {

    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        notifyChange();
    }
}
