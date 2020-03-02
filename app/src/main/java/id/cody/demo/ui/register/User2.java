package id.cody.demo.ui.register;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;

public class User2 {

    public final ObservableField<String> username=new ObservableField<>();
    public final MutableLiveData<String> password=new MutableLiveData<>();
    public final ObservableInt age=new ObservableInt();
    public final ObservableBoolean isStudent=new ObservableBoolean();

}
