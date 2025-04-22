package Management;

public class Light extends Device {

    private String status = "off";
    private int brightness = 50;

    public Light(String name, String protocol) {
        super(name, protocol);
    }

    @Override
    public void setProperty(String property, String value) {

    }

    @Override
    public String getStatus() {
        return String.format("light: %s %s %d%% %s", name, status, brightness, protocol);
    }

}
