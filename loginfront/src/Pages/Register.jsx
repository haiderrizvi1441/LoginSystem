import axios from 'axios';
import React, { useState } from 'react'
function Register() {

    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const save = async (e) => {
        e.preventDefault();
        try {
            await axios.post("http://localhost:8080/employees/saveEmployee", {
                name: name,
                email: email,
                password: password,
            });
            alert("Employee Registered Successfully");
        }
        catch (error) {
            alert(error.response.data);
        }

    }

    return (
        <div>

            <div className="register-container">
                <h2>Register</h2>
                <form>
                    <div className="form-group">
                        <label htmlFor="name">Name</label>
                        <input
                            type="text"
                            id="name"
                            name="name"
                            value={name}
                            onChange={(e) => {
                                setName(e.target.value);
                            }}

                        />
                    </div>
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
                        <button type="submit" onClick={save}>Register</button>
                    </div>
                </form>
            </div>

        </div>
    )
}

export default Register