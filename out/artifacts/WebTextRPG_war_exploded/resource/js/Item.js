function deletee( id ,  name){

    $.ajax({
        url: "ajax/item/delete/"+id,
        type: "Get",
        success: function (data) {
            debugger;
             var tbl = document.getElementById("equipped");
            var trs = tbl.rows;
            for(var i=0; i<trs.length; i++){

                if(tbl.rows[i].cells[0].innerHTML == name){
                    tbl.deleteRow(i);
                    break;
                }
        }
    }});
}