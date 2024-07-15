from flask import Flask,render_template,request

app=Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/routes',methods=['POST'])
def routes():
    start=request.form['start']
    destination=request.form['destination']
    return render_template('routes.html',start=start,destination=destination)

if __name__=='__main__':
    app.run(debug=True)