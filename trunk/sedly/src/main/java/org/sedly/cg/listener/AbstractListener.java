package org.sedly.cg.listener;


public abstract class AbstractListener<T> implements Listener<T> {

    public AbstractListener(Listenable<T> listenable) {
        listenable.subscribe(this);
    }

    @Override
    public abstract void listen(Event<T> event);

}
