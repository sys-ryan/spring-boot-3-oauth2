import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App.js';
import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom";
import LoginSuccess from "./components/LoginSuccess.js";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App />,
    },
    {
        path: "/login/success",
        element: <LoginSuccess />,
    },

])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/*<App />*/}
      <RouterProvider router={router} />
  </React.StrictMode>
);

