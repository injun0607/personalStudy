'use strict';

//Array

// 1. 배열의 선언
const arr1 = new Array();
const arr2 = [1, 2];

//2. Index position
const fruits = ['사과','바나나'];
console.log(fruits)
console.log(fruits.length);
console.log(fruits[0]);
console.log(fruits[1]);
console.log(fruits[2]);

console.log('-----------3번 시작------------')
//3. Looping over an array
//print all fruits
for (let fruit of fruits) {
    console.log(fruit);
}

//forEach
fruits.forEach((fruit)=> console.log(fruit))

console.log('-----------4번 시작------------')
//4. Addtion , deletion, copy
//push : add an item to the end
fruits.push('딸기','복숭아')
console.log(fruits);

//pop : remove an item from the end
fruits.pop();
fruits.pop();
console.log(fruits);

// unshift : add an item to the beginning
fruits.unshift('딸기','레몬')
console.log(fruits);

//shift : remove an item from the beginning
fruits.shift();
fruits.shift();
console.log(fruits);

//note!! shift, unshift are slower than pop, push
//splice : remove an item by index posotion
fruits.push('딸기', '복숭아', '레몬');
console.log(fruits);
fruits.splice(1,1)
console.log(fruits);
fruits.splice(1,1,'포도','수박')
console.log(fruits);

//combine two arrays
const fruits2 = ['배','코코넛']
const newFruits = fruits.concat(fruits2);
console.log(newFruits);

console.log('-----------5번 시작------------')
//5.searching
//find the index
//indexof
//includes
console.log(fruits)
console.log(fruits.indexOf('사과'));
console.log(fruits.indexOf('포도'));
console.log(fruits.indexOf('코코넛'));
console.log(fruits.includes('수박'));
console.log(fruits.includes('코코넛'));

//lastIndexOf
fruits.push('사과')
console.log(fruits);

console.log(fruits.indexOf('사과'));
console.log(fruits.lastIndexOf('사과'));