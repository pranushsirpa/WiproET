# app/models.py

from app import db

class TrafficAlert(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    location = db.Column(db.String(100), nullable=False)
    message = db.Column(db.Text, nullable=False)

    def __repr__(self):
        return f'<TrafficAlert {self.id}: {self.message}>'
