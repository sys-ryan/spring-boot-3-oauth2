import {useEffect, useState} from "react";


const AuthCallback = () => {

    const [data, setData] = useState(null)

    const fetchDataWithParams = async () => {
        const currentParams = new URLSearchParams(window.location.search);
        console.log(currentParams)
        const newUrl = `http://localhost:8080/login/oauth2/code/google?${currentParams.toString()}`;
        console.log(newUrl)

        try {
            const response = await fetch(newUrl, {
                credentials: 'include'
            });
            console.log(response)
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            const jsonData = await response.json();
            setData(jsonData); // 받아온 데이터를 상태 변수에 저장
        } catch (error) {
            console.error('Fetch error:', error);
        }
    }


    useEffect(() => {
        fetchDataWithParams();
    }, []);

    return <div className="content-box">
        <pre>{JSON.stringify(data, null, 2) }</pre>
    </div>


}

export default AuthCallback


// http://localhost:3000/auth/callback?
// state=0VFPHi4j-aBJXVCJTD646DeTlRjW8waNauzUAXBNfwM%3D&
// code=4%2F0AfJohXnbOjuwwCYIyRty-82ETUqUu9UPmtjPOLWcTCFHIK7iULKq6lkdWcI35ZHvrAOCAA&
// scope=email+profile+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile&
// authuser=0&
// prompt=none