<html>
<head>
    <script src='https://api.mapbox.com/mapbox-gl-js/v2.11.0/mapbox-gl.js'></script>
    <link href='https://api.mapbox.com/mapbox-gl-js/v2.11.0/mapbox-gl.css' rel='stylesheet' />
</head>
<body>
<div id='map' style='width: 100%; height: 80%;'></div>
<script>
mapboxgl.accessToken = "pk.eyJ1IjoienpvdWJpIiwiYSI6ImNsY2doNDl6MDA5cDEzdWxjc3Uybzc0MzUifQ.qi8AgUC3iJKhapYXarVG2A";
const map = new mapboxgl.Map({
container: 'map',
style: 'mapbox://styles/mapbox/streets-v12',
center: [${latitude}, ${longitude}],
zoom: ${zoomLevel},
});
</script>

<form method="post">
  <label for="location">Search:</label><br>
  <input type="text" id="location" name="location"><br>
  <input type="submit" value="GO!">
</form>

<p>"${latitude}"</p>
<p>"${longitude}"</p>

</body>
</html>