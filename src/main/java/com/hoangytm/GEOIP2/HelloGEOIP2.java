package com.hoangytm.GEOIP2;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Postal;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.net.InetAddress;


@Service
public class HelloGEOIP2 {
    public MyLocation myLocation(String IP) throws IOException, GeoIp2Exception {
        MyLocation myLocation = new MyLocation();
        File dbFile = new File(MyConstants.DATABASE_CITY_PATH);
        DatabaseReader reader = new DatabaseReader.Builder(dbFile).build();
        // Create a IP instance
        InetAddress idAddress = InetAddress.getByName(IP);

        // Response
        CityResponse cityResponse = reader.city(idAddress);
        //Contry information
        Country country = cityResponse.getCountry();
        System.out.println(" name country: " + country.getName());
        // City information
        City city = cityResponse.getCity();
        System.out.println(" name country: " + city.getName());
        // Postal code
        Postal postal = cityResponse.getPostal();
        // Location
        Location location = cityResponse.getLocation();
        System.out.println(" name country: " + location.getAverageIncome());

        myLocation.setCity(city.getName());
        myLocation.setCountry(country.getName());
        return myLocation;


    }
}
