import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useNavigate } from 'react-router-dom'

import { Pencil } from 'lucide-react';
import { CircleX } from 'lucide-react';

function BookList() {
    const [books, setBooks] = useState([])
    const [selectedBook, setSelectedBook] = useState(null)
    const [page, setPage] = useState(0)
    const [totalPages, setTotalPages] = useState(0)
    const [searchValue, setSearchValue] = useState("")
    const size = 5

    const navigate = useNavigate()

    useEffect(() => {
        axios.get("http://localhost:8080/library/books", {
            params: {
                page: page,
                size: size,
                search: searchValue
            }
        })
            .then(response => {
                setBooks(response.data.content)
                setTotalPages(response.data.totalPages)
                console.log(response.data)
            })
            .catch(error => {
                console.error("Error fetch book list. ", error)
            })
    }, [page, size, searchValue])

    const handleDelete = (id) => {
        axios.delete(`http://localhost:8080/library/books/${id}`)
            .then(() => {
                setBooks(books.filter(b => b.id != id))
                setSelectedBook(null)
            })
            .catch((err) => console.error(err))
    }

    return (
        <div className="overflow-x-auto">

            <div className='m-2'>
                <input
                    value={searchValue}
                    onChange={(e) => {
                        setSearchValue(e.target.value)
                    }}
                    type="text" placeholder="Search book name" className="input" />
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
                    {books.length > 0 ? (
                        books.map((book, index) => (
                            <tr key={book.id}>
                                <th>{index + 1}</th>
                                <td>{book.title}</td>
                                <td>{book.author}</td>
                                <td>{book.publishedYear}</td>
                                <td>{book.quantity}</td>
                                <td>
                                    <Link to={`/books/edit/${book.id}`}>
                                        <button className="btn btn-primary ml-2">
                                            <Pencil />
                                        </button>
                                    </Link>
                                    <button
                                        className="btn btn-error ml-2"
                                        onClick={() => {
                                            setSelectedBook(book);
                                            document.getElementById("delete_modal").showModal();
                                        }}
                                    >
                                        <CircleX />
                                    </button>
                                </td>
                            </tr>
                        ))
                    ) : (
                        <tr>
                            <td colSpan="6" className="text-center">
                                Don’t have any books
                            </td>
                        </tr>
                    )}
                </tbody>
            </table>

            {/* Modal */}
            <dialog id="delete_modal" className="modal">
                <div className="modal-box">
                    <h3 className="text-lg"> Do you want to delete <span className='font-bold'>{selectedBook?.title}</span> ?</h3>
                    <div className="modal-action">
                        <form method="dialog">
                            <button className="btn btn-error mr-2"
                                onClick={() => handleDelete(selectedBook.id)}>
                                Yes
                            </button>
                            <button className="btn">Close</button>
                        </form>
                    </div>
                </div>
            </dialog>

            {/* Pagination */}
            <div className="join mt-4 flex align-middle justify-center">
                {Array.from({ length: totalPages }, (_, i) => (
                    <button
                        className={`join-item btn ${page == i ? "btn-active" : ""}`}
                        key={i}
                        onClick={() => setPage(i)}
                    >
                        {i + 1}
                    </button>
                ))}
            </div>
        </div>
    )
}

export default BookList