//Json
//JavaScript Object Notaion

//1. Object to Json
//stringfu(obj)
let json = JSON.stringify(true);
console.log(json)


json = JSON.stringify(['apple', 'banana']);
console.log(json);

const rabbit = {
    name: 'seohee',
    color: 'white',
    size: null,
    birthDate: new Date(),
    jump: () => {
        console.log(`${name} can jump!`);
    },

};

json = JSON.stringify(rabbit, ["name","color","size"]);
console.log(json);

json = JSON.stringify(rabbit, (key,value) => {
    console.log(`key: ${key}, value: ${value}`);
    return key === 'name' ? 'injun' : value;
});
console.log(json);

console.log("----------------2번 시작---------------")
//2. JSON to Object
//parse(json)
json = JSON.stringify(rabbit);
console.log(json)
const obj = JSON.parse(json, (key,value) => {
    console.log(`key: ${key}, value: ${value}`);
    return key === 'birthDate' ? new Date(value) : value;
});
console.log(obj);
rabbit.jump();
//obj.jump()

console.log(rabbit.birthDate.getDate())
console.log(obj.birthDate)
