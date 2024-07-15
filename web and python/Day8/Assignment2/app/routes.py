from flask import render_template
from flask_socketio import emit
from app import app, socketio, db
from app.models import TrafficAlert

@app.route('/')
def index():
    return render_template('index.html')

@socketio.on('connect')
def handle_connect():
    print('Client connected')

@socketio.on('disconnect')
def handle_disconnect():
    print('Client disconnected')

@socketio.on('send_traffic_alert')
def send_traffic_alert(data):
    location = data['location']
    message = data['message']

    new_alert = TrafficAlert(location=location, message=message)
    db.session.add(new_alert)
    db.session.commit()

    emit('new_traffic_alert', {'location': location, 'message': message}, broadcast=True)
