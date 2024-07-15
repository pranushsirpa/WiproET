from flask import Flask, jsonify, request
import os
import consul
import requests

app = Flask(__name__)
consul_client = consul.Consul()

claims_db = []
service2_url = "http://localhost:5002"
def get_config(key):
    _, config = consul_client.kv.get(key)
    if config:
        return config['Value'].decode('utf-8')
    return None

@app.route('/health')
def health_check():
    return jsonify({'status': 'up', 'service': 'Service 1'})

@app.route('/create_claim', methods=['POST'])
def create_claim():
    data = request.get_json()
    policy_id = data.get('policy_id')
    claim_number = data.get('claim_number')
    claim_date = data.get('claim_date')
    amount = data.get('amount')

    new_claim = {
        'policy_id': policy_id,
        'claim_number': claim_number,
        'claim_date': claim_date,
        'amount': amount
    }
    claims_db.append(new_claim)
    try:
        response = requests.post(f"{service2_url}/process_claim", json=new_claim)
        response_data = response.json()
        if response.status_code == 200 and response_data.get('status') == 'success':
            return jsonify({'status': 'success', 'message': 'Claim processed successfully'})
        else:
            return jsonify({'status': 'error', 'message': 'Failed to process claim in Service 2'})
    except requests.exceptions.RequestException as e:
        return jsonify({'status': 'error', 'message': str(e)})

if __name__ == '__main__':
    app.run(port=int(os.getenv('FLASK_RUN_PORT', 5001)))
