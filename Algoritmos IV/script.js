function arrGreaterY(x,Y){
    let count = 0
    for(let i=0; i<x.length; i++){
        if (x[i]>y)
        count++
    }
    return count
}
var y = 7;
console.log(arrGreaterY([1,5,8,10]));

function maxMinAvg(x){
    let max = x[0];
    let min = x[0];
    let sum = 0;
    for(let i = 0; i<x.length; i++){
        if(x[i]>max)
        max= x[i];
        if (x[i]<min)
        min =x[i];
        sum += x[i];
    }
    let avg = sum/x.length;
    return max, min, avg
}
console.log(maxMinAvg([1,2,3,4]));

function replace(x){

    for (let i = 0; i<x.length; i++){
        if(x[i]<0)
        x[i]="Dojo"
    }
    return x
}

console.log(replace([1,-10,2,-2]))

function removerRango(x,y,z){
    x.splice(y-1, z-1);
    return x
}
console.log(([10,20,30,40,50,60,70]));