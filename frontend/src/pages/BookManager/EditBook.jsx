import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { useNavigate, useParams } from 'react-router-dom'

import BookForm from '../../Components/Book/BookForm'

function EditBook() {
    const { id } = useParams()
    const [book, setBook] = useState(null)

    const navigate = useNavigate()


    useEffect(() => {
        axios.get(`http://localhost:8080/library/books/${id}`)
            .then(res => {
                setBook(res.data)
            });
    }, [id]);

    const handleUpdate = (data) => {
        axios.put(`http://localhost:8080/library/books/${id}`, data)
            .then(() => {
                console.log(data)
                navigate("/books")
            })
            .catch((err) => console.error(err));
    };

    return book ? <BookForm initialValues={book} onSubmit={handleUpdate} mode="edit" /> : <p>Loading...</p>;
}

export default EditBook