package Management;

public abstract class Device {
    protected String name;
    protected String protocol;

    public Device(String name, String protocol){
        this.name = name;
        this.protocol = protocol;
    }

    public abstract void setProperty(String property, String value);
    public abstract String getStatus();
}
