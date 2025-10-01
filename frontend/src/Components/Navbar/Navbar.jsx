import React from 'react'
import { Link } from 'react-router'

function Navbar() {
    return (
        <div className="navbar bg-base-100 shadow-sm">
            <div className="navbar-start">
                <a className="btn btn-ghost text-xl"> TrinhLibrary</a>
            </div>
            <div className="navbar-center hidden lg:flex">
                <ul className="menu menu-horizontal px-1">
                    <li><Link to="/books">Manage Books</Link></li>
                    <li>
                        <details>
                            <summary>Parent</summary>
                            <ul className="p-2">
                                <li><a>Submenu 1</a></li>
                                <li><a>Submenu 2</a></li>
                            </ul>
                        </details>
                    </li>
                    <li><a>Item 3</a></li>
                </ul>
            </div>
            <div className="navbar-end">
                <Link to="/auth/register" className="btn mr-2">Register</Link>
                <Link to="/auth/login" className="btn">Login</Link>
            </div>
        </div >
    )
}

export default Navbar