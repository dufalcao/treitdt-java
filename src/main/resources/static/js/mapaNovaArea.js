
//
//
// MAPA PARA A PÁGINA DE INCLUSÃO DE ÁREA 
//
//


function loadMap(map) {
    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1IjoicmFmYWVsc291emF2YWxsZSIsImEiOiJja3FpZ2l4eWEwMWhuMm9wOGxieGtwbjgyIn0.1tenv0r5uYrfAnqDbATuYg', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox/streets-v11',
        tileSize: 512,
        zoomOffset: -1,
   		accessToken: 'your.mapbox.access.token'
    }).addTo(map);
} 
 
//Adicione a latitude e longitude padrão que será carregada junto com o mapa
var latitude = -25.41374118344173;
var longitude = -49.26831722259522;
//Nível de zoom do mapa
var zoom = 15;

var mymap = L.map('mapsection').setView([latitude, longitude], zoom);

loadMap(mymap);

var layer = L.marker([latitude, longitude]).addTo(mymap);

function onMapClick(e) {
    layer.remove();

    latitude = e.latlng.lat;
    longitude = e.latlng.lng
    loadMap(mymap);

	layer = L.marker([latitude, longitude]).addTo(mymap);

    let lat = document.getElementById('lat');
    let lng = document.getElementById('lng');
    let btn = document.getElementById('btnAdd');

	lat.value = e.latlng.lat;
    lng.value = e.latlng.lng;
    btn.disabled = false;
    
    
    // carregar popup para preencher o formulário
}
mymap.on('click', onMapClick);





