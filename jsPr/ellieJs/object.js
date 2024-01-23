//Objects
//자바스크립트의 데이터타입중 하나
//오브젝트는 키와 밸류의 집합체

//1. 표기법과 속성
const obj1 = {}; // 'object literal' syntax
const obj2 = new Object(); // 'object constructor' syntax

const name = 'injun';
const age = 4;

function print(person) {
    console.log(person.name);
    console.log(person.age);
}

const injun = {
    name: 'injun',
    age: 4,
}

print(injun);

injun.hasJob = true;
console.log(injun.hasJob);

//can delete properties later
delete injun.hasJob
console.log(injun.hasJob);
console.log('---------2번시작------------');

//2.Computed properties
console.log(injun.name);
console.log(injun['name']); //computed properties 키는 항상 string 타입으로
injun['hasJob'] = true;
console.log(injun.hasJob);

function printValue(obj, key) {
    console.log(obj[key])
}

printValue(injun, 'name');
printValue(injun, 'age');

console.log('---------3번시작------------');
//3.Property value shorthand
const person1 = {name: 'bob', age: 2}
const person2 = {name: 'steve', age: 3}
const person3 = {name: 'dave', age: 4}
const person4 = makePerson('injun', 27);
console.log(person4)
function makePerson(name, age) {
    return {
        //name : name,
        //age : age
        //이것이 생략이 가능하다.
        name,
        age
    }
}
console.log('---------4번시작------------');
//4. Constructor function

const con_person = new Person('con_injun', 27);
function Person(name, age) {
    this.name = name;
    this.age = age;
}

console.log(con_person);

console.log('---------5번시작------------');
//5. in operator: property existence check
console.log('name' in injun);
console.log('age' in injun);
console.log('height' in injun);
console.log(injun.haha);

console.log('---------6번시작------------');
//6. for..in vs for..of
//for(key in obj)
for (key in injun) {
    console.log(key)
}

//for (value of iterable)
const array = [1, 2, 4, 5];
for (value of array) {
    console.log(value)
}

console.log('---------7번시작------------');
//7. Fun cloning
//Object.assign(dest, [obj1, obj2, obj3 ..])
const user = { name : 'seohee', age: '27'}
const user2 = user
console.log(user2)
user.age = 20;
console.log(user2)
user2.name = 'coder'
console.log(user.name)

//old way
const user3 = {
}
for (key in user) {
    user3[key] = user[key];
}
console.log(user3)
const user4 = Object.assign({},user)
console.log(user4);

const fruit1 = {color : 'red'}
const fruit2 = {color : 'pink',size : 'big'}
const mixed = Object.assign({}, fruit1, fruit2); //동일한 프로퍼티가 있다면 계속 덮어씀
console.log(mixed.color)
console.log(mixed.size)


