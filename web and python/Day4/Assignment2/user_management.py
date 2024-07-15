from flask import Blueprint, render_template, request, redirect, url_for, session
from werkzeug.security import generate_password_hash, check_password_hash
from .models import db, User

user_bp = Blueprint('user', __name__, url_prefix='/user')

@user_bp.route('/register', methods=['GET', 'POST'])
def register():
    if request.method == 'POST':
        username = request.form['username']
        password = request.form['password']
        
        hashed_password = generate_password_hash(password, method='sha256')
        
        new_user = User(username=username, password=hashed_password)
        db.session.add(new_user)
        db.session.commit()
        
        session['username'] = username  
        return redirect(url_for('user.profile'))
    
    return render_template('register.html')

@user_bp.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        username = request.form['username']
        password = request.form['password']
        
        user = User.query.filter_by(username=username).first()
        
        if user and check_password_hash(user.password, password):
            session['username'] = username  
            return redirect(url_for('get_traffic_data'))
        
    return render_template('login.html')

@user_bp.route('/logout')
def logout():
    session.pop('username', None)  
    return redirect(url_for('index'))

@user_bp.route('/profile')
def profile():
    username = session.get('username')
    if username:
        user = User.query.filter_by(username=username).first()
        return render_template('profile.html', user=user)
    else:
        return redirect(url_for('user.login'))
