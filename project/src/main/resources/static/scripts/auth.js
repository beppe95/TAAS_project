

    // listen for auth status changes
    auth.onAuthStateChanged(user => {
        if (user) {
            db.collection('guides').onSnapshot(snapshot => {
                setupGuides(snapshot.docs);
                setupUI(user);
            }, err => console.log(err.message));
        } else {
            setupUI();
            setupGuides([]);
        }
    });


    // update user informations
    const updateForm = document.querySelector('#update-form');
    updateForm.addEventListener('submit', (e) => {
        e.preventDefault();
        var user = firebase.auth().currentUser;

        user.updateProfile({
            displayName: updateForm['update-display-name'].value,
            photoURL: "https://example.com/jane-q-user/profile.jpg",
            password: updateForm['update-password'].value
        }).then(() => {
            user.updateEmail(updateForm['update-email'].value);
            // close the create modal & reset form & update UI
            const modal = document.querySelector('#modal-update');
            M.Modal.getInstance(modal).close();
            updateForm.reset();
            setupUI(user);
        }).catch(err => {
            console.log(err.message)
        });




    });

    // create new guide
    const createForm = document.querySelector('#create-form');
    createForm.addEventListener('submit', (e) => {
        e.preventDefault();
        db.collection('guides').add({
            title: createForm.title.value,
            content: createForm.content.value
        }).then(() => {
            // close the create modal & reset form
            const modal = document.querySelector('#modal-create');
            M.Modal.getInstance(modal).close();
            createForm.reset();
        }).catch(err => {
            console.log(err.message);
        });
    });

    // signup
    const signupForm = document.querySelector('#signup-form');
    signupForm.addEventListener('submit', (e) => {
    e.preventDefault();

    // get user info
    const email = signupForm['signup-email'].value;
    const password = signupForm['signup-password'].value;

    // sign up the user
    auth.createUserWithEmailAndPassword(email, password).then(cred => {
        // close the signup modal & reset form
         const modal = document.querySelector('#modal-signup');
         M.Modal.getInstance(modal).close();
        signupForm.reset();
        signupForm.querySelector('.error').innerHTML = '';
        }).catch(e => {
            signupForm.querySelector('.error').innerHTML = e.message;
        });
    });

    // logout
    const logout = document.querySelector('#logout');
    logout.addEventListener('click', (e) => {
        e.preventDefault();
        auth.signOut()
    });


    // login with email and password
    const loginForm = document.querySelector('#login-form');
    loginForm.addEventListener('submit', (e) => {
        e.preventDefault();

        // get user info
        const email = loginForm['login-email'].value;
        const password = loginForm['login-password'].value;

        // log the user in
        auth.signInWithEmailAndPassword(email, password).then(() => {
            // close the signup modal & reset form
            const modal = document.querySelector('#modal-login');
            M.Modal.getInstance(modal).close();
            loginForm.reset();
        }).catch(e => {
            loginForm.querySelector('.error').innerHTML = e.message;
        });

    });


    // login with google
    const loginGoogle = document.querySelector('#google-signup');
    loginGoogle.addEventListener('submit', (e) => {
        e.preventDefault();

        // log the user in
        firebase.auth().signInWithPopup(googleProvider).then(() => {
            // close the signup modal & reset form
            const modal = document.querySelector('#modal-google');
            M.Modal.getInstance(modal).close();
            loginGoogle.reset();
        }).catch(e => {
            loginGoogle.querySelector('.error').innerHTML = e.message;
        });
    });


    // login with facebook
    const loginFacebook = document.querySelector('#facebook-signup');
    loginFacebook.addEventListener('submit', (e) => {
        e.preventDefault();

        // log the user in
        firebase.auth().signInWithPopup(facebookProvider).then(() => {
            // close the signup modal & reset form
            const modal = document.querySelector('#modal-facebook');
            M.Modal.getInstance(modal).close();
            loginFacebook.reset();
        }).catch(e => {
            loginFacebook.querySelector('.error').innerHTML = e.message;
        });

    });


