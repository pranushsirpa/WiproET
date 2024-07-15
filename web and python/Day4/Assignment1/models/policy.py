from . import db

class Policy(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    policy_holder = db.Column(db.String(100), nullable=False)
    premium = db.Column(db.Float, nullable=False)

    def serialize(self):
        return {
            'id': self.id,
            'policy_holder': self.policy_holder,
            'premium': self.premium
        }
