let map;

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: -34.397, lng: 150.644 },
        zoom: 8
    });
}

document.getElementById('plan-route').addEventListener('click', function() {
    const startLocation = document.getElementById('start-location').value;
    const endLocation = document.getElementById('end-location').value;

    if (startLocation && endLocation) {
        // Mock route data
        const routes = [
            { id: 1, description: 'Route 1: via Main St and 2nd Ave', transitData: 'Bus A: On time, Bus B: Delayed' },
            { id: 2, description: 'Route 2: via Oak St and 3rd Ave', transitData: 'Bus C: On time, Bus D: On time' },
            { id: 3, description: 'Route 3: via Pine St and 4th Ave', transitData: 'Bus E: Delayed, Bus F: On time' },
        ];

        const routesList = document.getElementById('routes-list');
        routesList.innerHTML = ''; // Clear previous routes

        routes.forEach(route => {
            const li = document.createElement('li');
            li.className = 'list-group-item';
            li.textContent = route.description;
            li.setAttribute('data-toggle', 'tooltip');
            li.setAttribute('title', route.transitData);
            li.addEventListener('click', () => showTransitData(route.transitData));
            routesList.appendChild(li);

            // Optionally add a marker to the map
            addMarkerToMap(startLocation, endLocation);
        });

        $('[data-toggle="tooltip"]').tooltip(); // Initialize tooltips
    } else {
        alert('Please enter both start and end locations.');
    }
});

function showTransitData(data) {
    document.getElementById('transit-data').textContent = data;
    $('#transitModal').modal('show');
}

function addMarkerToMap(start, end) {
    const geocoder = new google.maps.Geocoder();

    geocoder.geocode({ 'address': start }, function(results, status) {
        if (status === 'OK') {
            const startMarker = new google.maps.Marker({
                map: map,
                position: results[0].geometry.location,
                label: 'S'
            });
            map.setCenter(results[0].geometry.location);
        } else {
            alert('Geocode was not successful for the following reason: ' + status);
        }
    });

    geocoder.geocode({ 'address': end }, function(results, status) {
        if (status === 'OK') {
            const endMarker = new google.maps.Marker({
                map: map,
                position: results[0].geometry.location,
                label: 'E'
            });
        } else {
            alert('Geocode was not successful for the following reason: ' + status);
        }
    });
}
