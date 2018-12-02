function myMap() {
var myCenter = new google.maps.LatLng(58.3782565,26.71511220000002);
var mapCanvas = document.getElementById("map");
var mapOptions = {center: myCenter, zoom: 5};
var map = new google.maps.Map(mapCanvas, mapOptions);
var marker = new google.maps.Marker({position:myCenter});
var infowindow = new google.maps.InfoWindow({content:"Latitude: 58.4, longitude: 26.7"});
marker.setMap(map);

google.maps.event.addListener(marker,'click',function() {
      map.setZoom(17);
      map.setCenter(marker.getPosition());
      infowindow.open(map,marker);
      });
}