import { useLocation} from "react-router-dom";

const LoginSuccess = () => {
    const location = useLocation();

    const queryParams = new URLSearchParams(location.search);
    const time = queryParams.get('time');
    const name = queryParams.get('name');
    const email = queryParams.get('email');

    return (
        <div>
            <h1>Login Success</h1>
            <p>⏰ {time}</p>
            <p>🐻 {name}</p>
            <p>💌 {email}</p>
        </div>
    )
}

export default LoginSuccess;