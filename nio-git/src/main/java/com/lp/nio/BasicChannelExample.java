package com.lp.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BasicChannelExample {

    public static void main(String[] args) {
        try {
            RandomAccessFile accessFile = new RandomAccessFile(
                    "I:/git/NIO-git/nio-git/src/main/resources/nio-data.txt", "rw");
            FileChannel inputChannel = accessFile.getChannel();
            ByteBuffer byteBuf = ByteBuffer.allocate(48);
            while ((inputChannel.read(byteBuf)) != -1) {
                // System.out.println(bytesRead);
                byteBuf.flip();
                while (byteBuf.hasRemaining()) {
                    System.out.print((char)byteBuf.get());
                }
                //byteBuf.clear();
            }
            accessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
