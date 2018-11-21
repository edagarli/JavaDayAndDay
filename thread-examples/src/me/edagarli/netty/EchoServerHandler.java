package me.edagarli.netty;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.ChannelHandler.Sharable;

@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ChannelPipeline cp = ctx.pipeline();
		cp.write(1);
		cp.write(2);
		cp.write(3);
		cp.write(4).addListener(new ChannelFutureListener() {

			public void operationComplete(ChannelFuture future)
					throws Exception {
				future.channel().pipeline().close();
			}
		});
	}

	/**
	 * byteBuf.hasArray 如果为true，此byteBuf为堆内存字节缓冲区，换句话说，在jvm的堆内存上
	 * 如果为false,此byteBuf为直接内存字节缓冲区，放在内存里。
	 * 区别：堆内存缓冲区对处理socket数据稍差，因为实际上socket会把数据从堆内存拷贝到机器的内存中再发送，处理遗留数据好用
	 * 直接内存缓冲区不需要复制，但是控制此byteBuf的生命周期不是很容易，也不容易处理遗留数据，需要把遗留数据拷贝到堆内存中
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		ByteBuf bb = (ByteBuf) msg;
		// System.out.println(bb.toString(CharsetUtil.UTF_8));
		// if (!bb.hasArray()) {
		// byte[] array = new byte[bb.readableBytes()];
		// System.out.println("getBytes前,可读长度:" + bb.readableBytes());
		// bb.getBytes(bb.readerIndex(), array);
		// System.out.println("getBytes后,可读长度:" + bb.readableBytes());
		// }
		// ByteBuf newB = Unpooled.EMPTY_BUFFER;
		// CompositeByteBuf compositeB = Unpooled.compositeBuffer();
		// compositeB.addComponents(newB, bb);
		//
		// // 从compositeByteBuf中读取数据跟从直接内存缓冲区中读取数据一致
		// byte[] tempBuffer = new byte[compositeB.readableBytes()];
		// compositeB.getBytes(compositeB.readerIndex(), tempBuffer);

		ByteBuf testRW1 = Unpooled.buffer(16, 16);
		ByteBuf testRW2 = Unpooled.buffer(16, 16);

		testRW1.writeInt(1);
		testRW1.writeInt(2);
		testRW1.writeInt(3);

		testRW2.writeInt(4);
		testRW2.writeInt(5);

		System.out.println("读之前可读长度:" + testRW1.readableBytes());
		System.out.println("读之前可写长度:" + testRW1.writableBytes());

		System.out.println("读之前writerIndex:" + testRW1.writerIndex());
		System.out.println("读之前readerIndex:" + testRW1.readerIndex());

		System.out.println("2的readIndex" + testRW2.readerIndex());
		System.out.println("2的writIndex" + testRW2.writerIndex());

		System.out.println("2的可读" + testRW2.readableBytes());
		System.out.println("2的可写" + testRW2.writableBytes());

		// while (testRW1.isReadable()) {
		testRW1.readBytes(testRW2);
		System.out.println(testRW1.readableBytes());
		// }

		System.out.println("读之后可读长度:" + testRW1.readableBytes());
		System.out.println("读之后可写长度:" + testRW1.writableBytes());

		System.out.println("读之后writerIndex:" + testRW1.writerIndex());
		System.out.println("读之后readerIndex:" + testRW1.readerIndex());

		System.out.println("读之后2的可读长度:" + testRW2.readableBytes());
		System.out.println("读之后2的可写长度:" + testRW2.writableBytes());

		System.out.println(testRW2.readerIndex());
		System.out.println(testRW2.writerIndex());

		ctx.write(bb);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(
				ChannelFutureListener.CLOSE);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		ctx.writeAndFlush("error server".getBytes());
		cause.printStackTrace();
		ctx.close();
	}

}
