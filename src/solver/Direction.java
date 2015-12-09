package solver;


public enum Direction {
    UP {
        @Override
        public int getRow() {
            return -1;
        }

        @Override
        public int getColumn() {
            return 0;
        }
    }, DOWN {
        @Override
        public int getRow() {
            return 1;
        }

        @Override
        public int getColumn() {
            return 0;
        }
    }, LEFT {
        @Override
        public int getRow() {
            return 0;
        }

        @Override
        public int getColumn() {
            return -1;
        }
    }, RIGHT {
        @Override
        public int getRow() {
            return 0;
        }

        @Override
        public int getColumn() {
            return 1;
        }
    };

    public abstract int getRow();

    public abstract int getColumn();
}
