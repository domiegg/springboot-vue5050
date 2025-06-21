import { getRequest, postRequest, putRequest, postBodyRequest, getNoAuthRequest, postNoAuthRequest } from '@/libs/axios';

export const getPrescribingOne = (params) => {
    return getRequest('/prescribing/getOne', params)
}
export const getPrescribingList = (params) => {
    return getRequest('/prescribing/getByPage', params)
}
export const getPrescribingCount = (params) => {
    return getRequest('/prescribing/count', params)
}
export const addPrescribing = (params) => {
    return postRequest('/prescribing/insert', params)
}
export const editPrescribing = (params) => {
    return postRequest('/prescribing/update', params)
}
export const addOrEditPrescribing = (params) => {
    return postRequest('/prescribing/insertOrUpdate', params)
}
export const deletePrescribing = (params) => {
    return postRequest('/prescribing/delByIds', params)
}
export const getUserList = (params) => {
    return getRequest('/superUser/getAll', params)
}
export const getDrugList = (params) => {
    return getRequest('/drug/getAll', params)
}