import React, { useEffect, useState } from 'react'
import { Link } from 'react-router'

function BookForm({ initialValues, onSubmit, mode }) {
    const [form, setForm] = useState({
        title: "",
        author: "",
        publishedYear: "",
        quantity: ""
    })

    // If have initialValues (when edit), load to form
    useEffect(() => {
        if (initialValues) {
            setForm(initialValues)
        }
    }, [initialValues])

    const handleChange = (e) => {
        const { name, value } = e.target
        setForm({ ...form, [name]: value })
    }

    const handleSubmit = (e) => {
        e.preventDefault()
        onSubmit(form)
    }

    return (
        <form onSubmit={handleSubmit} className="flex align-middle justify-center">
            <div className='space-y-4 w-[320px] mt-8'>
                <input
                    type="text"
                    name="title"
                    value={form.title}
                    onChange={handleChange}
                    placeholder="Title"
                    className="input input-bordered w-full"
                />
                <input
                    type="text"
                    name="author"
                    value={form.author}
                    onChange={handleChange}
                    placeholder="Author"
                    className="input input-bordered w-full"
                />
                <input
                    type="number"
                    name="publishedYear"
                    value={form.publishedYear}
                    onChange={handleChange}
                    placeholder="Published Year"
                    className="input input-bordered w-full"
                />
                <input
                    type="number"
                    name="quantity"
                    value={form.quantity}
                    onChange={handleChange}
                    placeholder="Quantity"
                    className="input input-bordered w-full"
                />
                <button type="submit" className="btn btn-primary">
                    {mode === "edit" ? "Update Book" : "Add Book"}
                </button>
                <button className="btn btn-warning ml-2 mb-4"><Link to={"/books"}>Back</Link></button>
            </div>
        </form>
    )
}

export default BookForm