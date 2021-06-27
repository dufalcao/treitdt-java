// Cria um mapa com informações contidas em um arquivo GeoJson

// Função antiga copiada do Django
function onEachFeature(feature, layer) {
    var popupContent = feature.properties.popupContent;
    layer.bindPopup(popupContent);
}

//function onEachFeature(feature, layer) {
//    // does this feature have a property named popupContent?
//    if (feature.properties && feature.properties.popupContent) {
//        layer.bindPopup(feature.properties.popupContent);
//    }
//}
//
//L.geoJSON(geojsonFeature, {
//    onEachFeature: onEachFeature
//}).addTo(map);



var myIcon = L.icon({
    iconUrl: 'img/wifi-user.png',
    iconSize: [20, 20],
    iconAnchor: [10, 10]
});

function myPoint(){
    if ("geolocation" in navigator) {
        /* geolocation is available */
        navigator.geolocation.getCurrentPosition(function(position){
            console.log(position);
            var posicaoUsuario = L.marker([position.coords.latitude, position.coords.longitude], {icon: myIcon})
                .bindPopup('<span>Estou aqui!</span>')
                .openPopup()
                .addTo(map);
        }, function(error){
            console.log(error)
        });
        
    } else {
        console.log("Não tem geolocation");
        // alert("Não foi possível identificar sua localização através do seu navegador");
    } 
}

var gstreets = L.tileLayer('http://www.google.cn/maps/vt?lyrs=m@189&gl=cn&x={x}&y={y}&z={z}', {
    maxZoom: 20,
    attribution: 'google'
});

var satellite = L.tileLayer('http://www.google.cn/maps/vt?lyrs=s@189&gl=cn&x={x}&y={y}&z={z}', {
    maxZoom: 20,
    attribution: 'google'
});

var areas  = L.geoJson([], {
   onEachFeature: onEachFeature,
});

var areasUrl = $("#area_geojson").val();
//var areasUrl = $("#featureCollection_geojson").val();

$.getJSON(areasUrl, function(data){
    areas.addData(data);
})

var mbAttr = 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, ' +
'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
mbUrl = 'https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw';

var grayscale   = L.tileLayer(mbUrl, {id: 'mapbox/light-v9', tileSize: 512, zoomOffset: -1, attribution: mbAttr}),
streets  = L.tileLayer(mbUrl, {id: 'mapbox/streets-v11', tileSize: 512, zoomOffset: -1, attribution: mbAttr});


var map = L.map('map', {
center: [-25.436090, -54.595616],
zoom: 16,
layers: [satellite, areas]
//layers: [satellite]
});


var baseLayers = {
    "Google Satélite": satellite,
    "Google Streets": gstreets,
    
};
// "Grayscale": grayscale,
// "Streets": streets

var overlays = {
   "Areas": areas
};

// Watermark
//L.Control.Watermark = L.Control.extend({
//	onAdd:function(map){
//		var img = L.DomUtil.create('img');
//		img.src = '/img/Treitdt.gif';
//		img.style.width = '200px';
//		return img;
//	},
//	onRemove:function(map){},
//});
//
//L.control.watermark = function(opts){
//	return new L.Control.Watermark(opts);
//}
//L.control.watermark({position:'topleft'}).addTo(map);


L.control.layers(baseLayers, overlays).addTo(map);
//L.control.layers(baseLayers).addTo(map);
myPoint();



