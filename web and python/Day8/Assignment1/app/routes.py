from flask import render_template, request
from flask_socketio import emit
from app import app, socketio, db
from app.models import Claim

@app.route('/')
def index():
    return render_template('index.html')

@socketio.on('connect')
def handle_connect():
    print('Client connected')

@socketio.on('disconnect')
def handle_disconnect():
    print('Client disconnected')

@socketio.on('update_claim_status')
def update_claim_status(data):
    claim_id = data['claim_id']
    new_status = data['status']

    claim = Claim.query.get(claim_id)
    if claim:
        claim.status = new_status
        db.session.commit()
        emit('claim_status_updated', {'claim_id': claim_id, 'status': new_status}, broadcast=True)
