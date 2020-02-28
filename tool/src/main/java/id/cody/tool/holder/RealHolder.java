package id.cody.tool.holder;

public class RealHolder<T> implements Holder<T> {


    T source;

    @Override
    public void set(T source) {
        this.source=source;

    }

    @Override
    public T get() {
        return source;
    }
}
