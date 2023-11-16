import React, { useState } from 'react';

class Form extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            name: '',
            lastname: '',
            email: '',
            errors: {
                username: '',
                password: '',
                name: '',
                lastname: '',
                email: '',
            },
        };
    }

    handleChange = (event) => {
        const { name, value } = event.target;
        let errors = this.state.errors;

        switch (name) {
            case 'username':
                errors.username =
                    value.length < 2 ? 'El nombre de usuario deberá de tener más de 2 caracteres' : '';
                break;
            case 'password':
                errors.password =
                    value.length < 8 ? 'La contraseña debe de ser de más de 8 caracteres' : '';
                break;
            case 'name':
                errors.name = value.length < 2 ? 'El nombre debe de ser mayor a 2 caracteres' : '';
                break;
            case 'lastname':
                errors.lastname =
                    value.length < 2 ? 'El nombre debe de ser mayor a 2 caracteres' : '';
                break;
            case 'email':
                errors.email = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value)
                    ? ''
                    : 'Email incorrecto';
                break;
            default:
                break;
        }

        this.setState({ errors, [name]: value });
    };

    handleSubmit = (event) => {
        event.preventDefault();
        const { username, password, name, lastname, email } = this.state;

        if (
            username.length >= 5 &&
            password.length >= 8 &&
            name.length >= 2 &&
            lastname.length >= 2 &&
            /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)
        ) {
            fetch('http://your-backend-api-url.com', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    username,
                    password,
                    name,
                    lastname,
                    email,
                }),
            })
                .then((response) => response.json())
                .then((data) => console.log(data))
                .catch((error) => console.log(error));
        } else {
            alert('Por favor llene el formulario');
        }
    };

    render() {
        const { errors } = this.state;

        return (
            <form onSubmit={this.handleSubmit}>
                <div>
                    <label htmlFor="username">Nombre de usuario:</label>
                    <input
                        type="text"
                        name="username"
                        onChange={this.handleChange}
                        noValidate
                    />
                    {errors.username.length > 0 && (
                        <span className="error">{errors.username}</span>
                    )}
                </div>
                <div>
                    <label htmlFor="password">Contraseña:</label>
                    <input
                        type="password"
                        name="password"
                        onChange={this.handleChange}
                        noValidate
                    />
                    {errors.password.length > 0 && (
                        <span className="error">{errors.password}</span>
                    )}
                </div>
                <div>
                    <label htmlFor="name">Nombre:</label>
                    <input
                        type="text"
                        name="name"
                        onChange={this.handleChange}
                        noValidate
                    />
                    {errors.name.length > 0 && (
                        <span className="error">{errors.name}</span>
                    )}
                </div>
                <div>
                    <label htmlFor="lastname">Apellido:</label>
                    <input
                        type="text"
                        name="lastname"
                        onChange={this.handleChange}
                        noValidate
                    />
                    {errors.lastname.length > 0 && (
                        <span className="error">{errors.lastname}</span>
                    )}
                </div>
                <div>
                    <label htmlFor="email">Email:</label>
                    <input
                        type="email"
                        name="email"
                        onChange={this.handleChange}
                        noValidate
                    />
                    {errors.email.length > 0 && (
                        <span className="error">{errors.email}</span>
                    )}
                </div>
                <button type="submit">Submit</button>
            </form>
        );
    }
}

export default Form;
