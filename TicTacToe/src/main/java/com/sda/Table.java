package com.sda;

class Table {
    private char[][] table = {{'#', '#', '#'}, {'#', '#', '#'}, {'#', '#', '#'}};

    char[][] getTable() {
        return table;
    }

    void updatePlayerX(int[] x) {
        this.table[x[0]][x[1]] = 'X';
    }

    void updatePlayerO(int[] x) {
        this.table[x[0]][x[1]] = 'O';
    }
}
