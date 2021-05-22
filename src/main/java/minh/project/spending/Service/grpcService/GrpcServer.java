package minh.project.spending.Service.grpcService;

import lombok.extern.slf4j.Slf4j;
import minh.project.spending.grpc.Infos;
import minh.project.spending.grpc.EvaluateGrpc;
import org.lognet.springboot.grpc.GRpcService;

import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

@Slf4j
@GRpcService
public class GrpcServer extends EvaluateGrpc.EvaluateImplBase {

    @Override
    public void getYearSpending(minh.project.spending.grpc.Source request,
                                io.grpc.stub.StreamObserver<Infos> responseObserver) {

    }


}
