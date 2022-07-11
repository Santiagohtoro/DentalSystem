window.addEventListener('load', function(){
    const btnPacientes = document.querySelector('.btnPacientes')
    const btnOdontologos = document.querySelector('.btnOdontologos')
    const btnTurnos = document.querySelector('.btnTurnos');


    btnPacientes.addEventListener('click', function(event){
        event.preventDefault();
        location.replace('./listarPacientes.html');
    })

    btnOdontologos.addEventListener('click', function(event){
        event.preventDefault();
        location.replace('./listarOdontologos.html');
    })
})