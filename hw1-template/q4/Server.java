public class Server {

    private Socket socket = null; //Inititalizing Socket
    private ServerSocket server = null; //Initializing Server
    private DataInputStream in = null; //Initializing Input Stream

    public Server(int port){
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client...");

            socket = server.accept();
            System.out.println("Client Accepted");

            in = new DataInputStream( new BufferedInputStream(socket.getInputStream()));

            String line = "";

            while (!line.equals("Over")){
                try {
                    line = in.readUTF();
                    System.out.println(line);
                }
                catch(IOException i){
                    System.out.println(i);
                }
            }
            System.out.println("Closing Connection");

            socket.close();
            in.close();

        }
        catch(IOExcpetion i){
            System.out.println(i);
        }

    }
  public static void main (String[] args) {
    int tcpPort;
    int udpPort;
    if (args.length != 3) {
      System.out.println("ERROR: Provide 3 arguments");
      System.out.println("\t(1) <tcpPort>: the port number for TCP connection");
      System.out.println("\t(2) <udpPort>: the port number for UDP connection");
      System.out.println("\t(3) <file>: the file of inventory");

      System.exit(-1);
    }
    tcpPort = Integer.parseInt(args[0]);
    udpPort = Integer.parseInt(args[1]);
    String fileName = args[2];

    // parse the inventory file

    // TODO: handle request from clients
    
}
}
