package com.example.bj_isfp_backend.global.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.bj_isfp_backend.global.socket.anotation.SocketMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WebSocketAddMappingSupporter {

    private final ConfigurableListableBeanFactory beanFactory;
    private SocketIOServer socketIOServer;

    public void addListeners(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;

        final List<Class<?>> classes = beanFactory.getBeansWithAnnotation(SocketController.class).values()
                .stream().map(Object::getClass)
                .collect(Collectors.toList());

        for (Class<?> cls : classes) {
            List<Method> methods = findSocketMappingAnnotatedMethods(cls);
            addSocketServerEventListener(cls, methods);
        }
    }

    private void addSocketServerEventListener(Class<?> controller, List<Method> methods) {
        for (Method method : methods) {
            SocketMapping socketMapping = method.getAnnotation(SocketMapping.class);
            String endpoint = socketMapping.endpoint();
            Class<?> dtoClass = socketMapping.requestCls();

            socketIOServer.addEventListener(endpoint, dtoClass, ((client, data, ackSender) -> {
                String requestTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"))
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
                String log = String.format("%s :: [%s] ", requestTime, method.getName());
                System.out.println(log);

                List<Object> args = new ArrayList<>();
                for (Class<?> params : method.getParameterTypes()) {
                    if (params.equals(SocketIOServer.class))
                        args.add(socketIOServer);
                    else if (params.equals(SocketIOClient.class))
                        args.add(client);
                    else if (params.equals(dtoClass))
                        args.add(data);
                }
                method.invoke(beanFactory.getBean(controller), args.toArray());
            }));
        }
    }

    private List<Method> findSocketMappingAnnotatedMethods(Class<?> cls) {
        return Arrays.stream(cls.getMethods())
                .filter(method -> method.getAnnotation(SocketMapping.class) != null)
                .collect(Collectors.toList());
    }
}
