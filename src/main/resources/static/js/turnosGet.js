window.addEventListener('load',function(){
    
    const url = 'http://localhost:8080/turnos';
    const btnAgregar = document.querySelector('.btnRegistrar')
    const btnOdontologos = document.querySelector('.odontologos')
    const btnPacientes= document.querySelector('.btnPacientes')
    

    btnAgregar.addEventListener('click',function(event){
        event.preventDefault();
        location.replace('./registrarTurno.html');
    })

    btnOdontologos.addEventListener('click',function(event){
        event.preventDefault();
        location.replace('./listarOdontologos.html');
    })

    btnPacientes.addEventListener('click',function(event){
        event.preventDefault();
        location.replace('./listarPacientes.html');
    })


    /* -------------------------------------------------------------------------- */
    /*                 FUNCIÓN - Obtener listado de Turnos [GET]               */
    /* -------------------------------------------------------------------------- */

    obtenerTurnos();
    function obtenerTurnos(){
        
        const settings = {
            method: 'GET'
        }
        console.log("hello");
        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                renderizarTurnos(data);
                eliminarTurnos();
                for(turno of data){
                    console.log(turno)
                }
            })
    }
    /* -------------------------------------------------------------------------- */
    /*                  FUNCIÓN  - Renderizar Turnos en pantalla                 */
    /* -------------------------------------------------------------------------- */

    function renderizarTurnos(lista){
        const table = document.querySelector('.datos');
        lista.forEach(turno => {
            table.innerHTML +=`
            <tr>
                <th scope="row">${turno.id}</th>
                <td>${turno.date}</td>
                <td>${turno.odontologo.nombre} ${turno.odontologo.apellido}</td>
                <td>${turno.paciente.nombre} ${turno.paciente.apellido}</td>
                <td style="display: flex; justify-content: space-evenly">
                    <button id="${turno.id}" type="button" class="btnEliminar btn btn-danger"><i id="${turno.id}" class="fa-regular fa-trash-can"></i></button>
              </td>
            </tr>`
            
        });
    }

    /* -------------------------------------------------------------------------- */
    /*                  FUNCIÓN  - Eliminar Turno [DELETE]                     */
    /* -------------------------------------------------------------------------- */

    function eliminarTurnos(){
        const btnEliminar = document.querySelectorAll('.btnEliminar');
        const eliminado= document.querySelector('#dltExitoso')
        btnEliminar.forEach(boton => {
            boton.addEventListener('click', function (event) {
                const identificador = event.target.id;
                const ruta =`${url}/${identificador}`
                const settings={
                    method: 'DELETE',
                    header:{
                    }
                };
                console.log(identificador);
                console.log(ruta);
                fetch(ruta,settings)
                    .then(response =>{
                        eliminado.classList.remove('hide');
                        eliminado.innerText += "Turno eliminado correctamente";
                        setTimeout(() => {
                            eliminado.classList.add('hide');
                            location.reload();
                        }, 1500);
                        
                    })
                
            })
            
        });
    }

});