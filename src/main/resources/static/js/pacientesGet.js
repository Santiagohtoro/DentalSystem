window.addEventListener('load',function(){

    const url = 'http://localhost:8080/pacientes';
    const btnAgregar = document.querySelector('.btnRegistrar')
    const btnOdontologos = document.querySelector('.odontologos')
    const btnTurnos= document.querySelector('.btnTurnos')
    

    btnAgregar.addEventListener('click',function(event){
        event.preventDefault();
        location.replace('./registroPacientes.html');
    })

    btnOdontologos.addEventListener('click',function(event){
        event.preventDefault();
        location.replace('./listarOdontologos.html');
    })

    btnTurnos.addEventListener('click',function(event){
        event.preventDefault();
        location.replace('./listarTurnos.html');
    })
    /* -------------------------------------------------------------------------- */
    /*                 FUNCIÓN - Obtener listado de Pacientes [GET]               */
    /* -------------------------------------------------------------------------- */

    obtenerPacientes();
    function obtenerPacientes(){
        
        const settings = {
            method: 'GET'
        }
        console.log("hello");
        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                renderizarPacientes(data);
                eliminarPaciente();
                for(paciente of data){
                    console.log(paciente)
                }
            })
    }
    /* -------------------------------------------------------------------------- */
    /*                  FUNCIÓN  - Renderizar pacientes en pantalla                 */
    /* -------------------------------------------------------------------------- */

    function renderizarPacientes(lista){
        const table = document.querySelector('.datos');
        lista.forEach(paciente => {
            table.innerHTML +=`
            <tr>
                <th scope="row">${paciente.id}</th>
                <td>${paciente.nombre}</td>
                <td>${paciente.apellido}</td>
                <td>${paciente.dni}</td>
                <td>${paciente.fechaIngreso}</td>
                <td style="display: flex; justify-content: space-evenly">
                    <button id="${paciente.id}" type="button" class="btnEliminar btn btn-danger"><i id="${paciente.id}" class="fa-regular fa-trash-can"></i></button>
              </td>
            </tr>`
            
        });
    }

    /* -------------------------------------------------------------------------- */
    /*                  FUNCIÓN  - Eliminar paciente [DELETE]                     */
    /* -------------------------------------------------------------------------- */

    function eliminarPaciente(){
        const btnEliminar = document.querySelectorAll('.btnEliminar');
        const eliminado= document.querySelector('#dltExitoso')
        btnEliminar.forEach(boton => {
            boton.addEventListener('click', function (event) {
                const identificador = event.target.id;
                const ruta =`${url}/${identificador}`
                const settings={
                    method: 'DELETE',
                    header:{
                        //"Authorization": token,
                    }
                };
                console.log(identificador);
                console.log(ruta);
                fetch(ruta,settings)
                    .then(response =>{
                        eliminado.classList.remove('hide');
                        eliminado.innerText += "Paciente eliminado correctamente";
                        setTimeout(() => {
                            eliminado.classList.add('hide');
                            location.reload();
                        }, 1500);
                        
                    })
                
            })
            
        });
    }

});