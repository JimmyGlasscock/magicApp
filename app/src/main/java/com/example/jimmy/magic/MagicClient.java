package com.example.jimmy.magic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;
import java.net.*;

public class MagicClient implements Runnable{

    Socket socket;

    int command = 0;

    String ip;
    String url = "www.bing.com";

    Menu menu;

    public MagicClient(String str){
        menu = new Menu();
        ip = str;
    }

    @Override
    public void run() {
        try{
            //192.168.1.40
            //InetAddress address = InetAddress.getByName("10.18.33.82");

            InetAddress address = InetAddress.getByName(ip);
            socket = new Socket(address, 9999);

            DataOutputStream out =new DataOutputStream(socket.getOutputStream());
            while(true){
                if(command == 1){
                    out.writeUTF("Calculator");
                    out.flush();
                    command = 0;
                }

                if(command == 2){
                    out.writeUTF("Notepad");
                    out.flush();
                    command = 0;
                }

                if(command == 3){
                    out.writeUTF("Logout");
                    out.flush();
                    command = 0;
                }

                if(command == 4){
                    out.writeUTF("Shutdown");
                    out.flush();
                    command = 0;
                }
                if(command == 5){
                    out.writeUTF("start chrome \" "+ url + "\"");
                    out.flush();
                    command = 0;
                }
                if(command == 6){
                    out.writeUTF("spamMouse");
                    out.flush();
                    command = 0;
                }
                if(command == 7){
                    out.writeUTF("stopMouse");
                    out.flush();
                    command = 0;
                }
            }

        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setCommand(int num){
        command = num;
    }


    public void closeSocket(){
        try{
            socket.close();
        }catch(IOException e){

        }
    }

    public void setURL(String newurl){
        url = newurl;
    }

}
