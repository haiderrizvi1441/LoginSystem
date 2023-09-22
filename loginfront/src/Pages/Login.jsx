import React, { useState } from 'react'
import axios from 'axios';
import { useNavigate,Link } from 'react-router-dom';

function Login() {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const login = async (e) => {
        e.preventDefault();
        try {
            await axios.post("http://localhost:8080/employees/login", {
                email: email,
                password: password
            }).then((result) => {
                console.log(result.data);

                if (result.data.message === "Email does not exist") {
                    alert("Email does not exist");
                }
                else if (result.data.message === "Login Success") {
                    navigate("/home")
                }
                else {
                    alert("Incorrect Email and Password, Please try again");
                }

            }, fail => {
                console.error(fail);
            });
        }
        catch (err) {
            alert(err.response.data);
        }
    }
    return (

        <div className="login-container">
            <h2>Login</h2>
            <form>

                <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input
                        type="email"
                        id="email"
                        name="email"
                        value={email}
                        onChange={(e) => {
                            setEmail(e.target.value);
                        }}

                    />
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        value={password}
                        onChange={(e) => {
                            setPassword(e.target.value);
                        }}
                        required
                    />
                </div>
                <div className="form-group">
                    <button type="submit" onClick={login}>Login</button>
                </div>
                
            </form>
            <div>
                <button><Link to="/register">New User? Register Here</Link></button>
            </div>
        </div>
    )

}

export default Login