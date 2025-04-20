package Management;
import java.util.HashMap;

public class Orders{
    static HashMap<String, Device> devices = new HashMap<>();
    static HashMap<String, Rule> rules = new HashMap<>();

    public static void addDevice(String type, String name, String protocol){
        Device device;

        if (devices.containsKey(name)) {
            System.out.println("duplicate device name");
            return;
        }

        if (!type.equals("light") && !type.equals("thermostat")) {
            System.out.println("invalid input");
            return;
        }

        if (!protocol.equals("WiFi") && !protocol.equals("Bluetooth")) {
            System.out.println("invalid input");
            return;
        }

        if (type.equals("light")) {
            device = new Light(name, protocol);
        }else{
            device = new Thermostat(name, protocol);
        }
        devices.put(name, device);
        System.out.println("device added successfully");

    }
    public static void setDevice(String name, String property, String value){

        if (!devices.containsKey(name)) {
            System.out.println("device not found");
            return;
        }
        devices.get(name).setProperty(property, value);
        System.out.println("device updated successfully");
    }


}
