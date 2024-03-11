
let startReady = ()=>{
    return 'startReady'
}
//익명함수를 사용할시 주의점은
//해당 함수를 할당하기 전보다 먼저 함수를 사용하면 당연히 에러가 발생한다.
start();
function start() {

    console.log(startReady());
    console.log('start')
}





