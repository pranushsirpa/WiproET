import datetime
from dao import create_route, create_vehicle, create_schedule, update_route, update_vehicle, delete_schedule, delete_route, delete_vehicle
from queries import get_routes_with_most_schedules, get_vehicle_utilization, get_average_schedule_duration

if __name__ == "__main__":
  
    route1 = create_route("Route A", "Description of Route A")
    vehicle1 = create_vehicle("Bus 1", "Bus", 50)
    schedule1 = create_schedule(route1.id, datetime.datetime(2024, 7, 15, 8, 0), datetime.datetime(2024, 7, 15, 10, 0), vehicle1.id)

  
    updated_route = update_route(route1.id, new_name="Updated Route A")
    updated_vehicle = update_vehicle(vehicle1.id, new_name="Updated Bus 1")

   
    routes_with_most_schedules = get_routes_with_most_schedules()
    print("Routes with most schedules:")
    for route, count in routes_with_most_schedules:
        print(f"{route.name}: {count} schedules")

    vehicle_utilization = get_vehicle_utilization(vehicle1.id)
    print(f"Total schedules for Vehicle {vehicle1.name}: {vehicle_utilization[0]}, Total capacity: {vehicle_utilization[1]}")

    avg_duration = get_average_schedule_duration(route1.id)
    print(f"Average duration for Route {route1.name}: {avg_duration} seconds")

  
    delete_schedule(schedule1.id)
    delete_route(route1.id)
    delete_vehicle(vehicle1.id)
