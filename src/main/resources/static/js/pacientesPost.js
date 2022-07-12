window.addEventListener('load',function(){
    
    const url = 'http://localhost:8080/pacientes';
    const btnOdontologos = document.querySelector('.btnOdontologos')
    const btnTurnos = document.querySelector('.btnTurnos');
    const btnCancelar= document.querySelector('.btnBack');
    //formulario y variables de registro
    const formPaciente = document.forms[0];
    console.log(formPaciente);
    const nombre = document.querySelector('#inputNombre');
    const apellido = document.querySelector('#inputApellido');
    const dni = document.querySelector('#inputDni');
    const fechaIngreso = document.querySelector('#inputFecha');
    const correo = document.querySelector('#inputCorreo');
    const calle = document.querySelector('#inputCalle');
    const numero = document.querySelector('#inputNumero');
    const localidad = document.querySelector('#inputLocalidad');
    const provincia = document.querySelector('#inputProvincia');

    //alertas
    const mensaje = document.querySelector('#alertaExitosa')


  /* -------------------------------------------------------------------------- */
  /*                    FUNCIÓN - Registrar Paciente [POST]                    */
  /* -------------------------------------------------------------------------- */

    formPaciente.addEventListener('submit',function(event){
        event.preventDefault();
        const payload={
            nombre: nombre.value,
            apellido: apellido.value,
            dni: dni.value,
            fechaIngreso: fechaIngreso.value,
            email: correo.value,
            domicilio:{
                calle: calle.value,
                numero: numero.value,
                localidad: localidad.value,
                provincia: provincia.value
            }
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
                    alert("Ocurrio un error al registrar el paciente.")
                }

                return response.json();
                //location.replace('/listarPacientes.html');


            }).then(data=>{
                console.log("Promesa cumplida:");
                console.log(data);
                mensaje.classList.remove('hide');
                mensaje.innerText += "Paciente registrado correctamente";
                setTimeout(() => {
                    location.replace('./listarPacientes.html');
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
    location.replace('./listarPacientes.html');
  })



});