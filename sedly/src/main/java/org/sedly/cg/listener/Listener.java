package org.sedly.cg.listener;

public interface Listener<T> {

    void listen(Event<T> event);

}
