package com.hoangytm.GEOIP2;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class Controller {
    @Autowired
    private HelloGEOIP2 helloGEOIP2;

    @PostMapping("/display")
    public MyLocation getMyLocation(@RequestHeader String IP) throws IOException, GeoIp2Exception {
        System.out.println(IP);
        return helloGEOIP2.myLocation(IP);

    }

}
