package org.sedly.cg.listener;

public interface Command<R> {

    R execute();

}
