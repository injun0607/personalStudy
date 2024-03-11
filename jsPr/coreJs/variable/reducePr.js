const numbers = [10, 20, 30, 40, 50];

let avg = numbers.reduce((p, c) => p + c) / numbers.length;
console.log(avg);
//문제 2: 문자열 배열에서 가장 긴 문자열 찾기
const strings = ["JavaScript", "Python", "Ruby", "C++", "Haskell"];

let best = strings.reduce((p, c) => p.length > c.length ? p:c, " ");
console.log(best);

//문제 3: 객체 배열에서 특정 속성의 최대값 찾기
const scores = [
    { name: "Alice", score: 65 },
    { name: "Bob", score: 90 },
    {name: "Charlie", score: 85 }
];

let bestScore = scores.reduce((p, c) => p.score > c.score ? p : c);
console.log(bestScore);


//문제 4: 배열의 중복 요소 제거
const items = [1, 2, 2, 3, 4, 5, 5, 5, 6];

let arr = items.reduce((p,c)=>{
    if (!p.includes(c)) {
        p.push(c);
    }
    return p
},[])

console.log(arr)

//문제 5: 객체 배열에서 특정 속성으로 그룹화하기
const students = [
    { name: "Alice", class: "A" },
    { name: "Bob", class: "B" },
    { name: "Eve", class: "A" },
    { name: "Dave", class: "B" },
    { name: "Chris", class: "C" }
];

let student = students.reduce((c,p)=>{
    let clz = p.class
    if (!c[clz]) {
        c[clz] = [];
    }
    c[clz].push(p);

    return c;

},{})

console.log(student);