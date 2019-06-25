package com.sda;

public enum EChars {
    Hash {
        @Override
        public String toString() {
            return "#";
        }
    },

    X,
    O,
}
