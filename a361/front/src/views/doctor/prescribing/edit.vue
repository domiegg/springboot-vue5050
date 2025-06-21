<template>
<div>
    <Card>
        <div slot="title">
            <div class="edit-head">
                <a @click="close" class="back-title">
                    <Icon type="ios-arrow-back" />返回
                </a>
                <div class="head-name">编辑</div>
                <span></span>
                <a @click="close" class="window-close">
                    <Icon type="ios-close" size="31" class="ivu-icon-ios-close" />
                </a>
            </div>
        </div>
        <Form ref="form" :model="form" :label-width="100" :rules="formValidate" label-position="left">
            <FormItem label="接诊人" prop="title">
                <Select v-model="form.title" clearable placeholder="请选择接诊人..." style="width:570px">
                    <Option v-for="(item,index) in userList" :key="index" :value="item.nickname">{{ item.nickname }}</Option>
                </Select>
            </FormItem>
            <FormItem label="处方记录" prop="content1">
                <Input v-model="form.content1" type="textarea" :rows="4" clearable maxlength="240" show-word-limit placeholder="请输入处方记录..." style="width:570px" />
            </FormItem>
            <FormItem label="附图" prop="image">
                <upload-pic-input v-model="form.image" placeholder="请上传附图..." style="width:570px"></upload-pic-input>
            </FormItem>
            <FormItem label="药品" prop="drug">
                <Select v-model="form.drug" clearable placeholder="请选择药品..." style="width:570px">
                    <Option v-for="(item,index) in drugList" :key="index" :value="item.title">{{ item.title }}</Option>
                </Select>
            </FormItem>
            <FormItem label="特殊说明" prop="content2">
                <Input v-model="form.content2" type="textarea" :rows="4" clearable maxlength="240" show-word-limit placeholder="请输入特殊说明..." style="width:570px" />
            </FormItem>
            <Form-item class="br">
                <Button @click="handleSubmit" :loading="submitLoading" type="primary">提交并保存</Button>
                <Button @click="handleReset">重置</Button>
                <Button type="dashed" @click="close">关闭</Button>
            </Form-item>
        </Form>
    </Card>
</div>
</template>

<script>
import {
    editPrescribing,
    getUserList,
    getDrugList
} from "./api.js";
import uploadPicInput from "@/views/template/upload-pic-input";
export default {
    name: "edit",
    components: {
        uploadPicInput,
    },
    props: {
        data: Object
    },
    data() {
        return {
            submitLoading: false,
            form: {
                title: "",
                content1: "",
                image: "",
                content2: "",
            },
            formValidate: {},
            userList: [],
            drugList: []
        };
    },
    methods: {
        init() {
            this.getUserListFx();
            this.getDrugListFx();
            this.handleReset();
            this.form = this.data;
        },
        getDrugListFx() {
            var that = this;
            that.drugList = [];
            getDrugList().then(res => {
                if(res.success) {
                    that.drugList = res.result;
                }
            })
        },
        getUserListFx() {
            var that = this;
            that.userList = [];
            getUserList().then(res => {
                if (res.success) {
                    that.userList = res.result;
                }
            })
        },
        handleReset() {
            this.$refs.form.resetFields();
        },
        handleSubmit() {
            this.$refs.form.validate(valid => {
                if (valid) {
                    editPrescribing(this.form).then(res => {
                        this.submitLoading = false;
                        if (res.success) {
                            this.$Message.success("操作成功");
                            this.submited();
                        }
                    });
                }
            });
        },
        close() {
            this.$emit("close", true);
        },
        submited() {
            this.$emit("submited", true);
        }
    },
    mounted() {
        this.init();
    }
};
</script>

<style lang="less">
.edit-head {
    display: flex;
    align-items: center;
    justify-content: space-between;
    position: relative;

    .back-title {
        color: #515a6e;
        display: flex;
        align-items: center;
    }

    .head-name {
        display: inline-block;
        height: 20px;
        line-height: 20px;
        font-size: 16px;
        color: #17233d;
        font-weight: 500;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }

    .window-close {
        z-index: 1;
        font-size: 12px;
        position: absolute;
        right: 0px;
        top: -5px;
        overflow: hidden;
        cursor: pointer;

        .ivu-icon-ios-close {
            color: #999;
            transition: color .2s ease;
        }
    }

    .window-close .ivu-icon-ios-close:hover {
        color: #444;
    }
}
</style>
