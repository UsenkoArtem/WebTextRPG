function headAttack( enemy) {
    debugger;
    var table = document.getElementById("enemy");
    var trs = table.rows;
    var dataType =  table.rows[0];
    var nodeValue = dataType.cells[1].innerHTML;
    var data = {};
    data["health"] = nodeValue;
    alert(enemy +  " " + nodeValue);
    alert(JSON.stringify(data));
    $.ajax({
        url: 'ajax/battle/head/'+ enemy,
        contentType : "application/json",
        dataType : 'json',
        data : JSON.stringify(data),
        type: "Post",
        success: function(data){
            alert("Okay");
    }
    })
}