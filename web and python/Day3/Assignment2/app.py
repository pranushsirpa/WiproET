from flask import Flask, render_template, request
from models import TrafficData, UserPreferences

app = Flask(__name__)

traffic_data = TrafficData('Highway A', 'Moderate', ['Highway B', 'Highway C'])

user_preferences = UserPreferences('Traffic conditions')

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/traffic')
def get_traffic_data():
    return render_template('traffic.html', traffic=traffic_data)

@app.route('/query', methods=['GET', 'POST'])
def handle_user_query():
    if request.method == 'POST':
        user_query = request.form['query']
        user_preferences.query = user_query
    return render_template('query.html', preferences=user_preferences)

if __name__ == '__main__':
    app.run(debug=True)
