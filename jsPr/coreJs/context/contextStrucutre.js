/**
 * 1. 컨텍스트의 구조
 * 실행 컨텍스트의 구조는
 * 스택형식으로 되어있다.
 * 콜스택이라는 곳에 함수를 쌓아 올렸다가 순차적으로 실행하게 된다.
 * 컨텍스트를 구성하는 방법은 함수를 실행하는것 뿐이다.
 *
 */

let a = 1;

function outer() {
    function inner() {
        console.log(a);
        a = 3;
    }

    inner();// 2
    console.log(a);
}

outer(); // 1
console.log(a)

/**
 * js를 실행하는 순간 콜스택에 전역컨텍스트가 쌓이고
 * 그 다음 호출되는 순선 1,2로 쌓이게 된다.
 * 1 번이 호출되면서 1번에 해당 하는 함수의 컨텍스트가 실행된다.
 * 1번 함수를 따라가다보면 inner라는 함수가 실행 되는데
 * 이때 콜스택에 2번이 쌓이면서 2번 함수의 컨텍스트가 실행된다.
 * 2번 함수의 컨텍스트가 실행되면서 변수 a를 할당하면서 2번 함수의 컨텍스트가 종료된다
 * 2번 함수의 컨텍스트가 콜스택에서 제거되면 , 다시 1번 함수의 컨텍스트를 실행하고 inner()호출 다음 부분인 console.log(a)를 실행하고 1번 함수의 컨텍스트가 종료된다.
 */



/**
 * 2.컨텍스트의 내부 구조
 * 컨텍스트 내부에는
 * VariableEnvironment(VE) - 현재 컨텍스트 내의 식별자들에 대한 정보 + 외부 환경 정보. 선언시점의 LexicalEnvironment 스냅샷으로 변경사항 반영x
 * LexicalEnvironment(LE) - 처음에는 VE와 같지만 변경사항이 실시간으로 반영
 * ThisBinding: this 식별자가 바라봐야 할 대상 객체
 */

const context = {
    VE:{
        environmnentRecord, //snapshot
        outerEnvironmentReference //snapshot
    },
    LE:{
        environmnentRecord, //호이스팅이 일어남
        outerEnvironmentReference
    },
    TB:{

    }

}



//피보나치 수열
function fib(n) {
    if (n <= 1) {
        return n;
    }
    return fib(n - 1) + fib(n - 2);
}






