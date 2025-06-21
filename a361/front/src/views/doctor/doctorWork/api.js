import { getRequest, postRequest, putRequest, postBodyRequest, getNoAuthRequest, postNoAuthRequest } from '@/libs/axios';

export const getDoctorWorkOne = (params) => {
    return getRequest('/doctorWork/getOne', params)
}
export const getDoctorWorkList = (params) => {
    return getRequest('/doctorWork/getByPage', params)
}
export const getDoctorWorkCount = (params) => {
    return getRequest('/doctorWork/count', params)
}
export const addDoctorWork = (params) => {
    return postRequest('/doctorWork/insert', params)
}
export const editDoctorWork = (params) => {
    return postRequest('/doctorWork/update', params)
}
export const addOrEditDoctorWork = (params) => {
    return postRequest('/doctorWork/insertOrUpdate', params)
}
export const deleteDoctorWork = (params) => {
    return postRequest('/doctorWork/delByIds', params)
}
export const getUserList = (params) => {
    return getRequest('/superUser/getAll', params)
}