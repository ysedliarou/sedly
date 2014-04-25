package org.sedly.cg.listener;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractListenable<T> implements Listenable<T> {

    private List<Listener<T>> listeners = new LinkedList<>();

    @Override
    public void subscribe(Listener<T> listener) {
        listeners.add(listener);
    }

    @Override
    public void unSubscribe(Listener<T> listener) {
        listeners.remove(listener);
    }

    @Override
    public void publish() {
        for (Listener<T> listener : listeners) {
            listener.listen(getEvent());
        }
    }

    protected abstract Event<T> getEvent();

}
