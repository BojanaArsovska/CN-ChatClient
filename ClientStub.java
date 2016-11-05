import java.io.*;
import java.net.*;

/**
 * VUnetID: <fill in your VUnetID here>
 **/
class ClientStub
{
  BufferedReader in;
  PrintStream out;
  boolean exit;

  ClientStub() {
    in   = new BufferedReader(new InputStreamReader(System.in));
    out  = new PrintStream(System.out);
    exit = false;
  }

  boolean sayHello(BufferedReader srvIn, PrintWriter srvOut) {
    /* todo: ask the user which name they want to use, and 
       then perform a handshake with the server */
    return true;
  }

  void handleInput(BufferedReader srvIn, PrintWriter srvOut)
    throws IOException {
    String line = in.readLine();
    if(line == null) {
      out.println("could not read line from user");
      return;
    }

    /* supported commands:
       !who          - perform a WHO request to the server
       @<user> <msg> - send <msg> to <user>
       !exit         - stop the program */
    if(line.equals("!who")) {
      requestUserList(srvIn, srvOut);
    }
    else if(line.startsWith("@")) {
      sendMessage(line, srvIn, srvOut);
    }
    else if(line.equals("!exit")) {
      exit = true;
    }
    else {
      out.println("unknown command");
    }
  }

  void requestUserList(BufferedReader srvIn, PrintWriter srvOut)
    throws IOException {
    /* todo: send a who request to srvOut, read the response from 
       srvIn, and display it on out */
  }

  void sendMessage(String line, BufferedReader srvIn, PrintWriter srvOut) 
    throws IOException {
    /* todo: send the message stored in the String line on srvOut 
       after parsing it as needed, making sure to check for any 
       errors returned on srvIn */
  }

  void recvMessage(BufferedReader srvIn) 
    throws IOException {
    /* todo: read a message from srvIn, and display it on out */
  }

  void start(String[] argv) {
    if(argv.length != 2) {
      out.println("usage: java ClientStub <server> <port>");
      return;
    }

    Socket sock          = null;
    BufferedReader srvIn = null;
    PrintWriter srvOut   = null;
    /* todo: create the Socket using argv[0] as server name and 
       argv[1] as port, and get the BufferedReader and PrintWriter 
       from it */

    if(!sayHello(srvIn, srvOut)) {
      /* todo: cleanup and exit */
      return;
    }

    while(!exit) {
      try {
        if(in.ready()) {
          handleInput(srvIn, srvOut);
        }
        if(srvIn.ready()) {
          recvMessage(srvIn);
        }
        Thread.sleep(200);
      }
      catch(IOException e) {
        out.println(e.getMessage());
      }
      catch(InterruptedException e) {}
    }

    /* todo: close the Socket */
  }

  public static void main(String[] argv) {
    new ClientStub().start(argv);
  }
}
