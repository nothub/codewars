package lol.hub.codewars.finding_neo_pg_13;

class ArrayMatrix implements Matrix {
    private final int size;
    private final int[][] matrix;

    public ArrayMatrix(int size, int[][] matrix) {
        this.size = size;
        this.matrix = matrix;
    }

    public int size() {
        return size;
    }

    public int get(int x, int y) {
        return matrix[x][y];
    }
}
