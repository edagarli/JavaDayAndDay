package me.edagarli.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * User: edagarli(卤肉)
 * Email: lizhi@edagarli.com
 * github: http://github.com/edagarli
 * Date: 16/11/11
 * Time: 22:07
 * Desc:
 */
public class ByteBufferTest {

    public static void main(String args[]) {

//        String content = "hello，world";
//        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
//        byteBuffer.put(content.getBytes());
//        byteBuffer.flip();
//        byte[] bufferValue = new byte[byteBuffer.remaining()];
//        System.out.println(byteBuffer.get(bufferValue));
//        System.out.println(new String(bufferValue));
        ByteBuf byteBuf = Unpooled.buffer(16);
        ByteBuf byteBuf2 = Unpooled.buffer(8);
        byteBuf.writeInt(1);
        byteBuf.writeInt(2);
        byteBuf.writeInt(3);
        System.out.println("读之后writerIndex:" + byteBuf.writerIndex());
        System.out.println("读之后readerIndex:" + byteBuf.readerIndex());
        System.out.println("读之后2的可读长度:" + byteBuf.readableBytes());
        System.out.println("读之后2的可写长度:" + byteBuf.writableBytes());

        System.out.println("读之后writerIndex:" + byteBuf2.writerIndex());
        System.out.println("读之后readerIndex:" + byteBuf2.readerIndex());
        System.out.println("读之后2的可读长度:" + byteBuf2.readableBytes());
        System.out.println("读之后2的可写长度:" + byteBuf2.writableBytes());

        System.out.println(byteBuf);
        System.out.println(byteBuf2);

//        byteBuf2.writeInt(1);
//        byteBuf2.writeBytes(byteBuf);
        byteBuf.readBytes(byteBuf2);

        System.out.println(byteBuf);
        System.out.println(byteBuf2);

        System.out.println("读之后writerIndex:" + byteBuf.writerIndex());
        System.out.println("读之后readerIndex:" + byteBuf.readerIndex());
        System.out.println("读之后2的可读长度:" + byteBuf.readableBytes());
        System.out.println("读之后2的可写长度:" + byteBuf.writableBytes());

        System.out.println("读之后writerIndex:" + byteBuf2.writerIndex());
        System.out.println("读之后readerIndex:" + byteBuf2.readerIndex());
        System.out.println("读之后2的可读长度:" + byteBuf2.readableBytes());
        System.out.println("读之后2的可写长度:" + byteBuf2.writableBytes());
    }

}
