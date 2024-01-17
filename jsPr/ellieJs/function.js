//Function
// -프로그램에서 기본적인 구성
// - 여러번 사용이 가능함
// -값의 동작또는 계산을 수행함

//1.Function declaration
//function name(param1,param2) {body .. return}
//한가지의 함수는 한가지 일만
//함수는 자바스크립트에서 object다
function printHello() {
    console.log('Hello');
}

printHello();

function log(message) {
    console.log(message);
}

log('Hello@@')
log(1234)

//2.Parameters
// premitive parameters : 값을 호출
// object parameters : 참조를 호출
function chaneMame(obj) {
    obj.name = 'coder';
}

const injun = {name: 'injun'}

chaneMame(injun);
console.log(
   injun
)


//3.Default parameters ( ES6 추가)
function showMessage(message, from ='unknown') {
    console.log(`${message} by ${from}`);
}
showMessage('Hi!')

//4. RestParameters ( ES6추가)
function printAll(...args) {
    for (let i = 0; i < args.length; i++) {
        console.log(args[i]);
    }

    for (const arg of args) {
        console.log('of' + arg);
    }


}

printAll('dream', 'seohee', 'injun');

//스코프 안에서 정의된 변수는 밖에서 사용 x
//5.Local scope
let globalMessage = 'global'; //글로벌 변수

function printMessage() {
    let message = 'hello'; //지역변수
    console.log(message);
    console.log(globalMessage);

    function printAnother() {
        console.log(message)
        var childeMessage = 'hello';
    }
}

//함수 호이스팅
console.log(sum(4,4))
printMessage();
//6.Return a value
function sum(a, b) {
    return a + b;
}

const result = sum(1, 2); // 3
console.log(`sum: ${sum(1, 2)}`);

//7. Early return, early exit
//bad
function upgradeUser(user) {
    if (user.point > 10) {
        //logic..
    }
}

//good
function upgradeUser(user) {
    if (user.point <= 10) {
        return
    }
    //logic...
}



//First-class function
//함수가 다른 변수처럼 다뤄질 수 있다.
//함수가 값 또는 변수에 할당 될 수 ㅣㅇㅆ다.
//함수가 다른 함수의 인자로 들어갈 수 있다
//함수가 다른 함수를 반환 할 수 있다.

//FuctionExpression
//함수선언은 선언보다 일찍 호출이 가능하다(hoisted)
//함수표현식은 함수에 도달했을때 만들어진다.

const print = function() {
    //익명함수
    console.log('print');
};

print(); // 함수처럼 쓸수 있음
const printAgain = print;
printAgain();
const sumAgain = sum;
console.log(sumAgain(1, 3));

//함수표현식을 사용한 Callback 함수
function randomQuiz(answer, printYes, printNo) {
    if (answer === 'love you') {
        printYes();
    }else{
        printNo();
    }
}

const printYes = function () {
    console.log('yes!');
};


//named function
//better de
const printNo = function print() {
    console.log('no!');
};

randomQuiz('wrong', printYes,printNo)
randomQuiz('love you', printYes,printNo)

//Arrow function
//always anonymous
const simplePrint = function () {
    console.log('simplePrint');
};

const simplePrints = () => console.log('simplePrint');
// const add = (a, b) => a + b;
const simpleMultiply = (a,b) =>{

    return a * b;
}

//IIFE : Immediately Invoked Function Expression
(function hell() {
    console.log('IIFE')
})();

function calculate(command, a, b) {
    return command(a, b);
}

const add = (a, b) => (a + b);
const substract = (a, b) => (a - b);
const divide = (a, b) => (a / b);
const multiply = (a, b) => (a * b);
const remainder = (a, b) => (a % b);

console.log(calculate(add,10,2));
calculate(substract,10,2);
calculate(divide,10,2);
calculate(multiply,10,2);
calculate(remainder,10,2);

