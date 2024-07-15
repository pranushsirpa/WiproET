from flask import Flask, jsonify, request, render_template
from flask_sqlalchemy import SQLAlchemy
from validators import validate_policy_data
from models.policy import Policy,db

app = Flask(__name__)
app.config.from_object('config.DevelopmentConfig')  # Use DevelopmentConfig for development

db.init_app(app)

@app.before_request
def create_tables():
    db.create_all()

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/policies', methods=['GET'])
def get_policies():
    policies = Policy.query.all()
    return jsonify([policy.serialize() for policy in policies])

@app.route('/policies/<int:policy_id>', methods=['GET'])
def get_policy(policy_id):
    policy = Policy.query.get(policy_id)
    if policy:
        return jsonify(policy.serialize())
    else:
        return jsonify({'error': 'Policy not found'}), 404

@app.route('/policies', methods=['POST'])
def add_policy():
    data = request.json
    is_valid, message = validate_policy_data(data)
    if not is_valid:
        return jsonify({'error': message}), 400
    
    new_policy = Policy(policy_holder=data['policy_holder'], premium=data['premium'])
    db.session.add(new_policy)
    db.session.commit()
    return jsonify({'message': 'Policy added successfully', 'policy_id': new_policy.id}), 201

@app.route('/policies/<int:policy_id>', methods=['PUT'])
def update_policy(policy_id):
    data = request.json
    is_valid, message = validate_policy_data(data)
    if not is_valid:
        return jsonify({'error': message}), 400
    
    policy = Policy.query.get(policy_id)
    if policy:
        policy.policy_holder = data['policy_holder']
        policy.premium = data['premium']
        db.session.commit()
        return jsonify({'message': 'Policy updated successfully'})
    else:
        return jsonify({'error': 'Policy not found'}), 404

@app.route('/policies/<int:policy_id>', methods=['DELETE'])
def delete_policy(policy_id):
    policy = Policy.query.get(policy_id)
    if policy:
        db.session.delete(policy)
        db.session.commit()
        return jsonify({'message': 'Policy deleted successfully'})
    else:
        return jsonify({'error': 'Policy not found'}), 404

if __name__ == '__main__':
    app.run(debug=True)
