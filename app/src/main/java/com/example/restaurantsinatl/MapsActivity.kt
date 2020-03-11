package com.example.restaurantsinatl

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val geocoder = Geocoder(this)

        val zaxbyLatLng = LatLng(33.897, -84.480)
        val pandaLatLng = LatLng(33.900, -84.478)
        val steakShakeLatLng = LatLng(33.887, -84.473)
        val redLobLatLng = LatLng(33.89, -84.474)
        val juicyCrabLatLng = LatLng(33.890, -84.477)
        val atlanta = LatLng(33.897, -84.476)

        val zaxbyLocation = geocoder.getFromLocation(zaxbyLatLng.latitude, zaxbyLatLng.longitude,1)
        val pandaLocation = geocoder.getFromLocation(pandaLatLng.latitude, pandaLatLng.longitude,1)
        val steakShakeLocation = geocoder.getFromLocation(steakShakeLatLng.latitude, steakShakeLatLng.longitude,1)
        val redLobLocation = geocoder.getFromLocation(redLobLatLng.latitude, redLobLatLng.longitude,1)
        val juicyCrabLocation = geocoder.getFromLocation(juicyCrabLatLng.latitude, juicyCrabLatLng.longitude,1)


        mMap.addMarker(MarkerOptions().position(zaxbyLatLng).title(zaxbyLocation[0].getAddressLine(0)).icon(BitmapDescriptorFactory.fromResource(R.drawable.zaxby_icon)))
        mMap.addMarker(MarkerOptions().position(pandaLatLng).title(pandaLocation[0].getAddressLine(0)).icon(BitmapDescriptorFactory.fromResource(R.drawable.panda_express_icon)))
        mMap.addMarker(MarkerOptions().position(steakShakeLatLng).title(steakShakeLocation[0].getAddressLine(0)).icon(BitmapDescriptorFactory.fromResource(R.drawable.steak_and_shake_icon)))
        mMap.addMarker(MarkerOptions().position(redLobLatLng).title(redLobLocation[0].getAddressLine(0)).icon(BitmapDescriptorFactory.fromResource(R.drawable.red_lobster_icon)))
        mMap.addMarker(MarkerOptions().position(juicyCrabLatLng).title(juicyCrabLocation[0].getAddressLine(0)).icon(BitmapDescriptorFactory.fromResource(R.drawable.juicy_crab_icon)))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(atlanta))
        mMap.moveCamera(CameraUpdateFactory.zoomTo(15.0f))
    }


}
