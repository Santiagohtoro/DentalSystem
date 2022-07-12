window.addEventListener('load',function(){


    const urlPacientes = 'http://localhost:8080/pacientes';
    const urlOdontologos = 'http://localhost:8080/odontologos';
    const url = 'http://localhost:8080/turnos';
    const btnCancelar= document.querySelector('.btnBack');
    //formulario y variables de registro
    const formTurnos= document.forms[0];
    console.log(formTurnos);
    const idOdonotologo = document.querySelector('#inputIdOdontologo');
    const idPaciente = document.querySelector('#inputIdPaciente');
    const fechaIngreso = document.querySelector('#inputFecha');

    //alertas
    const mensaje = document.querySelector('#alertaExitosa')


    /* -------------------------------------------------------------------------- */
    /*                 FUNCIÓN - Obtener listado de Pacientes [GET]               */
    /* -------------------------------------------------------------------------- */

    obtenerPacientes();
    function obtenerPacientes(){
        
        const settings = {
            method: 'GET'
        }
        console.log("hello");
        fetch(urlPacientes, settings)
            .then(response => response.json())
            .then(data => {
                pacienteSelector(data)
            })
    }

    /* -------------------------------------------------------------------------- */
    /*                 FUNCIÓN - Obtener Renderizar el seclect [GET]               */
    /* -------------------------------------------------------------------------- */

    function pacienteSelector(pacientes){
        const select = document.querySelector('.pacienteSel');
        pacientes.forEach(paciente=> {
            select.innerHTML +=`
            <option value="${paciente.id}">${paciente.nombre} ${paciente.apellido}</option>
            `
        });
    }


     /* -------------------------------------------------------------------------- */
    /*                 FUNCIÓN - Obtener listado de Odontologos [GET]               */
    /* -------------------------------------------------------------------------- */

    obtenerOdontologos();
    function obtenerOdontologos(){
        
        const settings = {
            method: 'GET'
        }
        console.log("hello");
        fetch(urlOdontologos, settings)
            .then(response => response.json())
            .then(data => {
                odontologoSelector(data)
            
            })
    }
    

    /* -------------------------------------------------------------------------- */
    /*                 FUNCIÓN - Obtener Renderizar el seclect [GET]               */
    /* -------------------------------------------------------------------------- */

    function odontologoSelector(odontologos){
        const select = document.querySelector('.odontologoSel');
        odontologos.forEach(odontologo => {
            select.innerHTML +=`
            <option value="${odontologo.id}">${odontologo.nombre} ${odontologo.apellido}</option>
            `
        });
    }




  /* -------------------------------------------------------------------------- */
  /*                    FUNCIÓN - Registrar Turnos [POST]                    */
  /* -------------------------------------------------------------------------- */

    formTurnos.addEventListener('submit',function(event){
        event.preventDefault();
        const payload={
            date: fechaIngreso.value,
            paciente : {id: idPaciente.value},
            odontologo: { id: idOdonotologo.value}
        };

        const settings={
            method: 'POST',
            body: JSON.stringify(payload),
            headers:{
                'Content-type': 'application/json'
            }
        }
        realizarRegistroTurno(settings);
        
    })

    
    function realizarRegistroTurno(settings){
        console.log("realizando Registro");
        fetch(`${url}`, settings)
            .then(response=>{
                console.log(response);

                if (response.ok != true) {
                    alert("Ocurrio un error al registrar el Turno.")
                }

                return response.json();
    


            }).then(data=>{
                console.log("Promesa cumplida:");
                console.log(data);
                mensaje.classList.remove('hide');
                mensaje.innerText += "Turno registrado correctamente";
                setTimeout(() => {
                    location.replace('./listarTurnos.html');
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
    location.replace('./listarTurnos.html');
  })



});