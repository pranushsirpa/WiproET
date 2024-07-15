# queries.py

from sqlalchemy import func
from dao import session
from models import Policy, Claim

def get_total_premium_amount():
    total_premium = session.query(func.sum(Policy.premium_amount)).scalar()
    return total_premium

def get_average_claim_amount():
    avg_claim_amount = session.query(func.avg(Claim.amount)).scalar()
    return avg_claim_amount

def get_policy_with_most_claims(limit=5):
    return session.query(Policy, func.count(Claim.id)).join(Claim).group_by(Policy.id).order_by(func.count(Claim.id).desc()).limit(limit).all()
