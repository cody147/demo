package id.cody.tool.interceptor;

import java.util.List;

public class RealChain<T,V> implements Interceptor.Chain<T,V>{


    private List<Interceptor<T,V>> interceptors;
    private int index;
    private T request;

    public RealChain(List<Interceptor<T,V>> interceptors,int index,T request){
        this.index=index;
        this.interceptors=interceptors;
        this.request=request;
    }

    @Override
    public V proceed(T request) {
        if(index>=interceptors.size()){
            throw new RuntimeException("最后一个拦截器不应该向下调用");
        }
        RealChain<T,V> chain=new RealChain<>(interceptors,index+1,request);
        Interceptor<T,V> interceptor=interceptors.get(index);
        V response= interceptor.intercept(chain);
        return response;
    }

    @Override
    public T request() {
        return request;
    }
}
