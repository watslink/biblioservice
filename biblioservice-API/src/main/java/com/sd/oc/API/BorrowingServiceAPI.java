package com.sd.oc.API;

import com.sd.oc.Service.ServiceInterface.BorrowingService;
import com.sd.oc.model.Borrowing;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "BorrowingAPI")
public class BorrowingServiceAPI {

    ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationAPI.class);

    BorrowingService borrowingService = context.getBean(BorrowingService.class);

//    @WebMethod(operationName ="findBorrowingById")
//    public Borrowing findBorrowingById(@WebParam(name="borrowing_id") int id){
//        return borrowingService.getBorrowing(id);
//    }

    @WebMethod(operationName ="findAllBorrowing")
    public List<Borrowing> findAllBorrowing(){
        return borrowingService.getAllBorrowing();
    }

}
