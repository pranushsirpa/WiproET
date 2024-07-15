from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from models import Base, Policy, Claim

engine = create_engine('sqlite:///claims_policies.db')
Base.metadata.create_all(engine)
Session = sessionmaker(bind=engine)
session = Session()

def create_policy(policy_number, holder_name, premium_amount):
    new_policy = Policy(policy_number=policy_number, holder_name=holder_name, premium_amount=premium_amount)
    session.add(new_policy)
    session.commit()
    return new_policy

def create_claim(policy_id, claim_number, claim_date, amount):
    new_claim = Claim(policy_id=policy_id, claim_number=claim_number, claim_date=claim_date, amount=amount)
    session.add(new_claim)
    session.commit()
    return new_claim

def get_policy_by_id(policy_id):
    return session.query(Policy).filter_by(id=policy_id).first()

def get_claim_by_id(claim_id):
    return session.query(Claim).filter_by(id=claim_id).first()

def update_policy(policy_id, new_policy_number=None, new_holder_name=None, new_premium_amount=None):
    policy = session.query(Policy).filter_by(id=policy_id).first()
    if new_policy_number:
        policy.policy_number = new_policy_number
    if new_holder_name:
        policy.holder_name = new_holder_name
    if new_premium_amount:
        policy.premium_amount = new_premium_amount
    session.commit()

def update_claim(claim_id, new_claim_number=None, new_claim_date=None, new_amount=None):
    claim = session.query(Claim).filter_by(id=claim_id).first()
    if new_claim_number:
        claim.claim_number = new_claim_number
    if new_claim_date:
        claim.claim_date = new_claim_date
    if new_amount:
        claim.amount = new_amount
    session.commit()

def delete_policy(policy_id):
    policy = session.query(Policy).filter_by(id=policy_id).first()
    session.delete(policy)
    session.commit()

def delete_claim(claim_id):
    claim = session.query(Claim).filter_by(id=claim_id).first()
    session.delete(claim)
    session.commit()
