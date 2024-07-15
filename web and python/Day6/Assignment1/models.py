# models.py

from sqlalchemy import Column, Integer, String, ForeignKey, DateTime, Float
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import relationship

Base = declarative_base()

class Policy(Base):
    __tablename__ = 'policies'

    id = Column(Integer, primary_key=True)
    policy_number = Column(String(50), nullable=False, unique=True)
    holder_name = Column(String(100), nullable=False)
    premium_amount = Column(Float)
    claims = relationship("Claim", back_populates="policy")

class Claim(Base):
    __tablename__ = 'claims'

    id = Column(Integer, primary_key=True)
    policy_id = Column(Integer, ForeignKey('policies.id'))
    claim_number = Column(String(50), nullable=False, unique=True)
    claim_date = Column(DateTime)
    amount = Column(Float)
    policy = relationship("Policy", back_populates="claims")
