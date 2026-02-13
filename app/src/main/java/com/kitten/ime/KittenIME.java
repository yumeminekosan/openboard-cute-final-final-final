package com.kitten.ime;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.app.AlertDialog;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class KittenIME extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView keyboardView;
    private Keyboard keyboard;
    private boolean caps = false;
    private long shiftPressTime = 0;
    private static final long LONG_PRESS_THRESHOLD = 500; // 500ms

    @Override
    public View onCreateInputView() {
        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        keyboard = new Keyboard(this, R.xml.qwerty);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        keyboardView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_SHIFT_LEFT || keyCode == KeyEvent.KEYCODE_SHIFT_RIGHT) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        shiftPressTime = System.currentTimeMillis();
                    } else if (event.getAction() == KeyEvent.ACTION_UP) {
                        if (System.currentTimeMillis() - shiftPressTime > LONG_PRESS_THRESHOLD) {
                            showInputMethodPicker();
                            return true;
                        }
                    }
                }
                return false;
            }
        });
        return keyboardView;
    }

    private void showInputMethodPicker() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showInputMethodPicker();
            Toast.makeText(this, "🐱 选择输入法喵~", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
        if (ic == null) return;
        
        switch (primaryCode) {
            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_SHIFT:
                // 不在这里处理shift，在onRelease中处理
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case -10: // 猫咪颜文字键
                ic.commitText("ฅ^•ﻌ•^ฅ", 1);
                break;
            default:
                char code = (char) primaryCode;
                if (Character.isLetter(code) && caps) {
                    code = Character.toUpperCase(code);
                }
                // 🐱 猫咪变身！
                String text = KittenTransformer.transform(String.valueOf(code));
                ic.commitText(text, 1);
        }
    }

    @Override
    public void onPress(int primaryCode) {
        if (primaryCode == Keyboard.KEYCODE_SHIFT) {
            shiftPressTime = System.currentTimeMillis();
        }
    }

    @Override
    public void onRelease(int primaryCode) {
        if (primaryCode == Keyboard.KEYCODE_SHIFT) {
            if (System.currentTimeMillis() - shiftPressTime > LONG_PRESS_THRESHOLD) {
                // 长按：显示输入法选择器
                showInputMethodPicker();
            } else {
                // 短按：切换大小写
                caps = !caps;
                keyboard.setShifted(caps);
                keyboardView.invalidateAllKeys();
            }
        }
    }

    @Override
    public void onText(CharSequence text) {
        InputConnection ic = getCurrentInputConnection();
        if (ic != null) {
            // 🐱 猫咪变身！
            ic.commitText(KittenTransformer.transform(text.toString()), 1);
        }
    }

    @Override
    public void swipeLeft() {}

    @Override
    public void swipeRight() {}

    @Override
    public void swipeDown() {}

    @Override
    public void swipeUp() {}
}
