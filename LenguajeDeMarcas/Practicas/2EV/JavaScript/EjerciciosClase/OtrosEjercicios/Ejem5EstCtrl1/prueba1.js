
console.log("Hola 1DAM!");
edad=16;
if (edad >18)  alert("mayor edad"); else alert("menor edad"); 
if (edad>=16 && edad <18)  alert("adolescente");
let x=2;
while (x!=0) 
   alert(x--);

mes=2;
switch (mes*1){
    case 1: alert("Enero"); break;
    case 2: alert("Febrero"); break;
    default: alert("Otro mes");
}
etiqueta:
for (let i=1;i<=3;i++) {
    alert("Número:"+i);
    if (i==2)
      break etiqueta;  //No utilizar break más que en switch.
}
