package com.example.bj_isfp_backend.global.socket.exception;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ExceptionListener;
import com.example.bj_isfp_backend.global.error.ErrorCode;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

public class SocketExceptionListener implements ExceptionListener {

    @Override
    public void onEventException(Exception e, List<Object> args, SocketIOClient client) {

    }

    @Override
    public void onDisconnectException(Exception e, SocketIOClient client) {

    }

    @Override
    public void onConnectException(Exception e, SocketIOClient client) {

    }

    @Override
    public void onPingException(Exception e, SocketIOClient client) {

    }

    @Override
    public boolean exceptionCaught(ChannelHandlerContext ctx, Throwable e) throws Exception {
        return false;
    }

    private void runExceptionHandling(Exception e, SocketIOClient client) {

        final ErrorCode errorCode;

    }
}
