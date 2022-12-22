import axios from 'axios'
import Users from "@/components/Users-create";

const USER_API_BASE_URL = 'http://localhost:8080/users'

class UserService{
    postUsers(){
        const data ={
            firstname: Users.data().firstname,
            lastname: Users.data().lastname,
            email: Users.data().email,
            password:Users.data().password

        }

        return axios.post(USER_API_BASE_URL, data);
    }
}

export default new UserService()

