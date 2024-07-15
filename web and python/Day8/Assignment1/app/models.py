from app import db

class Claim(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    claim_number = db.Column(db.String(50), unique=True, nullable=False)
    status = db.Column(db.String(50), nullable=False)

    def __repr__(self):
        return f'<Claim {self.claim_number}>'
