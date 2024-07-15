document.getElementById('plan-route').addEventListener('click', function() {
    const startLocation = document.getElementById('start-location').value;
    const endLocation = document.getElementById('end-location').value;

    if (startLocation && endLocation) {
        // Mock route data
        const routes = [
            { id: 1, description: 'Route 1: via Main St and 2nd Ave' },
            { id: 2, description: 'Route 2: via Oak St and 3rd Ave' },
            { id: 3, description: 'Route 3: via Pine St and 4th Ave' },
        ];

        const routesList = document.getElementById('routes-list');
        routesList.innerHTML = ''; // Clear previous routes

        routes.forEach(route => {
            const li = document.createElement('li');
            li.textContent = route.description;
            routesList.appendChild(li);
        });
    } else {
        alert('Please enter both start and end locations.');
    }
});
