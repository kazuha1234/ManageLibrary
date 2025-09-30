import React from 'react'
import { Link } from 'react-router'

function Navbar() {
    return (
        <div class="navbar bg-base-100 shadow-sm">
            <div class="navbar-start">
                <a class="btn btn-ghost text-xl"> TrinhLibrary</a>
            </div>
            <div class="navbar-center hidden lg:flex">
                <ul class="menu menu-horizontal px-1">
                    <li><Link to="/books">Manage Books</Link></li>
                    <li>
                        <details>
                            <summary>Parent</summary>
                            <ul class="p-2">
                                <li><a>Submenu 1</a></li>
                                <li><a>Submenu 2</a></li>
                            </ul>
                        </details>
                    </li>
                    <li><a>Item 3</a></li>
                </ul>
            </div>
            <div class="navbar-end">
                <a class="btn mr-2">Register</a>
                <a class="btn">Login</a>
            </div>
        </div >
    )
}

export default Navbar