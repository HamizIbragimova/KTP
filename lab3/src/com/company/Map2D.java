package com.company;

public class Map2D { //представляет карту, по которой перемещается алгоритм А*, включая в себя информацию о проходимости ячеек
    private int width; //Ширина карты
    private int height; //Длина карты

    private int[][] cells; //Фактические данные карты, которые необходимы для навигации алгоритму поиска пути.
    private Location start; //Начальная локация для поиска пути A*
    private Location finish; //Конечная локация для поиска пути A*
    public Map2D(int width, int height) //Создает новую 2D-карту с указанными шириной и высотой.
    {
        if (width <= 0 || height <= 0)
        {
            throw new IllegalArgumentException("width and height must be positive values; got " + width + "x" + height);
        }
        this.width = width;
        this.height = height;

        cells = new int[width][height];

        // Составьте некоторые координаты для старта и финиша.
        start = new Location(0, height / 2);
        finish = new Location(width - 1, height / 2);
    }


    //Этот вспомогательный метод проверяет указанные координаты, чтобы убедиться, что они в границах карты.
    // Если координаты не на карте затем метод генерирует исключение  <code>IllegalArgumentException</code>.
    private void checkCoords(int x, int y)
    {
        if (x < 0 || x > width)
        {
            throw new IllegalArgumentException("x must be in range [0, " + width + "), got " + x);
        }

        if (y < 0 || y > height)
        {
            throw new IllegalArgumentException("y must be in range [0, " + height + "), got " + y);
        }
    }

    /** Возвращает ширину карты. **/
    public int getWidth()
    {
        return width;
    }

    /** Возвращает длину карты.**/
    public int getHeight()
    {
        return height;
    }

    /**
     Возвращает true, если указанные координаты содержатся в области карты
     **/
    public boolean contains(int x, int y)
    {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }


    /** Возвращает true, если местоположение содержится в области карты. **/
    public boolean contains(Location loc)
    {
        return contains(loc.xCoord, loc.yCoord);
    }

    /**
     Возвращает сохраненное значение стоимости для указанной ячейки. **/
    public int getCellValue(int x, int y)
    {
        checkCoords(x, y);
        return cells[x][y];
    }

    /** Возвращает сохраненное значение стоимости для указанной ячейки **/
    public int getCellValue(Location loc)
    {
        return getCellValue(loc.xCoord, loc.yCoord);
    }

    /** Устанавливает значение стоимости для указанной ячейки **/
    public void setCellValue(int x, int y, int value)
    {
        checkCoords(x, y);
        cells[x][y] = value;
    }

    /**
     Возвращает начальное местоположение карты. Именно здесь генерируется путь начнется с.
     **/
    public Location getStart()
    {
        return start;
    }

    /**
     Устанавливает начальное местоположение для карты. Здесь сгенерированный путь начнется с.
     **/
    public void setStart(Location loc)
    {
        if (loc == null)
            throw new NullPointerException("loc cannot be null");

        start = loc;
    }

    /**
     Возвращает конечное местоположение карты. Именно здесь генерируется путь прекратится
     **/
    public Location getFinish()
    {
        return finish;
    }

    /**
     Устанавливает конечное местоположение для карты. Здесь сгенерированный путь прекратится.
     **/
    public void setFinish(Location loc)
    {
        if (loc == null)
            throw new NullPointerException("loc cannot be null");

        finish = loc;
    }
}
