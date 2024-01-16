'use strict';

//2.variable,rw(read/write)

let name = 'injun';
console.log(name);
name = 'seohee';
console.log(name);

var nam;

console.log(nam);

nam = 'namnam'


let hee;
hee = '냐냐'
console.log(hee)

//Constant,read

const co = 19;
const size = 20.1;

console.log(`value: ${co}, type: ${typeof co}`)
console.log(`value: ${size}, type: ${typeof size}`)
//Note!
//Immutable data types: premitive types, frozen object
//im


const inf = 1 / 0;
const ne_inf = -1 / 0;
const nan = 'not a number' / 2;

console.log(inf)
console.log(ne_inf)
console.log(nan)

const bigIng = 1234567890123123123213123123131n
console.log(`value : ${bigIng}, type: ${typeof bigIng}`)

//String
const char = 'c';
const brendan = 'brendan';
const greeting = 'hello ' + brendan

console.log(`value:${greeting}, type: ${typeof greeting}`)
const helloBob = `hi ${brendan}`;
console.log(`value: ${helloBob}, type: ${typeof helloBob}`)


//boolean
//false: 0, null, undefined,NaN, '' <-- 모두 false
//true: any other value
const canRead = true;
const test = 3 < 1;
console.log(`value : ${canRead}, type: ${typeof canRead}`)
console.log(`value: ${test}, type: ${typeof test}`);

//null
//아예 없다고 선언한것
let nothing = null;
console.log(`value: ${nothing}, type: ${typeof nothing}`);

//undefined
//값이 아직 할당 되지 않은것
let und;
console.log(`value: ${und}, type: ${typeof und}`);

//심볼은 고유한 식별값이 필요할때 사용한다. 정말 고유한 식별값
const symbol1 = Symbol('id');
const symbol2 = Symbol('id');
console.log(symbol1 === symbol2); //false
//key에 해당하는 심볼값을 만들때는 for를 사용한다
const gsymbol1 = Symbol.for('id');
const gsymbol2 = Symbol.for('id');
console.log(gsymbol1 === gsymbol2); //true
//.description으로 string으로 변경해줘야한다.
console.log(`value: ${gsymbol1.description}, type: ${typeof gsymbol1}`);
//object, real-life object
const injun ={
    name:injun,
    age:20
}

//5.Dynamic typing
let text = 'hello';
console.log(`value: ${text},type: ${typeof text}`); //String
text = 1;
console.log(`value: ${text},type: ${typeof text}`); //1 / number
text = '7' + 5;
console.log(`value: ${text},type: ${typeof text}`); //75 / String
text = '8' / '2';
console.log(`value: ${text},type: ${typeof text}`); // 4 / number




