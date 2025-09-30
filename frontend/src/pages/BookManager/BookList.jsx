import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router'

import { Pencil } from 'lucide-react';
import { CircleX } from 'lucide-react';

function BookList() {
    const [books, setBooks] = useState([])

    useEffect(() => {
        axios.get("http://localhost:8080/library/books")
            .then(response => {
                setBooks(response.data)
                console.log(response.data)
            })
            .catch(error => {
                console.error("Error fetch book list. ", error)
            })
    }, [])

    return (
        <div className="overflow-x-auto">

            <div className='m-2'>
                <input type="text" placeholder="Search book name" className="input" />
                <Link to={"/books/add"}><button className="btn ml-2">Add</button></Link>
            </div>

            <table className="table">
                {/* head */}
                <thead>
                    <tr>
                        <th></th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Published Year</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {books.map((book, index) => {
                        return (
                            <tr key={book.id}>
                                <th>{++index}</th>
                                <td>{book.title}</td>
                                <td>{book.author}</td>
                                <td>{book.publishedYear}</td>
                                <td>{book.quantity}</td>
                                <td>
                                    <Link to="/books/edit"><button className="btn btn-primary ml-2 "><Pencil /></button></Link>
                                    <button className="btn btn-error ml-2"
                                        onClick={() => document.getElementById('delete_modal').showModal()}>
                                        <CircleX />
                                    </button>
                                    <dialog id="delete_modal" className="modal">
                                        <div className="modal-box">
                                            <h3 className="text-lg"> Do you want to delete <span className='font-bold'>{book.title}</span> ?</h3>
                                            <div className="modal-action">
                                                <form method="dialog">
                                                    <button className="btn btn-error mr-2">Yes</button>
                                                    <button className="btn">Close</button>
                                                </form>
                                            </div>
                                        </div>
                                    </dialog>
                                </td>
                            </tr>
                        )
                    })}
                </tbody>
            </table>
        </div>
    )
}

export default BookList