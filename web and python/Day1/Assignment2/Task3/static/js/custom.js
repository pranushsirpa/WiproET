document.addEventListener('DOMContentLoaded',function(){
    const routeForm=document.getElementById('routeForm');
    const routeOptionsContainer=document.getElementById('routeOptions');

    routeForm.addEventListener('submit',function(event){
        event.preventDefault();
        const start=document.getElementById('start').value;
        const destination=document.getElementById('destination').value;

        fetch(`/api/routes?start=${start}&destination=${destination}`)
            .then(response => response.json())
            .then(data =>{
                routeOptionsContainer.innerHTML= '';

                data.forEach(route => {
                    const routeElement=document.createElement('div');
                    routeElement.classList.add('route-item');
                    routeElement.innerHTML=`<p><strong>Route:</strong> ${route.name}</p>`;
                    routeOptionsContainer.appendChild(routeElement);
                });
            })
            .catch(error =>{
                console.error('Error fetching route options:',error);
            });
    }) ; 
});