window.addEventListener('load', function(){
    const btnPacientes = document.querySelector('.btnPacientes')
    const formPacientes = document.forms[0]


    btnPacientes.addEventListener('click', function(event){
        event.preventDefault();
        formPacientes.classList.remove('hide-form')
    })
})