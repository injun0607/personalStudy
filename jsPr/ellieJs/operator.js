//1.String concatenation
console.log('my' + 'cat');
console.log('1' + 2);
console.log(`string literals: 1+2 = ${1 + 2}`);
console.log(`string literals:

'''''
`);

//Assignment operators
let x = 3;
let y = 6;

x += y;
x -= y;
x *= y;
x /= y;

//5.Comparison operators
console.log(10 < 6);
console.log(10 <= 6);
console.log(10 > 6);
console.log(10 >= 6);


//6.Logical operators : || (or) , && (and), !(not)
const value1 = false;
const value2 = 4 < 2;
//익스프레션이나 함수를 호출하는것이 제일 좋다(연산을 줄일 수 있음)
console.log(`or: ${value1 || value2 || check()}`)
console.log(`and: ${value1 && value2 && check()}`)

//nullableObject && nullableObject.something
// if (nullableObject != null) {
//     nullableObject.something
// }

function check(){
    for (let i = 0; i < 10; i++) {
        console.log("이야야")
    }

    return true;
}
//7.Equality
const stringFive = '5';
const numberFive = 5;
// == loose equality, with type conversion
console.log(stringFive == numberFive) //true
console.log(stringFive != numberFive) //false

// === strict equality, no type conversion
console.log(stringFive === numberFive) //false
console.log(stringFive !== numberFive) //true

//object equality by reference
const injun1 = {name: 'injun'}
const injun2 = {name: 'injun'}
const injun3 = injun1
console.log(injun1 == injun2)
console.log(injun1 === injun2)
console.log(injun1 === injun3)

console.log(0 == false) //true
console.log(0 === false) //false
console.log('' == false) //true
console.log('' === false) //false
console.log(null == undefined) //true
console.log(null === undefined) //false

//8. Conditional operators: if
//if, else if, else
const name = 'injun';

if (name === 'injun') {
    console.log('Welcome, injun')
}else if (name === 'seohee') {
    console.log('하이')
}else{
    console.log('호호')
}


//9.Ternary operator: ?
//condition ? value 1 : value2;
console.log(name === 'injun'?'yes' : 'no')

//10.Switch statement
const browser = 'IE';
switch (browser) {
    case 'IE':
        console.log('go away!')
        break;
    case 'Chrome':
    case 'Firefox':
        console.log('hi')
        break;
    default:
        console.log('snakk')
        break
}

//while, doWhile
let i = 0;
while (i < 3) {
    console.log(`${i}`);
    i++
}

do {
    console.log(`do ${i}`);
    i++
} while (i < 5)

//for
for (let i = 0; i < 3; i++) {
    console.log(`for ${i}`)
}
