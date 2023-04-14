package by.bsu.jfwf.session;

public interface SessionContext {

    <T> T get(String name);

    <T> void set(String name, T value);

    void setChanged(String name);

    boolean isChanged(String name);

}
