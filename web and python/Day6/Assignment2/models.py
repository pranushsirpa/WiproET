

from sqlalchemy import Column, Integer, String, ForeignKey, DateTime
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import relationship

Base = declarative_base()

class Route(Base):
    __tablename__ = 'routes'

    id = Column(Integer, primary_key=True)
    name = Column(String(100), nullable=False)
    description = Column(String(255))

class Schedule(Base):
    __tablename__ = 'schedules'

    id = Column(Integer, primary_key=True)
    route_id = Column(Integer, ForeignKey('routes.id'))
    departure_time = Column(DateTime)
    arrival_time = Column(DateTime)
    vehicle_id = Column(Integer, ForeignKey('vehicles.id'))

    route = relationship("Route", backref="schedules")
    vehicle = relationship("Vehicle", backref="schedules")

class Vehicle(Base):
    __tablename__ = 'vehicles'

    id = Column(Integer, primary_key=True)
    name = Column(String(100), nullable=False)
    type = Column(String(50))
    capacity = Column(Integer)
