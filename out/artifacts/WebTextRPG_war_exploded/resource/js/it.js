
function uneqipe( id , name){
    $.ajax({
        url: "ajax/item/unequipe/"+id,
        type: "Get",
        success: function (data) {
            debugger;
            var tbl = document.getElementById("equipped");
            var trs = tbl.rows;
            var agility;
            var strength;
            var vitality;
            var intelligence;
            var price;
            var idd = trs.length;
            var ok;
            debugger;
            for (var i = 0; i < trs.length; i++) {
                if (tbl.rows[i].cells[0].innerHTML === name) {
                    name = tbl.rows[i].cells[1].innerHTML;
                    agility = tbl.rows[i].cells[2].innerHTML;
                    strength = tbl.rows[i].cells[3].innerHTML;
                    vitality = tbl.rows[i].cells[4].innerHTML;
                    intelligence = tbl.rows[i].cells[5].innerHTML;
                    price = tbl.rows[i].cells[6].innerHTML;
                    tbl.deleteRow(i);
                    ok = 1;
                    break;
                }
            }
            if (ok!=1) return;
            var newrow = tbl.insertRow(idd-1);
            var newcell = newrow.insertCell(0);
            newcell.innerText=(idd-1).toString();
            newcell.style.display='none';
            newcell = newrow.insertCell(1);
            newcell.style.height=10;
            newcell.style.width=50;
            newcell.style.mozBoxAlign= 'center';
            newcell.style.color= 'black';
            newcell.innerText=name;
            newcell = newrow.insertCell(2);
            newcell.style.height=10;
            newcell.style.width=50;
            newcell.style.mozBoxAlign= 'center';
            newcell.innerText=agility;
            newcell = newrow.insertCell(3);
            newcell.style.height=10;
            newcell.style.width=50;
            newcell.style.mozBoxAlign= 'center';
            newcell.innerText=strength;
            newcell = newrow.insertCell(4);
            newcell.style.height=10;
            newcell.style.width=50;
            newcell.style.mozBoxAlign= 'center';
            newcell.innerText=vitality;
            newcell = newrow.insertCell(5);
            newcell.style.height=10;
            newcell.style.width=50;
            newcell.style.mozBoxAlign= 'center';
            newcell.innerText=intelligence;
            newcell = newrow.insertCell(6);
            newcell.style.height=10;
            newcell.style.width=50;
            newcell.style.mozBoxAlign= 'center';
            newcell.innerText=price;
            newcell = newrow.insertCell(7);
            newcell.style.height=10;
            newcell.style.width=50;
            newcell.style.mozBoxAlign= 'center';
            --idd;
            newcell.innerHTML="<input type='button' value='Выкинуть' onClick=deletee("+id+","+idd+")>";
            debugger;
            var split = data.split(" ");
            document.getElementById("Agility").innerHTML = split[0];
            document.getElementById("Vitality").innerHTML = split[1];
            document.getElementById("Intelligence").innerHTML = split[2];
            document.getElementById("Strength").innerHTML = split[3];
            document.getElementById("Attack").innerHTML = split[4];
            document.getElementById("Defense").innerHTML = split[5];
            document.getElementById("Health").innerHTML = split[6];
            document.getElementById("Mana").innerHTML = split[7];
            document.getElementById("Point").innerHTML = split[8];
            document.getElementById("Level").innerHTML = split[9];
            document.getElementById("Exp").innerHTML = split[10];
        }});
}

///Добавить сюдя и создать контроллер 
function deleteEquipeItem( id , name){
    $.ajax({
        url: "ajax/item/deleteEquipeItem/"+id,
        type: "Get",
        success: function (data) {
            debugger;
            var tbl = document.getElementById("equipped");
            var trs = tbl.rows;
            var agility;
            var strength;
            var vitality;
            var intelligence;
            var price;
            var idd = trs.length;
            var ok;
            debugger;
            for (var i = 0; i < trs.length; i++) {
                if (tbl.rows[i].cells[0].innerHTML === name) {
                    name = tbl.rows[i].cells[1].innerHTML;
                    agility = tbl.rows[i].cells[2].innerHTML;
                    strength = tbl.rows[i].cells[3].innerHTML;
                    vitality = tbl.rows[i].cells[4].innerHTML;
                    intelligence = tbl.rows[i].cells[5].innerHTML;
                    price = tbl.rows[i].cells[6].innerHTML;
                    tbl.deleteRow(i);
                    ok = 1;
                    break;
                }
            }
            if (ok!=1) return;
            debugger;
            var split = data.split(" ");
            document.getElementById("Agility").innerHTML = split[0];
            document.getElementById("Vitality").innerHTML = split[1];
            document.getElementById("Intelligence").innerHTML = split[2];
            document.getElementById("Strength").innerHTML = split[3];
            document.getElementById("Attack").innerHTML = split[4];
            document.getElementById("Defense").innerHTML = split[5];
            document.getElementById("Health").innerHTML = split[6];
            document.getElementById("Mana").innerHTML = split[7];
            document.getElementById("Point").innerHTML = split[8];
            document.getElementById("Level").innerHTML = split[9];
            document.getElementById("Exp").innerHTML = split[10];
        }});
}
