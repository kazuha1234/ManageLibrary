import React from 'react'
import axios from 'axios'

import BookForm from '../../Components/Book/BookForm'
import { useNavigate } from 'react-router-dom';

function AddBook() {
    const navigate = useNavigate()

    const handleAdd = (data) => {
        axios.post("http://localhost:8080/library/books", data)
            .then(() => {
                console.log(data)
                navigate("/books")
            })
            .catch((err) => console.error(err));
    };

    return <BookForm onSubmit={handleAdd} mode="add" />;
}

export default AddBook