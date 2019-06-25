package com.sda;

enum ESymbols {
    DIEZ {
        @Override
        public String toString() {
            return "#";
        }
    },

    AT {
        @Override
        public String toString() {
            return "@";
        }
    },

    AND {
        @Override
        public String toString() {
            return "&";
        }
    },

    EXCL {
        @Override
        public String toString() {
            return "!";
        }
    },

    QUESTION {
        @Override
        public String toString() {
            return "?";
        }
    },

    DOLLAR {
        @Override
        public String toString() {
            return "$";
        }
    },

    STAR {
        @Override
        public String toString() {
            return "*";
        }
    },

    PERCENTAGE {
        @Override
        public String toString() {
            return "%";
        }
    },

}
