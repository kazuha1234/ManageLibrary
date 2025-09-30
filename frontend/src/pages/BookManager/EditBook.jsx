import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { useParams } from 'react-router'


function EditBook() {
    const { id } = useParams()
    const [book, setBook] = useState(null)

    useEffect(() => {
        axios.get(`http://localhost:8080/library/books/${id}`)
            .then(res => setBook(res.data));
    }, [id]);

    const handleUpdate = (data) => {
        axios.put(`http://localhost:8080/library/books/${id}`, data)
            .then(() => console.log(data))
            .catch((err) => console.error(err));
    };

    return book ? <BookForm initialValues={book} onSubmit={handleUpdate} mode="edit" /> : <p>Loading...</p>;
}

export default EditBook