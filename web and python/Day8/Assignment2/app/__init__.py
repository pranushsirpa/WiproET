# app/__init__.py

from flask import Flask
from flask_socketio import SocketIO
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config.from_object('config')
socketio = SocketIO(app)
db = SQLAlchemy(app)

from app import routes
