package info.visitkievukraine.visitukraine;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import org.androidannotations.annotations.EFragment;

import java.util.List;

@EFragment
public class MapFragment extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;
    private final static String LINE = "{~DqzEaM_M~IyA??bC~O";


    //  final static String LINE2 = "cp|rHivhyDq@oB`C}IdBmFvDuD|ByFlA_FhA_ETZcA`FlBpA~C~BrCjBnAdAhBfDhBbDZv@JbAIt@u@v@k@fAQxB@|A\dA^n@l@`@z@RnA`@t@dAVnBxA[\?HzA[TY`D]lDc@vDc@xJwA|MG~@jAjGzBv@XtAUhEiHmCiCpV_ASjBoVuK_D_FqAoGoBYxFqB{@RaFcL}D}D{@eCgAmCsD_AHoBeIkCiK";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate and return the layout
        View v = inflater.inflate(R.layout.map_fragment, container,
                false);
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();
        // latitude and longitude
        double latitude = 50.274284;
        double longitude = 314448;

        // create marker
        MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title(getString(R.string.glavotdel));


        // Changing marker icon
        marker.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

        // adding marker
        googleMap.addMarker(marker);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(50.4495972, 30.5237343)).zoom(11).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        googleMap.getUiSettings().setZoomControlsEnabled(true);

     //   googleMap.addMarker(new MarkerOptions().position(new LatLng(50.271044, 30.305148)).title("123"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.4508204, 30.521478)).title("Maidan Nezalezhnosti"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.4511742, 30.5260292)).title("House with Chimaeras"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.475676, 30.473566)).title("Zoo"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.4484022, 30.5099183)).title("Mother Motherland"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.4416561, 30.4815839)).title("People's Friendship Arch"));


        startDemo();


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }


     void startDemo() {
        List<LatLng> decodedPath = PolyUtil.decode(LINE);

        googleMap.addPolyline(new PolylineOptions().addAll(decodedPath));

         //    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-33.8256, 151.2395), 12));
    }

    public void showPlase(Double latit, Double longit) {

        //    CameraPosition cameraPosition = new CameraPosition.Builder()
        //          .target(new LatLng(latit, longit)).zoom(18).build();
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latit, longit), 15));
    }


    public void
    configureMap(GoogleMap map, double lat, double lon) {

//        MapsInitializer.initialize(getActivity());
//        map.setMyLocationEnabled(true);
        LatLng latLng = new LatLng(lat, lon);
        CameraUpdate camera = CameraUpdateFactory.newLatLng(latLng);
        map.animateCamera(camera);

        MarkerOptions marker6 = new MarkerOptions().position(new LatLng(lat, lon)).title("Отделение №26").snippet("Киев, Бессарабская площадь, дом. 9/1");
        googleMap.addMarker(marker6);
    }

}