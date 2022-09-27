function guarda(elemento) {

    // Swal.fire({
    //     position: 'top-end',
    //     icon: 'success',
    //     title: 'Your work has been saved',
    //     showConfirmButton: false,
    //     timer: 2000
    // })

    Swal.fire({
        html: 'Registro guardado..✔',
        toast: true,
        icon: 'success',
        padding: '1rem',
        position: 'top-right',
        timer: '3000',
        timerProgressBar: true
    })
}

function actualiza(elemento) {
    Swal.fire({
        html: 'Registro actualizado..✔',
        toast: true,
        icon: 'success',
        padding: '1rem',
        position: 'top-right',
        timer: '3000',
        timerProgressBar: true
    })
}
//
// function eliminarMovimiento(elemento){
//     swal({
//         title: "Está seguro de eliminar el registro?",
//         text: "una vez borrado no podrá recuperarlo!",
//         icon: "warning",
//         buttons: true,
//         dangerMode: true,
//     })
//         .then((ok) => {
//             if (ok) {
//                 $.ajax({
//                     url:"/eliminar"+id,
//                     success: function (res){
//                         console.log(res)
//                     }
//                 })
//                 swal("El registro ha sido eliminado!", {
//                     icon: "success",
//                 }).then((ok)=>{
//                     if(ok){
//                         location.href="/movimientos";
//                     }
//                 });
//             } else {
//                 swal("todo bien!");
//             }
//         });
// }