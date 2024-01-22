import './App.css';

function App() {
  const handleLogin = () => {
    window.location.href = 'http://localhost:8080/oauth2/authorization/google'
  }

  return (
    <div className="App">

      <button onClick={handleLogin} className="social-login-btn">
          <img src="/google-logo.svg" className="google-logo" />
        Continue with Google
      </button>
    </div>
  );
}

export default App;
