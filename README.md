# Android 组件化项目框架
**项目简介**
本项目是一个基于 **OkHttp + Retrofit + RxJava + MVVM + 组件化** 的 Android 项目框架，旨在提供一个高效、可扩展、易于维护的开发基础。通过组件化设计，项目可以灵活拆分为多个独立模块，提升开发效率和代码复用性。

#### 技术栈
网络请求：

OkHttp：高性能的 HTTP 客户端。

Retrofit：基于 OkHttp 的 RESTful API 请求库。

RxJava：响应式编程框架，用于处理异步数据流。

#### 架构模式：

MVVM：Model-View-ViewModel 架构模式，结合 Jetpack 组件（如 LiveData、ViewModel）实现数据驱动视图。

组件化：

通过 Gradle 模块化设计，将项目拆分为多个独立模块，实现业务逻辑的解耦和复用。

其他工具：

Jetpack：包含 Lifecycle、LiveData、ViewModel、Room 等组件，提升开发效率。

Kotlin：项目主要开发语言，提供更简洁、安全的代码编写体验。

项目结构
app/                       # 主模块（壳工程）
├── build.gradle           # 主模块的 Gradle 配置
├── src/
│   ├── main/
│       ├── java/          # 主模块的代码
│       └── res/           # 主模块的资源

library-api/               # api接口
├── build.gradle           # api接口 Gradle 配置
├── src/
│   ├── main/
│       └── java/          # api接口的代码

library-mvvm/              # 基类封装
├── build.gradle           # 基类封装的 Gradle 配置
├── src/
│   ├── main/
│       ├── java/          # 基类封装的代码
│       └── res/           # 基类封装的资源

library-okhttp/            # 网络模块
├── build.gradle           # 网络模块的 Gradle 配置
├── src/
│   ├── main/
│       └── java/          # 网络模块的代码

settings.gradle            # 项目模块配置
