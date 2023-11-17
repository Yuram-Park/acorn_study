//// number, string, boolean ////
const num: number = 3.14;
const str: string = "10";
const bool: boolean = true;

// -----------------------------

//// array, object, enum ////
const numArr:number[] = [1, 2, 10, 3.14];
const boolArr:boolean[] = [true, true, false];

const man: {name:string, age:number, married:boolean} = {
    name : "홍길동",
    age : 20,
    married : true
}

enum GRADE {A, B, C, D, E, F}
const myGrade:GRADE = GRADE.A;


//-----------------------------


//// any, unknown ////
let anyValue: any = 1;
anyValue = "1";
anyValue = true;

let unknownValue: unknown = 1;
unknownValue = "1";
unknownValue = false;



anyValue.hell(); // 없는 함수도 통과됨..
//unknownValue.hell();

//---------------------------------

//// void, never ////
function helloVoid(): void {
    console.log("Hello");
    //return "hello";
}

function helloString(): string {
    console.log("Hello")
    return "hello";
}

function helloNever(): never {
    console.log("Hello")
    // while(true) {}
    throw 'Error';
}

//--------------------------------

//// null, undefined ////

///const nullValue: null = undefined;
const nullValue: null = null;

//const undefinedValue: undefined = null;
const undefinedValue: undefined = undefined;