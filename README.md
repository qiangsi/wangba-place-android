# 网吧，PLEASE · Android

Papers, Please 风格像素小游戏《网吧，PLEASE》的原生安卓版。WebView 壳打包，游戏资源完全离线内置，安装后无需网络（联网只用于日期牌天气显示，失败自动本地兜底）。

▶ 网页在线试玩：<https://maodou-wangba.pinme.dev>

## APK 下载

GitHub Actions 每次推送自动构建：Releases / Actions Artifacts 页面下载 `wangba-please-release.apk`。

## 手机端优化

- 强制横屏（sensorLandscape），转屏不重建 Activity
- 全屏沉浸模式，隐藏状态栏和导航栏；刘海屏短边穿透
- 游戏资源内置 assets，离线可玩，存档走 WebView localStorage（DOM storage 已开启）
- 硬件加速 WebView，Web Audio 无需首次点击即可出声
- 屏幕常亮；DPR 适配像素风渲染

## 构建

```bash
gradle assembleDebug   # debug APK
gradle assembleRelease # 签名 release APK（需 keystore/keystore.properties）
```

签名：`keytool -genkeypair -v -keystore keystore/release.keystore -alias wangba -keyalg RSA -keysize 2048 -validity 10950`，密码写入 `keystore/keystore.properties`（storeFile/storePassword/keyAlias/keyPassword）。

## 目录

```
app/src/main/assets/www/   游戏本体（index.html + js/，来自 wangba-please）
app/src/main/java/.../MainActivity.java   WebView 壳
.github/workflows/android.yml   云端构建
```
