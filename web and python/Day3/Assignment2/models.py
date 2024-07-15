class TrafficData:
    def __init__(self, route, current_traffic, alternative_routes):
        self.route = route
        self.current_traffic = current_traffic
        self.alternative_routes = alternative_routes

class UserPreferences:
    def __init__(self, query):
        self.query = query
