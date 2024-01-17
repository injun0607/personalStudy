'use strict';

//class : 클래스
//object : 인스턴스
//자바스크립트 클래스는 ES6에 도입되었다
//자바스크립트의 프로토타입을 기반으로 도입되었다.

class person{

    name;
    age;
    //생성자
    constructor(name, age) {
        //fields
        this.name = name;
        this.age = age;
    }

    //메소드
    speak() {
        console.log(`${this.name} hello`);
    }

}

const injun = new person('injun', 27);
console.log(injun.name);
console.log(injun.age);
injun.speak();

//Getter와 Setter
class User{


    constructor(firstName, lastName, age) {
        this.firstName = firstName
        this.lastName = lastName;
        this.age = age;
    }

    //get을 설정하게 된다면
    //this.age를 호출할때 get age()를 호출하게 된다
    get age() {
        return this._age;
    }

    //set을 설정하게 된다면
    //'='를 불러올때 set을 호출하게 된다.
    //재귀를 방지하기위해 변수를 _를 줘서 방지한다.
    set age(value) {
        this._age = value < 0 ? 0 : value;
    }

}

const user1 = new User('Steve', 'Job', -1);
console.log('userage : '+ user1.age);


//3.Fields(public, private)
//Too soon
class Experiment{
    publicField = 2;
    //private 키워드
    #privateField = 0;
}

const experiment = new Experiment();
console.log(experiment.publicField);
console.log(experiment.privateField);

