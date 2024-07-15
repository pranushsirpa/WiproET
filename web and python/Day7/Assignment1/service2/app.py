from flask import Flask, jsonify, request
import os
import consul

app = Flask(__name__)
consul_client = consul.Consul()

def get_config(key):
    _, config = consul_client.kv.get(key)
    if config:
        return config['Value'].decode('utf-8')
    return None

@app.route('/health')
def health_check():
    return jsonify({'status': 'up', 'service': 'Service 2'})

@app.route('/process_claim', methods=['POST'])
def process_claim():
    data = request.get_json()
    policy_id = data.get('policy_id')
    claim_number = data.get('claim_number')
    claim_date = data.get('claim_date')
    amount = data.get('amount')
    return jsonify({'status': 'success', 'message': 'Claim processed successfully'})

if __name__ == '__main__':
    app.run(port=int(os.getenv('FLASK_RUN_PORT', 5002)))
