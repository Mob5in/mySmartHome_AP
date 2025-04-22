package Management;
import java.util.HashMap;
import java.util.Iterator;

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



    public static void removeDevice(String name) {
        if (!devices.containsKey(name)) {
            System.out.println("device not found");
            return;
        }
        devices.remove(name);
        rules.values().removeIf(rule -> rule.name.equals(name));
        System.out.println("device removed successfully");
    }

    public static void listDevices() {
        if (devices.isEmpty()) {
            System.out.println();
            return;
        }
        for (Device device : devices.values()) {
            System.out.println(device.getStatus());
        }
    }

    public static void addRule(String name, String time, String action) {
        if (!devices.containsKey(name)) {
            System.out.println("device not found");
            return;
        }
        if (!action.equals("on") && !action.equals("off")) {
            System.out.println("invalid action");
            return;
        }
        String ruleKey = name + time;
        if (rules.containsKey(ruleKey)) {
            System.out.println("duplicate rule");
            return;
        }

        if (!isValidTime(time)) {
            System.out.println("invalid time");
            return;
        }

        rules.put(ruleKey, new Rule(name, time, action));
        System.out.println("rule added successfully");
    }

    private static boolean isValidTime(String time) {
        try {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            return hour >= 0 && hour < 24 && minute >= 0 && minute < 60;
        } catch (Exception e) {
            return false;
        }
    }

    public static void check_rules(String time){
        if(!isValidTime(time)){
            System.out.println("Invalid time");
            return;
        }

        for(Rule rule: rules.values()){
            if(rule.time.equals(time)){
                devices.get(rule.name).setProperty("stauts", rule.action);
            }
        }
        System.out.println("rules checked");

    }

    public static void listRules() {
        if (rules.isEmpty()) {
            System.out.println();
            return;
        }
        for (Rule rule : rules.values()) {
            System.out.println(rule.name + " " + rule.time + " " + rule.action);
        }
    }

}
