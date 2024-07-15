from flask import Flask, render_template, request, redirect, url_for
from flask_wtf import FlaskForm
from wtforms import StringField, TextAreaField, SubmitField
from wtforms.validators import DataRequired

app = Flask(__name__)
app.config['SECRET_KEY'] = 'your_secret_key_here' 
routes_data = {
    'Route 1': ['08:00 AM', '10:00 AM', '12:00 PM'],
    'Route 2': ['09:00 AM', '11:00 AM', '01:00 PM'],
    'Route 3': ['08:30 AM', '10:30 AM', '12:30 PM']
}

@app.route('/admin')
def admin_dashboard():
    return render_template('admin_dashboard.html', routes=routes_data)


@app.route('/manage_routes', methods=['GET', 'POST'])
def manage_routes():
    if request.method == 'POST':
        route_name = request.form['route_name']
      
        routes_data[route_name] = []
        return redirect(url_for('admin_dashboard'))
    
    return render_template('manage_routes.html')

@app.route('/manage_schedules/<route_name>', methods=['GET', 'POST'])
def manage_schedules(route_name):
    if request.method == 'POST':
        schedule_time = request.form['schedule_time']
       
        routes_data[route_name].append(schedule_time)
        return redirect(url_for('manage_schedules', route_name=route_name))
    
    return render_template('manage_schedules.html', route_name=route_name, schedules=routes_data.get(route_name, []))


@app.route('/report_incident', methods=['GET', 'POST'])
def report_incident():
    form = IncidentForm()
    
    if form.validate_on_submit():
        incident_type = form.incident_type.data
        details = form.details.data
        
        return redirect(url_for('admin_dashboard'))
    
    return render_template('report_incident.html', form=form)


class IncidentForm(FlaskForm):
    incident_type = StringField('Incident Type', validators=[DataRequired()])
    details = TextAreaField('Details', validators=[DataRequired()])
    submit = SubmitField('Submit')

@app.route('/feedback', methods=['GET', 'POST'])
def feedback():
    form = FeedbackForm()
    
    if form.validate_on_submit():
        feedback_type = form.feedback_type.data
        comment = form.comment.data
       
        
        return redirect(url_for('admin_dashboard'))
    
    return render_template('feedback.html', form=form)


class FeedbackForm(FlaskForm):
    feedback_type = StringField('Feedback Type', validators=[DataRequired()])
    comment = TextAreaField('Comment', validators=[DataRequired()])
    submit = SubmitField('Submit')

if __name__ == '__main__':
    app.run(debug=True)
