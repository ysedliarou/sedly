package org.sedly.cg.listener;

public interface Listenable<T> {

    void publish();

    void subscribe(Listener<T> listener);

    void unSubscribe(Listener<T> listener);

}
