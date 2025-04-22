package Management;

public class Thermostat extends Device{

    private String status = "off";
    private int brightness = 20;


    public Thermostat(String name, String protocol) {
        super(name, protocol);
    }

    @Override
    public void setProperty(String property, String value) {
        if(property.equals("status")){
            if(value.equals("on") || value.equals("off")){
                this.status = value;
            }else{
                throw new IllegalArgumentException("this value is not acceptable");
            }
        } else if (property.equals("brightness")) {
            int brightnessValue = Integer.parseInt(value);
            if( (brightnessValue<=30) && (brightnessValue>=10)) {
                this.brightness = brightnessValue;
            }else{
                throw new IllegalArgumentException("this value is not acceptable");
            }
        }else {
            throw new IllegalArgumentException("Invalid properrty");
        }
    }

    @Override
    public String getStatus() {
        return String.format("Thermostat: %s %s %d%% %s", name, status, brightness, protocol);
    }
}
