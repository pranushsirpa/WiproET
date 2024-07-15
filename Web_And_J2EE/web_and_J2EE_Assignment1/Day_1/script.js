

document.addEventListener('DOMContentLoaded', () => {
    const registrationForm = document.getElementById('registrationForm');
    const loginForm = document.getElementById('loginForm');

    if (registrationForm) {
        registrationForm.addEventListener('submit', (event) => {
            event.preventDefault();
            validateRegistrationForm();
        });
    }

    if (loginForm) {
        loginForm.addEventListener('submit', (event) => {
            event.preventDefault();
            validateLoginForm();
        });
    }
});

function validateRegistrationForm() {
    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    let errors = [];

    if (username.length < 3) {
        errors.push('Username must be at least 3 characters long.');
    }

    if (!validateEmail(email)) {
        errors.push('Invalid email address.');
    }

    if (password.length < 6) {
        errors.push('Password must be at least 6 characters long.');
    }

    if (password !== confirmPassword) {
        errors.push('Passwords do not match.');
    }

    if (errors.length > 0) {
        alert(errors.join('\n'));
    } else {
        alert('Registration successful!');
    
    }
}

function validateLoginForm() {
    const username = document.getElementById('loginUsername').value;
    const password = document.getElementById('loginPassword').value;

    let errors = [];

    if (username.length < 3) {
        errors.push('Username must be at least 3 characters long.');
    }

    if (password.length < 6) {
        errors.push('Password must be at least 6 characters long.');
    }

    if (errors.length > 0) {
        alert(errors.join('\n'));
    } else {
        alert('Login successful!');
    }
}

function validateEmail(email) {
    const re = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    return re.test(String(email).toLowerCase());
}
