window.addEventListener('load',function(){


    const url = 'http://localhost:8080/odontologos';
    const btnAgregar = document.querySelector('.btnRegistrar')
    const btnPacientes = document.querySelector('.btnPacientes')
    
    btnPacientes.addEventListener('click', function(event){
        event.preventDefault();
        location.replace('./listarPacientes.html');
    })


    btnAgregar.addEventListener('click',function(event){
        event.preventDefault();
        location.replace('./registroOdontologos.html');
    })


    /* -------------------------------------------------------------------------- */
    /*                 FUNCIÓN - Obtener listado de Odontologos [GET]               */
    /* -------------------------------------------------------------------------- */

    obtenerOdontologos();
    function obtenerOdontologos(){
        
        const settings = {
            method: 'GET'
        }
        console.log("hello");
        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                renderizarOdontologos(data);
                eliminarOdontologo();
                for(odontologo of data){
                    console.log(odontologo)
                }
            })
    }
    /* -------------------------------------------------------------------------- */
    /*                  FUNCIÓN  - Renderizar Odontologos en pantalla                 */
    /* -------------------------------------------------------------------------- */

    function renderizarOdontologos(lista){
        const table = document.querySelector('.datos');
        lista.forEach(odontologo => {
            table.innerHTML +=`
            <tr>
                <th scope="row">${odontologo.id}</th>
                <td>${odontologo.nombre}</td>
                <td>${odontologo.apellido}</td>
                <td>${odontologo.matricula}</td>
                <td style="display: flex; justify-content: space-evenly">
                    <button type="button" class="btn btn-success"><i class="fa-solid fa-rotate-left"></i></button>
                    <button id="${odontologo.id}" type="button" class="btnEliminar btn btn-danger"><i id="${odontologo.id}" class="fa-regular fa-trash-can"></i></button>
              </td>
            </tr>`   
        });
    }

    /* -------------------------------------------------------------------------- */
    /*                  FUNCIÓN  - Eliminar paciente [DELETE]                     */
    /* -------------------------------------------------------------------------- */

    function eliminarOdontologo(){
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
                        eliminado.innerText += "Odontologo eliminado correctamente";
                        setTimeout(() => {
                            eliminado.classList.add('hide');
                            location.reload();
                        }, 1500);
                        
                    })
                
            })
            
        });
    }

});