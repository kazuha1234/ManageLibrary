import Navbar from './../Components/Navbar/Navbar'
import Home from './../pages/Home/Home'
import Auth from './../pages/Auth/Auth'
import Error from './../pages/Error/Error'
import Login from './../pages/Auth/Login/Login'
import Register from './../pages/Auth/Register/Register'

import { BrowserRouter, Route, Routes } from 'react-router-dom'
import BookList from '../pages/BookManager/BookList'
import AddBook from '../pages/BookManager/AddBook'
import EditBook from '../pages/BookManager/EditBook'

function MainLayout() {
    return (

        <BrowserRouter>
            {/* Navbar */}
            <Navbar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="auth" element={<Auth />}>
                    <Route path="login" element={<Login />} />
                    <Route path="register" element={<Register />} />
                </Route>

                {/* Manage Book */}
                <Route path="books" element={<BookList />} />
                <Route path="books/add" element={<AddBook />} />
                <Route path="books/edit" element={<EditBook />} />

                {/* Not found routes */}
                <Route path="*" element={<Error />} />
            </Routes>
        </BrowserRouter>

    )
}

export default MainLayout                                                                               