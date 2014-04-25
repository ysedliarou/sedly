package org.sedly.cg.listener;

public abstract class CommandInvokerListener<S, P> extends AbstractListener<S> {

    private P parent;

    public P getParent() {
        return parent;
    }

    public CommandInvokerListener(Listenable<S> listenable) {
        super(listenable);
    }

    protected CommandInvokerListener(Listenable<S> listenable, P parent) {
        this(listenable);
        this.parent = parent;
    }

    @Override
    public void listen(Event<S> event) {
        createCommand(event.getContent()).execute();
    }

    protected abstract Command<Void> createCommand(S source);

}
