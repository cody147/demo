package id.cody.tool.interceptor;

public interface Interceptor<T,V> {

    V intercept(Chain<T, V> chain);

    interface Chain <T,V>{
        V proceed(T request);

        T request();
    }

}
