import axios from 'axios';

const api =  axios.create({
    baseURL: 'http://localhost:8080',
});// to avoid CORS error
// to make the endpoint as localhost:8080/api/v1/movies and not localhost:3000/api/v1/movies

export default api;