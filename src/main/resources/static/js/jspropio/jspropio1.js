/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


function AbrirVentana(URL, title, w, h) {
    var left = (screen.width - w) / 2;
    var top = (screen.height - h) / 4;
    var ventana = window.open(URL, title, "width=" + w + ",height=" + h + ",left=" + left + ",top=" + top + ",scrollbars=NO,resizable=NO,menubar=NO");
    ventana.focus();
}
function ActualizarVentana() {
    location.reload();
}

function EnviarVentana() {
    this.click();
    CerrarVentana();
}

function CerrarVentana() {
    this.close();
}


$('btn_descargar').on('click',requestCompletar);

function requestCompletar()
{
    
}
