'use strict';

//Promise is a js object for asynchronous operation
//state 에 대한 이해
//producer와 consumer의 차이

//state: pending -> fulfilled or rejected
//Producer vs Consumer

//1.Producer
const promise = new Promise((resolve,reject) => {
    //doing some heavy work(network, read files)
    //프로미스가 만들어지는 그순간 executor 실행됨
    console.log('doing something...')
    setTimeout(() => {
        //resolve('injun')
        reject(new Error('no network'))
    },1000)
});
//즉 눌렀을때 반응하는 것을 네트워크 연결을 하는것을 의도할때는 주의해야함

//2. Consumers: then, catch, finally
promise
    .then((value) =>{
    console.log(value);
})
.catch(error =>{
    console.log(error);
})
.finally(() =>{console.log('finally')})

//3.Promise chaning
const fetchNumber = new Promise((resolve,reject)=> {
    setTimeout(() => resolve(1), 100);
})

fetchNumber
    .then(num => num * 2)
    .then(num => num * 3)
    .then(num=>{
        return new Promise((resolve,reject)=>{
            setTimeout(()=>resolve(num-1),1000);
        })
    })
    .then(num => console.log(num))
//4.Error Handling
const getHen= ()=>new Promise((resolve,reject) =>{
    setTimeout(() => resolve('닭'), 1000);
})

const getEgg= hen =>new Promise((resolve,reject) =>{
    setTimeout(() => reject(new Error(`error! ${hen} => 알`)), 1000);
})

const cook= egg=>new Promise((resolve,reject) =>{
    setTimeout(() => resolve(`${egg} => 계란`), 1000);
})

getHen()
    .then(hen => getEgg(hen)) //.then(getEgg)로 생략이 가능함
    .catch(error=>{
        //전체적인 프로미스체인을 위해 catch처리를 한다.
        return 'bread'
    })
    .then(egg => cook(egg)) //.then(cook)로 생략이 가능함
    .then(meal => console.log(meal))//.then(console.log)로 생략이 가능함
    .catch(console.log)
;