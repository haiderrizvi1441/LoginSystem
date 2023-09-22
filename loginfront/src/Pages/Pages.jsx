import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './Home'
import Register from './Register'
import Login from './Login'

function Pages() {
  return (
    <div>
        
            <Routes>
                <Route path="/home" element={<Home/>} />
                <Route path="/register" element={<Register/>} />
                <Route path="/" element={<Login/>} />
                <Route path="/login" element={<Login/>} />
                
            </Routes>
      
    </div>
  )
}

export default Pages