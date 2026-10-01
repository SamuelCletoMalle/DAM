let fin=false;
let sum=0;
while (! fin) {
    let num=parseInt (prompt ("Dar número positivo (0 para finalizar):"));
    if (num == 0 ) fin=true;
    else if (num <0 ) alert ("número no válido");
    else  sum += num;
}

alert("Suma de números positivos:"+ sum);