import config.BrokerConfiguration;
import nodes.Broker;
import server.Server;

public class Main {
    public static void main(String [] args) {
        if (args.length == 1) {
            int x= Integer.parseInt(args[0]);
            if (x == 1) {
                BrokerConfiguration.WHO_AM_I = 1;
                BrokerConfiguration.MY_IP = BrokerConfiguration.BROKER_IP_1;
                BrokerConfiguration.MY_PORT = BrokerConfiguration.BROKER_PORT_1;
            }
            if (x == 2) {
                BrokerConfiguration.WHO_AM_I = 2;
                BrokerConfiguration.MY_IP = BrokerConfiguration.BROKER_IP_2;
                BrokerConfiguration.MY_PORT = BrokerConfiguration.BROKER_PORT_2;
            }

            if (x == 3) {
                BrokerConfiguration.WHO_AM_I = 3;
                BrokerConfiguration.MY_IP = BrokerConfiguration.BROKER_IP_3;
                BrokerConfiguration.MY_PORT = BrokerConfiguration.BROKER_PORT_3;
            }
        } else {
            System.out.println("invalid arguments");
            System.exit(1);
        }

        System.out.println("Update hashes ...");
        BrokerConfiguration.updateHashes();
        //BrokerConfiguration.print();

        System.out.println("Sort hashes ...");
        BrokerConfiguration.sortHashes();
       // BrokerConfiguration.print();

        System.out.println("-----------------------------------------------------------");
        System.out.println("I am   : Broker #" + BrokerConfiguration.WHO_AM_I);
        System.out.println("My IP  : " + BrokerConfiguration.MY_IP);
        System.out.println("My PORT: " + BrokerConfiguration.MY_PORT);

        Server server = new Server();

        server.openServer(BrokerConfiguration.MY_IP, BrokerConfiguration.MY_PORT);

    }
}
