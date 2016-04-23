import java.io.*;
import java.net.*;
class Server
{
    public static void main(String args[]) throws IOException
    {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] recData = new byte[1024];
        int i =0;

        FileWriter file = new FileWriter("/home/out.txt");
        PrintWriter out = new PrintWriter(file);

        while(true)
        {
            DatagramPacket recPacket = new DatagramPacket(recData, recData.length);
            serverSocket.receive(recPacket);
            System.out.println("\n Packet length: " + recPacket.getLength());
            String line = new String(recPacket.getData(), 0, recPacket.getLength());
            System.out.println("\n Data: " + line);
            out.println(line);
            System.out.println("\nPacket" + ++i + " written to file\n");
            out.flush();
        }
    }
}