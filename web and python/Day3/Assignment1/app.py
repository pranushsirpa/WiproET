from flask import Flask, render_template, request, redirect, url_for

app = Flask(__name__)

class Claim:
    claims = []

    def __init__(self, policy_number, claimant_name, date_of_loss, description):
        self.policy_number = policy_number
        self.claimant_name = claimant_name
        self.date_of_loss = date_of_loss
        self.description = description

    @classmethod
    def create_claim(cls, policy_number, claimant_name, date_of_loss, description):
        new_claim = cls(policy_number, claimant_name, date_of_loss, description)
        cls.claims.append(new_claim)
        return new_claim

    @classmethod
    def get_claim_by_policy_number(cls, policy_number):
        return next((claim for claim in cls.claims if claim.policy_number == policy_number), None)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/submit_claim', methods=['GET', 'POST'])
def submit_claim():
    if request.method == 'POST':
        policy_number = request.form['policy_number']
        claimant_name = request.form['claimant_name']
        date_of_loss = request.form['date_of_loss']
        description = request.form['description']

        Claim.create_claim(policy_number, claimant_name, date_of_loss, description)

        return redirect(url_for('confirmation', policy_number=policy_number))
    return render_template('submit_claim.html')

@app.route('/confirmation/<policy_number>')
def confirmation(policy_number):
    claim = Claim.get_claim_by_policy_number(policy_number)
    return render_template('confirmation.html', claim=claim)

if __name__ == '__main__':
    app.run(debug=True)
