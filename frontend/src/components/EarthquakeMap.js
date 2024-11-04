import React, { useEffect, useRef } from 'react';

const EarthquakeMap = ({ earthquakes }) => {
  const mapRef = useRef(null);
  const googleMap = useRef(null);

  useEffect(() => {
    const mapOptions = {
      center: { lat: 0, lng: 0 },
      zoom: 2,
    };
    googleMap.current = new window.google.maps.Map(mapRef.current, mapOptions);
  }, []);

  useEffect(() => {
    if (googleMap.current) {
      earthquakes.forEach((earthquake) => {
        const marker = new window.google.maps.Marker({
          position: { lat: earthquake.latitude, lng: earthquake.longitude },
          map: googleMap.current,
          title: `Magnitude ${earthquake.magnitude} - ${earthquake.place}`,
        });

        const infoWindow = new window.google.maps.InfoWindow({
          content: `
            <h3>Magnitude ${earthquake.magnitude}</h3>
            <p>${earthquake.place}</p>
            <p>Time: ${new Date(earthquake.time).toLocaleString()}</p>
            <p>Depth: ${earthquake.depth} km</p>
          `,
        });

        marker.addListener('click', () => {
          infoWindow.open(googleMap.current, marker