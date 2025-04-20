import java.util.Scanner;
import Management.*;
import Management.Orders;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int q = scn.nextInt();
        for(int i = 0; i < q ; i++){
            String command = scn.nextLine();
            String[] parts = command.split(" ");
            try{
                switch (parts[0]) {
                    case "add_device":
                        Orders.addDevice(parts[1], parts[2], parts[3]);
                        break;
                    case "set_device":
                        Orders.setDevice(parts[1], parts[2], parts[3]);
                        break;
                    case "remove_device":
                        Orders.removeDevice(parts[1]);
                        break;
                    case "list_devices":
                        Orders.listDevices();
                        break;
                    case "add_rule":
                        Orders.addRule(parts[1], parts[2], parts[3]);
                        break;
                    case "check_rules":
                        checkRules(parts[1]);
                        break;
                    case "list_rules":
                        listRules();
                        break;
                }
            }catch (Exception e){
                System.out.println("invalid input");
            }
        }
    }
}