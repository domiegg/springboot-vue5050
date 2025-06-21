import { getRequest, postRequest, putRequest, postBodyRequest, getNoAuthRequest, postNoAuthRequest } from '@/libs/axios';

export const getDrugOne = (params) => {
    return getRequest('/drug/getOne', params)
}
export const getDrugList = (params) => {
    return getRequest('/drug/getByPage', params)
}
export const getDrugCount = (params) => {
    return getRequest('/drug/count', params)
}
export const addDrug = (params) => {
    return postRequest('/drug/insert', params)
}
export const editDrug = (params) => {
    return postRequest('/drug/update', params)
}
export const addOrEditDrug = (params) => {
    return postRequest('/drug/insertOrUpdate', params)
}
export const deleteDrug = (params) => {
    return postRequest('/drug/delByIds', params)
}