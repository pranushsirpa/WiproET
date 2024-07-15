from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from models import Base, Route, Schedule, Vehicle

engine = create_engine('sqlite:///transit_database.db')
Base.metadata.create_all(engine)
Session = sessionmaker(bind=engine)
session = Session()

def create_route(name, description=None):
    new_route = Route(name=name, description=description)
    session.add(new_route)
    session.commit()
    return new_route

def create_schedule(route_id, departure_time, arrival_time, vehicle_id):
    new_schedule = Schedule(route_id=route_id, departure_time=departure_time, arrival_time=arrival_time, vehicle_id=vehicle_id)
    session.add(new_schedule)
    session.commit()
    return new_schedule

def create_vehicle(name, type, capacity):
    new_vehicle = Vehicle(name=name, type=type, capacity=capacity)
    session.add(new_vehicle)
    session.commit()
    return new_vehicle

def get_route_by_id(route_id):
    return session.query(Route).filter_by(id=route_id).first()

def get_schedule_by_id(schedule_id):
    return session.query(Schedule).filter_by(id=schedule_id).first()

def get_vehicle_by_id(vehicle_id):
    return session.query(Vehicle).filter_by(id=vehicle_id).first()

def update_route(route_id, new_name=None, new_description=None):
    route = session.query(Route).filter_by(id=route_id).first()
    if new_name:
        route.name = new_name
    if new_description:
        route.description = new_description
    session.commit()

def update_schedule(schedule_id, new_departure_time=None, new_arrival_time=None, new_vehicle_id=None):
    schedule = session.query(Schedule).filter_by(id=schedule_id).first()
    if new_departure_time:
        schedule.departure_time = new_departure_time
    if new_arrival_time:
        schedule.arrival_time = new_arrival_time
    if new_vehicle_id:
        schedule.vehicle_id = new_vehicle_id
    session.commit()

def update_vehicle(vehicle_id, new_name=None, new_type=None, new_capacity=None):
    vehicle = session.query(Vehicle).filter_by(id=vehicle_id).first()
    if new_name:
        vehicle.name = new_name
    if new_type:
        vehicle.type = new_type
    if new_capacity:
        vehicle.capacity = new_capacity
    session.commit()

def delete_route(route_id):
    route = session.query(Route).filter_by(id=route_id).first()
    session.delete(route)
    session.commit()

def delete_schedule(schedule_id):
    schedule = session.query(Schedule).filter_by(id=schedule_id).first()
    session.delete(schedule)
    session.commit()

def delete_vehicle(vehicle_id):
    vehicle = session.query(Vehicle).filter_by(id=vehicle_id).first()
    session.delete(vehicle)
    session.commit()
