document.addEventListener('DOMContentLoaded',function(){
    const form=document.getElementById('contactForm');
    const email=document.getElementById('email');
    const password=document.getElementById('password');

    form.addEventListener('submit',function (event){
        event.preventDefault();

        if(!validateEmail(email.value)){
            email.classList.add('is-invalid');
        }else{
            email.classList.remove('is-invalid');
            email.classList.add('is-valid');
        }

        if(!validatePassword(password.value)){
            password.classList.add('is-invalid');
        }else{
            password.classList.remove('is-invalid');
            password.classList.add('is-valid');
        }

        if(form.checkValidity()){
            form.onsubmit();
        }
    });

    email.addEventListener('input',function (){
            
        if(validateEmail(email.value)){
            email.classList.remove('is-invalid');
            email.classList.add('is-valid');
        }else{
            email.classList.remove('is-valid');
            email.classList.add('is-invalid');
        }
    });
    password.addEventListener('input',function(){
        if(validatePassword(password.value)){
            password.classList.remove('is-invalid');
            password.classList.add('is-valid');
        }else{
            password.classList.remove('is-valid');
            password.classList.add('is-invalid');
        }
    });
    function validateEmail(email){
        const re=/^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(String(email).toLowerCase());
    } 
    function validatePassword(password){
        return password.length>=8;
    }
});