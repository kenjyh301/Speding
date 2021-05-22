package minh.project.spending.Config;

import io.grpc.Channel;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import minh.project.spending.grpc.EvaluateGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class GrpcConfig {

    @Bean
    public ManagedChannel showChannel(@Qualifier("grpcClientSleuthInterceptor") List<ClientInterceptor> clientInterceptors) {
        return ManagedChannelBuilder.forAddress("192.168.1.175",5353)
                .usePlaintext()
                .intercept(clientInterceptors)
                .build();
    }

//    @Bean
//    EvaluateGrpc.EvaluateBlockingStub evaluateStub(){
//        return EvaluateGrpc.newBlockingStub(showChannel);
//    }
}
