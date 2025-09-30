import React from 'react'
import axios from 'axios'

import BookForm from '../../Components/Book/BookForm'

function AddBook() {
    const handleAdd = (data) => {
        axios.post("http://localhost:8080/library/books", data)
            .then(() => console.log(data))
            .catch((err) => console.error(err));
    };

    return <BookForm onSubmit={handleAdd} mode="add" />;
}

export default AddBook