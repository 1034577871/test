<template>
	<div class="login">
		<div class="main">
			<el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form">
				<div class="login-innerbox">
          <el-form-item prop="username">
            <el-input v-model="loginForm.username" type="text" auto-complete="off" @focus="isUsername = true" @blur="isUsername = false"
             placeholder="用户名">
              <svg-icon slot="prefix" icon-class="user" v-bind:class="{ 'color-class': isUsername }" class=" input-icon " />
            </el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input v-model="loginForm.password" type="password" auto-complete="off" placeholder="密码" @focus="isPassword = true"
             @blur="isPassword = false" @keyup.enter.native="handleLogin">
              <svg-icon slot="prefix" icon-class="password" v-bind:class="{ 'color-class': isPassword }" class="el-input__icon input-icon " />
            </el-input>
          </el-form-item>
          <el-form-item prop="code">
            <el-input v-model="loginForm.code" auto-complete="off" placeholder="验证码" @focus="isValidCode = true" @blur="isValidCode = false"
             @keyup.enter.native="handleLogin">
              <svg-icon slot="prefix" icon-class="validCode" v-bind:class="{ 'color-class': isValidCode }" class="el-input__icon input-icon " />
            </el-input>
            <div class="login-code">
              <img :src="codeUrl" @click="getCode" />
            </div>
          </el-form-item>
          <el-checkbox v-model="loginForm.rememberMe" style="margin:0px 0px 15px 0px;">记住密码</el-checkbox>
          <el-form-item style="width:100%;">
            <el-button :loading="loading" size="medium" type="primary" style="width:100%;" @click.native.prevent="handleLogin">
              <span v-if="!loading">登 录</span>
              <span v-else>登 录 中...</span>
            </el-button>
          </el-form-item>
        </div>
			</el-form>
		</div>
		<!--  底部  -->
    <div class="el-login-footer">
    	山东广电网络有限公司
    </div>
	</div>
</template>

<script>
	import {
		getCodeImg
	} from "@/api/login";
	import Cookies from "js-cookie";
	import {
		encrypt,
		decrypt
	} from "@/utils/jsencrypt";

	export default {
		name: "Login",
		data() {
			return {
				isUsername: false,
				isPassword: false,
				isValidCode: false,
				codeUrl: "",
				cookiePassword: "",
				loginForm: {
					username: "",
					password: "",
					rememberMe: false,
					code: "",
					uuid: ""
				},
				loginRules: {
					username: [{
						required: true,
						trigger: "blur",
						message: "用户名不能为空"
					}],
					password: [{
						required: true,
						trigger: "blur",
						message: "密码不能为空"
					}],
					code: [{
						required: true,
						trigger: "change",
						message: "验证码不能为空"
					}]
				},
				loading: false,
				redirect: undefined
			};
		},
		watch: {
			$route: {
				handler: function(route) {
					this.redirect = route.query && route.query.redirect;
				},
				immediate: true
			}
		},
		created() {
			this.getCode();
			this.getCookie();
		},
		methods: {
			getCode() {
				getCodeImg().then(res => {
					this.codeUrl = "data:image/gif;base64," + res.img;
					this.loginForm.uuid = res.uuid;
				});
			},
			getCookie() {
				const username = Cookies.get("username");
				const password = Cookies.get("password");
				const rememberMe = Cookies.get("rememberMe");
				this.loginForm = {
					username: username === undefined ? this.loginForm.username : username,
					password: password === undefined ? this.loginForm.password : decrypt(password),
					rememberMe: rememberMe === undefined ? false : Boolean(rememberMe)
				};
			},
			handleLogin() {
				this.$refs.loginForm.validate(valid => {
					if (valid) {
						this.loading = true;
						if (this.loginForm.rememberMe) {
							Cookies.set("username", this.loginForm.username, {
								expires: 30
							});
							Cookies.set("password", encrypt(this.loginForm.password), {
								expires: 30
							});
							Cookies.set("rememberMe", this.loginForm.rememberMe, {
								expires: 30
							});
						} else {
							Cookies.remove("username");
							Cookies.remove("password");
							Cookies.remove("rememberMe");
						}
						this.$store
							.dispatch("Login", this.loginForm)
							.then(() => {
								this.$router.push({
									path: this.redirect || "/"
								});
							})
							.catch(() => {
								this.loading = false;
								this.getCode();
							});
					}
				});
			}
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss">
	.login {
		width: 100%;
		height: 100%;
		position: relative;
	}

	.main {
		float: left;
		width: 100%;
    height: calc(100% - 40px);
		padding: 60px;
    background: url(../assets/image/login-bg.jpg) no-repeat;
    background-size: 100% auto;
    background-color: #FFF;

/* 		.img1 {
			position: absolute;
			top: 46px;
			left: 53px;
			width: 110px;
		}

		.img2 {
			position: absolute;
			top: 63px;
			left: 132px;
			width: 348px;
			height: 299px;
		}

		h3 {
			margin-left: 52px;
			margin-top: 383px;
			margin-bottom: 0;
			font-size: 32px;
		}

		h4 {
			margin-left: 52px;
			font-size: 24px;
			margin-top: 16px;
		} */

		.login-form {
			width: 400px;
			float: right;
			margin-right: 50px;
			margin-top: 100px;
			padding: 15px;
			background-color: rgba(255,255,255,0.5);
			border: 1px solid #b8e5f0;
			border-radius: 6px;
			box-sizing: border-box;
			-webkit-box-shadow: 0 5px 10px rgba(0,0,0,.2);
			box-shadow: 0 5px 10px rgba(0,0,0,.2);

      .login-innerbox {
          padding: 20px 30px 10px;
          background-color: #e4e8e8;
          border-radius: 6px;
          box-sizing: border-box;
      }

			.el-input {
				height: 32px;

				input:focus {
					color: rgba(6, 104, 185, 1);
				}

				input {
					outline: none;
					height: 38px;
					border-top: 0;
					border-left: 0;
					border-right: 0;
					border-radius: 0;
				}
			}

			.color-class {
				color: rgba(6, 104, 185, 1);
			}

			.input-icon {
				height: 39px;
				width: 19px;
				margin-left: 2px;
			}
		}
	}

	.login-code {
		position: absolute;
		width: 88px;
		height: 37px;
		right: 0;
		bottom: 0px;

		img {
			width: 88px;
			height: 37px;
			cursor: pointer;
			vertical-align: middle;
		}
	}

	.el-login-footer {
		height: 40px;
		line-height: 40px;
		position: absolute;
    bottom: 0;
    left: 0;
		width: 100%;
		text-align: center;
		font-family: Arial;
		font-size: 14px;
		letter-spacing: 1px;
    color:#333;

	}
</style>
