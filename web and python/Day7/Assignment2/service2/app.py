# service2/app.py

from flask import Flask, jsonify, request, current_app
import os

app = Flask(__name__)

# Example configuration for peak hours (default: off-peak)
app.config['PEAK_HOURS'] = False

@app.route('/process_data', methods=['POST'])
def process_data():
    data = request.get_json()
    traffic_volume = data['traffic_volume']
    speed_avg = data['speed_avg']
    
    if current_app.config['PEAK_HOURS']:
        # Logic for processing data during peak hours
        traffic_status = 'high'
    else:
        # Logic for processing data during off-peak hours
        traffic_status = 'normal'

    return jsonify({'status': 'success', 'traffic_status': traffic_status})

if __name__ == '__main__':
    app.run(port=int(os.getenv('FLASK_RUN_PORT', 5002)))
