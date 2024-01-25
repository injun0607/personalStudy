class UserStorage{
    loginUser(id, password) {
        return new Promise((resolve,reject) =>{
            setTimeout(()=>{
                if(
                    (id === 'injun' && password ==='seohee') ||
                    (id === 'coder' && password ==='academy')
                ){
                    resolve(id);
                }else{
                    reject(new Error('not found'))
                }
            }, 2000);
        });
    }

    getRoles(user){
        return new Promise((resolve,reject) =>{
            setTimeout(() => {
                if (user === 'injun') {
                    resolve({name: 'injun', role: 'admin'});
                } else {
                    reject(new Error('no access'));
                }
            }, 1000);
        })
    }
}

const userStroage = new UserStorage();
const id = prompt('enter your id');
const password = prompt('enter your password')

userStroage.loginUser(id,password)
.then(user => userStroage.getRoles(user))
.then(user => alert(`Hello ${user.name}, you have a ${user.role}`))
.catch(console.log)