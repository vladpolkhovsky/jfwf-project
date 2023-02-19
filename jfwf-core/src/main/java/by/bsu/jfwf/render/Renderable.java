package by.bsu.jfwf.render;

import by.bsu.jfwf.session.SessionContext;

@FunctionalInterface
public interface Renderable {

    String render(SessionContext sessionContext);

}
