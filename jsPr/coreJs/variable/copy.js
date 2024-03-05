//객체에 대한 얇은 복사다.
/*
    얇은 복사란?
    객체의 바로 아랫단계만 복사하는 것. 객체안의 객체가 있는 중첩객체에 대해서는 복사를 하지않는다.
 */
function copyObjectShallow(obj) {

    let result = {};
    for (let prop in obj) {
        result[prop] = obj[prop];
    }
    return result;

}

let obj1 = {
    name : "injun",
    age: 20
}

let obj2 = obj1

console.log(obj1 === obj2);

obj2 = copyObjectShallow(obj1);

console.log(obj1 === obj2);

obj2.name = "injun2";

console.log(obj1.name);
console.log(obj2.name);
console.log(obj1.name === obj2.name);
console.log(obj1.age === obj2.age)

console.log("================얉은 복사와 깊은 복사 비교============")

console.log("================얉은 복사============")
let obj3 = {
    length : 20,
    width: 25,
    description : {
        title : "제목1",
        detail : "상세내용"
    }
}

let obj4 = copyObjectShallow(obj3);

obj4.length = 25;
obj4.description.title = "제목2";

console.log(obj4.description.title === obj3.description.title);
console.log(obj4.length === obj3.length);
console.log(obj3.description.title);


console.log("================깊은 복사============")

let obj5 = {
    length : 20,
    width: 25,
    description : {
        title : "제목1",
        detail : "상세내용"
    }
}

let obj6 = copyObjectShallow(obj5);
obj6.description = copyObjectShallow(obj5.description);

obj6.description.title = "제목2";
console.log(obj5.description.title === obj6.description.title)
console.log(obj5.description.title)
console.log(obj6.description.title)

console.log("깊은복사 메서드 시작")
function copyObjectDeep(target) {

    let result = {};
    // 만약 target 이 object면 깊은 복사를 진행
    if (typeof target === 'object' && target !== null) {
        for (prop in target) {
            result[prop] = copyObjectDeep(target[prop]);
        }
    }else{
        result = target;
    }
    return result;


}

obj1={
    age:20,
    descrption:{
        title:"타이틀1",
        detail:"디테일1"
    }
}

obj2 = copyObjectDeep(obj1);

obj2.descrption.title = "타이틀2";
console.log(obj1.descrption === obj2.descrption)
console.log(obj1.descrption.title);
console.log(obj2.descrption.title);

/**
 * Json을 이용한 깊은 복사
 * 함수나, getter ,setter , proto타입 등은 복사가 안된다.
 */
console.log("=============json을 이용한 객체 깊은복사=================")

function copyObjectViaJSON(target) {
    return JSON.parse(JSON.stringify(target));
}

let obj = {
    a:1,
    b:{
        c:null,
        d:[1,2],
        func1: function () {
            console.log(3)
        }
    }

}

obj1 = copyObjectViaJSON(obj);

obj1.a = 3;
obj1.b.c = 4;
obj.b.d[1] = 3;

console.log(obj);
console.log(obj1);

console.log("=========undefiend 관련==============")

let a;

obj = {
    a:1
}
console.log(a);
console.log(obj.b);

function fin() {

}

let c = fin();
console.log(c);

console.log("=====undefined배열 =======")

let arr1 = [];
arr1.length = 3;
console.log(arr1);

let arr2 = new Array(3);
console.log(arr2);

let arr3 = [undefined, undefined, undefined];
console.log(arr3);