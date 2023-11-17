//// number, string, boolean ////
var num = 3.14;
var str = "10";
var bool = true;
// -----------------------------
//// array, object, enum ////
var numArr = [1, 2, 10, 3.14];
var boolArr = [true, true, false];
var man = {
    name: "홍길동",
    age: 20,
    married: true
};
var GRADE;
(function (GRADE) {
    GRADE[GRADE["A"] = 0] = "A";
    GRADE[GRADE["B"] = 1] = "B";
    GRADE[GRADE["C"] = 2] = "C";
    GRADE[GRADE["D"] = 3] = "D";
    GRADE[GRADE["E"] = 4] = "E";
    GRADE[GRADE["F"] = 5] = "F";
})(GRADE || (GRADE = {}));
var myGrade = GRADE.A;
//-----------------------------
//// any, unknown ////
var anyValue = 1;
anyValue = "1";
anyValue = true;
var unknownValue = 1;
unknownValue = "1";
unknownValue = false;
anyValue.hell(); // 없는 함수도 통과됨..
//unknownValue.hell();
//---------------------------------
//// void, never ////
function helloVoid() {
    console.log("Hello");
    //return "hello";
}
function helloString() {
    console.log("Hello");
    return "hello";
}
function helloNever() {
    console.log("Hello");
    // while(true) {}
    throw 'Error';
}
//--------------------------------
//// null, undefined ////
///const nullValue: null = undefined;
var nullValue = null;
//const undefinedValue: undefined = null;
var undefinedValue = undefined;
