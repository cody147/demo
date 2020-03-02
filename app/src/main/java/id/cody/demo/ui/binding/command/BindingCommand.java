package id.cody.demo.ui.binding.command;

public class BindingCommand<T> {


    private BindingAction execute;
    private BindingConsumer<T> consumer;
    private BindingFunction<Boolean> canExecute0;

    public BindingCommand(BindingAction execute){
        this.execute=execute;
    }

    public void execute(){
        if(execute!=null){
            execute.call();
        }
    }

}
