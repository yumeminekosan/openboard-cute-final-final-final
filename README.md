# 猫咪输入法 ฅ^•ﻌ•^ฅ

<p align="center">
  <img src="https://img.shields.io/badge/状态-喵~-brightgreen" alt="状态">
  <img src="https://img.shields.io/badge/语言-Kotlin%20%7C%20Java-orange" alt="语言">
  <img src="https://img.shields.io/badge/平台-Android-blue" alt="平台">
</p>

一个可爱的 Android 输入法，带有猫咪文字变身功能！

## ✨ 特色功能

### 🐱 猫咪文字变身
开启猫模式后，输入的文字会自动变成可爱的猫咪风格：

| 原文 | 变身后 |
|------|--------|
| 我 | 猫 |
| 你/他/她/它 | 人咪 |
| 人 | 人咪 |
| 个 | 只 |
| 句末标点 | +喵~ |

**示例：**
- 「我是一个人。」→ 「猫是一只人咪喵~。」
- 「你好！」→ 「人咪好喵~！」

### ⌨️ 快捷操作

| 操作 | 功能 |
|------|------|
| **长按 z 键** | 弹出选择框，选择输入 "喵" 或 "咪" |
| **长按 Shift 键** | 切换猫模式开关 |
| **点击 🐱 键** | 输入猫咪颜文字 `ฅ^•ﻌ•^ฅ` |

### 🎨 春日青色主题
采用温柔的浅灰蓝配色方案，如春日般的清新感：
- 键盘背景：`#E8EEF2` 浅灰蓝
- 按键背景：`#B8D4D9` 春日青
- 按键文字：`#2C3E50` 深灰蓝
- 强调色：`#82C9BB` 春日嫩绿

## 📦 项目版本

本项目有三个版本，基于不同的开源输入法：

| 版本 | 基础项目 | 特点 |
|------|----------|------|
| [openboard-cute-final](https://github.com/yumeminekosan/openboard-cute-final) | OpenBoard | 轻量级，基于 AOSP |
| [openboard-cute-final-final](https://github.com/yumeminekosan/openboard-cute-final-final) | Trime (RIME) | 功能强大，支持多种输入方案 |
| [openboard-cute-final-final-final](https://github.com/yumeminekosan/openboard-cute-final-final-final) | 自定义 IME | 最简实现，易于学习 |

## 🔧 构建

### 前置要求
- Android Studio
- JDK 17+
- Android SDK

### 编译步骤

```bash
# 克隆仓库
git clone https://github.com/yumeminekosan/openboard-cute-final-final-final.git

# 进入项目目录
cd openboard-cute-final-final-final

# 编译 Debug APK
./gradlew assembleDebug
```

APK 位置：`app/build/outputs/apk/debug/app-debug.apk`

## 📖 使用方法

1. 安装 APK
2. 在系统设置中启用输入法：设置 → 系统 → 语言和输入法 → 虚拟键盘 → 猫咪输入法
3. 切换到猫咪输入法
4. 长按 Shift 键开启/关闭猫模式
5. 开始输入可爱的文字吧喵~

## 🐱 开发日志

- 2024.02 - 添加猫咪模式切换功能
- 2024.02 - 长按 z 键输入喵/咪
- 2024.02 - 春日青配色主题
- 2024.02 - 项目初始化

## 📄 许可证

Apache License 2.0

---

<p align="center">
  <b>喵~</b>
</p>
