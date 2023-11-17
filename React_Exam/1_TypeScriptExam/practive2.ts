//// function ////

// 1. Function Statement
function add(a:number, b:number): number {
    return a+b;
}

//add(1,"2") -> error
const result:number = add(1,2)


// 2. Function Expression
const addExp = (a:number, b:number):number => a + b;

const addExp2 : (a:number, b:number)=> number = (a, b) => a + b;

const addExp3 : (a:number, b:number) => number = function(a:number, b:number):number {return a + b};


// ------------------------------------

//// Union & Intersection

// union
function printValue(value:number | string | string[]): void{
    console.log(value)
}

printValue(1)
printValue("10")
printValue(["1", "10"])

// intersection
const inter : {name:string, age:number} & {height:number, weight:number} = {
    age: 20,
    height:170,
    weight: 70,
    name: "John"
}

// ---------------------------

//// Type Alias & Interface
type NUM = number

let num1:number = 1;
let num2:NUM = 2;
num1 = num2;

type unionType = number | string | string[]
function printValue2(value:unionType): void {
    console.log(value)
}

/*
type MANKIND = {
    name: string;
    age: number;
    height: number;
    weight: number
}
*/
type MANKIND = 
    {name: string,
    age: number} &
    {height: number,
    weight: number}

const mankind: MANKIND = {
    name: "john",
    age: 20,
    height:170,
    weight: 60  
}

// 2. Interface
interface IMANKIND {
    name: string;
    age: number;
    height: number;
    weight: number;
}

const mankind_data:IMANKIND = {
    name:"홍길동",
    weight: 80,
    height: 180,
    age: 30
}

