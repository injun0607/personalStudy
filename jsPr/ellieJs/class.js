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
    age;
    _age;
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
        console.log('set age = ' + this._age);
    }

}

const user1 = new User('Steve', 'Job', -1);
console.log('userage : '+ user1.age);
console.log(`this_.age = ${user1._age}`)



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

//4.Static properites and methods
//Too soon!
class Article{
    static publisher = 'injun Coding';

    constructor(articleNumber) {
        this.articleNumber = articleNumber;
    }

    static printPublicsher() {
        console.log(Article.publisher);
    }
}

const article1 = new Article(1);
const article2 = new Article(2);
console.log(Article.publisher)
Article.printPublicsher();

console.log('--------5번 입니다---------')
//5. 상속
//a way for one class to extend another class.
class Shape{
    constructor(width, height, color) {
        this.width = width;
        this.height = height;
        this.cololr = color;
    }

    draw() {
        console.log(`drawing ${this.cololr} color of`)
    }

    getArea() {
        return this.width * this.height;
    }

}

class Rectangle extends Shape {

}

class Triangle extends Shape {

    draw() {
        super.draw();
        console.log('triangle des')
    }

    getArea() {
        return this.width * this.height * 1/2;
    }
}

const rectangle = new Rectangle(20, 20, 'blue');
rectangle.draw();

const triangle = new Triangle(20, 20, 'pink');
triangle.draw();


console.log(`rectangle area : ${rectangle.getArea()}`);
console.log(`triangle area : ${triangle.getArea()}`);

console.log('------------6번입니다----------')
//6.Class checking instance Of
console.log(rectangle instanceof Rectangle)
console.log(triangle instanceof Rectangle)
console.log(triangle instanceof Triangle)
console.log(triangle instanceof Shape)
console.log(triangle instanceof Object)