from flask import Flask, render_template, request, redirect, url_for

app = Flask(__name__)
app.config['SECRET_KEY'] = 'your_secret_key_here'
@app.route('/')
def index():
    return render_template('index.html')

@app.route('/claim_form', methods=['GET', 'POST'])
def claim_form():
    if request.method == 'POST':
        claim_number = request.form['claim_number']
        claim_details = request.form['claim_details']

        
        return redirect(url_for('claim_confirmation'))
    
    return render_template('claim_form.html')


@app.route('/claim_confirmation')
def claim_confirmation():
 
    claim_number = 'CLM001'
    claim_details = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'
    
    return render_template('claim_confirmation.html', claim_number=claim_number, claim_details=claim_details)

if __name__ == '__main__':
    app.run(debug=True)
