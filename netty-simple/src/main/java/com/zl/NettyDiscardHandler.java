package com.zl;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import java.nio.ByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-05-09
 */
@Log4j2
public class NettyDiscardHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        while (byteBuf.isReadable()){
            log.info(String.format("收到消息-%s，不响应!",(char)byteBuf.readByte()));
        }
        super.channelRead(ctx, msg);
    }
}
