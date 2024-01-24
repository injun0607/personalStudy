'use strict'

//JavaScript is synchronous
//Execute the code block in order after hoisting.
//자바는 호이스팅 된 이후부터 동기적이다.
//콜백함수는 특정함수의 인자값으로 들어가는 함수를 콜백함수라고한다
//다른 함수가 callBack을 해주기때문에 callBack함수

console.log('1');
setTimeout(() => console.log('2'),1000);
console.log('3');

//Synchronous callback
function printImmediately(print){
    print();
}

printImmediately(() => console.log('hello'));

//ASynchronous callback
function printWithDelay(print, timeout) {
    setTimeout(print, timeout);
}

printWithDelay(() => console.log('async callback'), 2000);

//callback Hell example
class UserStorage{
    loginUser(id, password, onSuccess, onError) {
        setTimeout(()=>{
            if(
                (id === 'injun' && password ==='seohee') ||
                (id === 'coder' && password ==='academy')
            ){
                onSuccess(id);
            }else{
                onError(new Error('not found'))
            }
        }, 2000);
    }

    getRoles(user, onSuccess, onError){
        setTimeout(() => {
            if (user === 'injun') {
                onSuccess({name: 'injun', role: 'admin'});
            } else {
                onError(new Error('no access'));
            }
        }, 1000);

    }
}

const userStorage = new UserStorage();
const id = prompt('enter your id');
const password = prompt('enter your password');
userStorage.loginUser(
    id,
    password,
    (user) =>{userStorage.getRoles(
        user,
        (userWithRole) =>{
            alert(`Hello ${userWithRole.name}, you have a ${userWithRole.role}`)
        },
        error => {
            console.log(error);
        }
        )},
    (error) =>{console.log(error)}
)
