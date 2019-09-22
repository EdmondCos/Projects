package com.sda;

public enum EChars {
    Underscore {
        @Override
        public String toString() {
            return "_";
        }
    },

    X,
    O,
}