package Management;

public class Thermostat extends Device{

    private String status = "off";
    private int brightness = 20;


    public Thermostat(String name, String protocol) {
        super(name, protocol);
    }

    @Override
    public void setProperty(String property, String value) {

    }

    @Override
    public String getStatus() {
        return "";
    }
}
