from flask import Flask,render_template,request,jsonify

app=Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/api/routes')
def get_routes():
    start=request.args.get('start')
    destination=request.args.get('destination')

    route_options=[
        {'name': 'Route A'},
        {'name': 'Route B'},
        {'name': 'Route C'}
    ]
    return jsonify(route_options)

if __name__=='__main__':
    app.run(debug=True)