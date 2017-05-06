function win(location) {
    debugger;
alert("You win");
    window.location.href = "http://webtextrpg.herokuapp.com/"+location;
}
function lose(location) {
    debugger;
    alert("You lose");
        window.location.href = "http://webtextrpg.herokuapp.com/"+location;

}
function headAttack( enemy) {
    var enemyTable = document.getElementById("enemy");
    var playerTable  = document.getElementById("player");
    var enemyData =  enemyTable.rows[0];
    var playerData =  playerTable.rows[0];
    var enemyHealth = enemyData.cells[1].innerHTML;
    var playerHealth = playerData.cells[1].innerHTML;
    var data = {};
    data["enemyHealth"] = enemyHealth;
    data["playerHealth"] = playerHealth;
    $.ajax({
        url: 'ajax/battle/head/'+ enemy,
        contentType : "application/json",
        dataType : 'json',
        data : JSON.stringify(data),
        type: "Post",
        success: function(data){
            debugger;
            if (data["enemyHealth"]<=0) {
                return win(data["location"]);
            }
            if (data["playerHealth"]<=0) {
                return lose(data["location"]);
            }
            enemyData.cells[1].innerText = data["enemyHealth"];
            playerData.cells[1].innerText = data["playerHealth"];

    }
    })
}

function bodyAttack(enemy) {
    var enemyTable = document.getElementById("enemy");
    var playerTable  = document.getElementById("player");
    var enemyData =  enemyTable.rows[0];
    var playerData =  playerTable.rows[0];
    var enemyHealth = enemyData.cells[1].innerHTML;
    var playerHealth = playerData.cells[1].innerHTML;
    var data = {};
    data["enemyHealth"] = enemyHealth;
    data["playerHealth"] = playerHealth;
    $.ajax({
        url: 'ajax/battle/body/'+ enemy,
        contentType : "application/json",
        dataType : 'json',
        data : JSON.stringify(data),
        type: "Post",
        success: function(data){
            debugger;
            if (data["enemyHealth"]<=0) {
                return win(data["location"]);
            }
            if (data["playerHealth"]<=0) {
                return lose(data["location"]);
            }
            enemyData.cells[1].innerText = data["enemyHealth"];
            playerData.cells[1].innerText = data["playerHealth"];

        }
    })
}

    function legsAttack(enemy) {
        var enemyTable = document.getElementById("enemy");
        var playerTable  = document.getElementById("player");
        var enemyData =  enemyTable.rows[0];
        var playerData =  playerTable.rows[0];
        var enemyHealth = enemyData.cells[1].innerHTML;
        var playerHealth = playerData.cells[1].innerHTML;
        var data = {};
        data["enemyHealth"] = enemyHealth;
        data["playerHealth"] = playerHealth;
        $.ajax({
            url: 'ajax/battle/legs/'+ enemy,
            contentType : "application/json",
            dataType : 'json',
            data : JSON.stringify(data),
            type: "Post",
            success: function(data){
                debugger;
                if (data["enemyHealth"]<=0) {
                    return win(data["location"]);
                }
                if (data["playerHealth"]<=0) {
                    return lose(data["location"]);
                }
                enemyData.cells[1].innerText = data["enemyHealth"];
                playerData.cells[1].innerText = data["playerHealth"];

            }
        })
}