package com.PwC.Mapapi;

import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/map")
public class SearchController {

    private String locationName;
    private MapboxGeocoding mapGeocoding;
    private double lat = 35.9061173;
    private double lng = 31.9554121;

    @GetMapping
    public String get(Model model) {
        System.out.println("ALREADY INSIDE");
        model.addAttribute("longitude", lng);
        model.addAttribute("latitude", lat);
        model.addAttribute("zoomLevel", 10);
        return "map";
    }


    @PostMapping
    public String saveLocation(@RequestParam String location, Model model) throws IOException {

        
        System.out.println(location);

        mapGeocoding = MapboxGeocoding.builder()
                .accessToken("pk.eyJ1IjoienpvdWJpIiwiYSI6ImNsY2doNDl6MDA5cDEzdWxjc3Uybzc0MzUifQ.qi8AgUC3iJKhapYXarVG2A")
                .query(location).build();

        GeocodingResponse response = mapGeocoding.executeCall().body();
        List<CarmenFeature> results = response.features();

        if (results.size() > 0) {
            System.out.println("Location found");
            System.out.println(results.get(0).center());
            lat = results.get(0).center().latitude();
            lng = results.get(0).center().longitude();
            model.addAttribute("longitude", lat);
            model.addAttribute("latitude", lng);
            model.addAttribute("zoomLevel", 10);
        }
        return "map";
    }
}