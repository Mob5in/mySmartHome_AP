package Management;

public class Light extends Device {

    private String status = "off";
    private int brightness = 50;

    public Light(String name, String protocol) {
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
                if( (brightnessValue<=100) && (brightnessValue>=0)) {
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
        return String.format("light: %s %s %d%% %s", name, status, brightness, protocol);
    }

}
