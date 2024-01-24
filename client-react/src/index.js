import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App.js';
import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom";
import LoginSuccess from "./components/LoginSuccess.js";
import AuthCallback from "./components/AuthCallback.js";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App />,
    },
    {
        path: "/auth/callback",
        element: <AuthCallback />,
    },

])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/*<App />*/}
      <RouterProvider router={router} />
  </React.StrictMode>
);

