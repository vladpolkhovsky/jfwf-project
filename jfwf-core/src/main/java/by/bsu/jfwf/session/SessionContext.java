package by.bsu.jfwf.session;

public interface SessionContext {

    <T> T get(String name);

    default <T> T getOrDefault(String name, T defaultValue) {
        if (get(name) == null) {
            set(name, defaultValue);
        }
        return get(name);
    }

    <T> void set(String name, T value);

    void setChanged(String name);

    boolean isChanged(String name);

}
