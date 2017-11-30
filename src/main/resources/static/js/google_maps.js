'use strict';

var mapOptions = {
    // Set the zoom level
    zoom: 19,

    // This sets the center of the map at our location
    center: {
        lat:  29.426791,
        lng: -98.489602
    },

    // Show this map in satellite view
    mapTypeId: google.maps.MapTypeId.SATELLITE
}

// Render the map
var map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);