window.addEventListener('load',function(){
    const url = 'http://localhost:8080/odontologos';
    const btnPacientes = document.querySelector('.btnPacientes');
    const btnTurnos = document.querySelector('.btnTurnos');
    const btnCancelar= document.querySelector('.btnBack');
    //formulario y variables de registro
    const formOdontologo = document.forms[0];
    const nombre = document.querySelector('#inputNombre');
    const apellido = document.querySelector('#inputApellido');
    const noMatricula = document.querySelector('#inputMatricula');


    //alertas
    const mensaje = document.querySelector('#alertaExitosa')


  /* -------------------------------------------------------------------------- */
  /*                    FUNCIÓN - Registrar Paciente [POST]                    */
  /* -------------------------------------------------------------------------- */

    formOdontologo.addEventListener('submit',function(event){
        event.preventDefault();
        const payload={
            nombre: nombre.value,
            apellido: apellido.value,
            matricula: noMatricula.value,
        };

        const settings={
            method: 'POST',
            body: JSON.stringify(payload),
            headers:{
                'Content-type': 'application/json'
            }
        }
        console.log(payload);
        realizarRegistro(settings);
        
    })

    
    function realizarRegistro(settings){
        console.log("realizando Registro");
        fetch(`${url}`, settings)
            .then(response=>{
                console.log(response);

                if (response.ok != true) {
                    alert("Ocurrio un error al registrar el Odontologo.")
                }

                return response.json();


            }).then(data=>{
                console.log("Promesa cumplida:");
                console.log(data);
                mensaje.classList.remove('hide');
                mensaje.innerText += "Paciente registrado correctamente";
                setTimeout(() => {
                    location.replace('./listarOdontologos.html');
                }, 1500);
                
            })
            .catch(err=>{
                console.log("Promesa rechazada:");
                console.log(err);
                
            })
    }
    
 /* -------------------------------------------------------------------------- */
  /*                             Cancelar operacion                             */
  /* -------------------------------------------------------------------------- */
  btnCancelar.addEventListener('click',function(event){
    event.preventDefault();
    location.replace('./listarOdontologos.html');
  })



});