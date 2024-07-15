# service1/app.py

from flask import Flask, jsonify
import os
import consul
import requests

app = Flask(__name__)
consul_client = consul.Consul()

@app.route('/collect_data')
def collect_data():
    # Simulated data collection (replace with actual implementation)
    data = {'traffic_volume': 1000, 'speed_avg': 60}
    
    # Example of service discovery with Consul to forward data to Service 2
    service_name = 'service2'
    _, service_data = consul_client.catalog.service(service_name)
    if service_data:
        service_address = service_data[0]['ServiceAddress']
        service_port = service_data[0]['ServicePort']
        url = f"http://{service_address}:{service_port}/process_data"
        response = requests.post(url, json=data)
        return response.json()
    else:
        return jsonify({'status': 'error', 'message': 'Service not found'})

if __name__ == '__main__':
    app.run(port=int(os.getenv('FLASK_RUN_PORT', 5001)))
