

from sqlalchemy import func
from dao import session
from models import Route, Schedule, Vehicle

def get_routes_with_most_schedules(limit=5):
    return session.query(Route, func.count(Schedule.id)).join(Schedule).group_by(Route.id).order_by(func.count(Schedule.id).desc()).limit(limit).all()

def get_vehicle_utilization(vehicle_id):
    total_schedules = session.query(func.count(Schedule.id)).filter_by(vehicle_id=vehicle_id).scalar()
    total_capacity = session.query(func.sum(Vehicle.capacity)).filter_by(id=vehicle_id).scalar()
    return (total_schedules, total_capacity)

def get_average_schedule_duration(route_id):
    avg_duration = session.query(func.avg(func.strftime('%s', Schedule.arrival_time) - func.strftime('%s', Schedule.departure_time))).filter_by(route_id=route_id).scalar()
    return avg_duration
