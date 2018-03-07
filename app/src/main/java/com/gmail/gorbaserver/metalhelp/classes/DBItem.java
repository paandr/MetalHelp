package com.gmail.gorbaserver.metalhelp.classes;

import android.content.res.Resources;

import com.gmail.gorbaserver.metalhelp.R;

public class DBItem {

    private static final String DB_TABLE_NAME = "item";
    
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TYPE_ID = "type_id";
    public static final String COLUMN_SIZE = "size";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_WEIGHT = "weight";
    
    private static final String DB_CREATE_TABLE =
            "create table " + DB_TABLE_NAME + "("
                    +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + ","
                    + COLUMN_TYPE_ID + " INTEGER NOT NULL" + ","
                    + COLUMN_NAME + " TEXT " + ","
                    + COLUMN_SIZE + " TEXT NOT NULL" + ","
                    + COLUMN_WEIGHT + " REAL NOT NULL" + ","
                    + "FOREIGN KEY(" + COLUMN_TYPE_ID + ") REFERENCES "
                    + DBType.getDbTableName() + "(" + DBType.COLUMN_ID + ")" + ");";


    public static String createTable() {
        return DB_CREATE_TABLE;
    }

    public static String getDbTableName() {
        return DB_TABLE_NAME;
    }


    public static class Armatura{

        //region Арматура
        private static MetalItem[] armatura =
                {
                        new MetalItem("6", "6", 0.222),
                        new MetalItem("8", "8", 0.395),
                        new MetalItem("10", "10", 0.617),
                        new MetalItem("12", "12", 0.888),
                        new MetalItem("14", "14", 1.21),
                        new MetalItem("16", "16", 1.58),
                        new MetalItem("18", "18", 2),
                        new MetalItem("20", "20", 2.47),
                        new MetalItem("22", "22", 2.98),
                        new MetalItem("25", "25", 3.85),
                        new MetalItem("28", "28", 4.83),
                        new MetalItem("32", "32", 6.31),
                        new MetalItem("36", "36", 7.99),
                        new MetalItem("40", "40", 9.87),
                        new MetalItem("45", "45", 12.48),
                        new MetalItem("50", "50", 15.41),
                        new MetalItem("55", "55", 18.65),
                        new MetalItem("60", "60", 22.19),
                        new MetalItem("70", "70", 30.21),
                        new MetalItem("80", "80", 39.46)
                };
        //endregion

        public static final String NAME = "Арматура";
        public static MetalItem[] getArmatura() {
            return armatura;
        }
    }

    public static class ListStalnoy{

        //region Лист стальной
        private static MetalItem[] listStalnoy =
                {
                        new MetalItem("0.35", "1000х2000", 5.50),
                        new MetalItem("0.35", "1250х2500", 8.59),
                        new MetalItem("0.4", "1000х2000", 6.28),
                        new MetalItem("0.4", "1250х2500", 9.81),
                        new MetalItem("0.45", "1000х2000", 7.07),
                        new MetalItem("0.45", "1250х2500", 11.04),
                        new MetalItem("0.5", "1000х2000", 7.85),
                        new MetalItem("0.5", "1250х2500", 12.27),
                        new MetalItem("0.55", "1000х2000", 8.64),
                        new MetalItem("0.55", "1250х2500", 13.49),
                        new MetalItem("0.6", "1000х2000", 9.42),
                        new MetalItem("0.6", "1250х2500", 14.72),
                        new MetalItem("0.65", "1000х2000", 10.21),
                        new MetalItem("0.65", "1250х2500", 15.95),
                        new MetalItem("0.7", "1000х2000", 10.99),
                        new MetalItem("0.7", "1250х2500", 17.17),
                        new MetalItem("0.75", "1000х2000", 11.78),
                        new MetalItem("0.75", "1250х2500", 18.40),
                        new MetalItem("0.8", "1000х2000", 12.56),
                        new MetalItem("0.8", "1250х2500", 19.63),
                        new MetalItem("0.9", "1000х2000", 14.13),
                        new MetalItem("0.9", "1250х2500", 22.08),
                        new MetalItem("1", "1000х2000", 15.70),
                        new MetalItem("1", "1250х2500", 24.53),
                        new MetalItem("1.2", "1000х2000", 18.84),
                        new MetalItem("1.2", "1250х2500", 29.44),
                        new MetalItem("1.4", "1000х2000", 21.98),
                        new MetalItem("1.4", "1250х2500", 34.34),
                        new MetalItem("1.5", "1000х2000", 23.55),
                        new MetalItem("1.5", "1250х2500", 36.80),
                        new MetalItem("1.6", "1000х2000", 25.12),
                        new MetalItem("1.6", "1250х2500", 39.25),
                        new MetalItem("1.7", "1000х2000", 26.69),
                        new MetalItem("1.7", "1250х2500", 41.70),
                        new MetalItem("1.8", "1000х2000", 28.26),
                        new MetalItem("1.8", "1250х2500", 44.16),
                        new MetalItem("1.9", "1000х2000", 29.83),
                        new MetalItem("1.9", "1250х2500", 46.61),
                        new MetalItem("2", "1000х2000", 31.40),
                        new MetalItem("2", "1250х2500", 49.06),
                        new MetalItem("2.2", "1000х2000", 34.54),
                        new MetalItem("2.2", "1250х2500", 53.97),
                        new MetalItem("2.5", "1000х2000", 39.25),
                        new MetalItem("2.5", "1250х2500", 61.33),
                        new MetalItem("2.8", "1000х2000", 43.96),
                        new MetalItem("2.8", "1250х2500", 68.69),
                        new MetalItem("3", "1000х2000", 47.10),
                        new MetalItem("3", "1250х2500", 73.59),
                        new MetalItem("3.5", "1250х2500", 85.86),
                        new MetalItem("4", "1500х6000", 282.60),
                        new MetalItem("5", "1500х6000", 353.25),
                        new MetalItem("6", "1500х6000", 423.90),
                        new MetalItem("7", "1500х6000", 494.55),
                        new MetalItem("8", "1500х6000", 565.20),
                        new MetalItem("9", "1500х6000", 635.85),
                        new MetalItem("10", "1500х6000", 706.50),
                        new MetalItem("12", "1500х6000", 847.80),
                        new MetalItem("14", "1500х6000", 989.10),
                        new MetalItem("16", "1500х6000", 1130.40),
                        new MetalItem("18", "1500х6000", 1271.70),
                        new MetalItem("20", "1500х6000", 1413.00),
                        new MetalItem("22", "1500х6000", 1554.30),
                        new MetalItem("25", "1500х6000", 1766.25),
                        new MetalItem("28", "1500х6000", 1978.20),
                        new MetalItem("30", "1500х6000", 2119.50),
                        new MetalItem("32", "1500х6000", 2260.80),
                        new MetalItem("35", "1500х6000", 2472.75),
                        new MetalItem("36", "1500х6000", 2543.40),
                        new MetalItem("40", "1500х6000", 2826.00),
                        new MetalItem("45", "1500х6000", 3179.25),
                        new MetalItem("50", "1500х6000", 3532.50),
                        new MetalItem("55", "1500х6000", 3885.75),
                        new MetalItem("60", "1500х6000", 4239.00),
                        new MetalItem("65", "1500х6000", 4592.25),
                        new MetalItem("70", "1500х6000", 4945.50),
                        new MetalItem("80", "1500х6000", 5652.00),
                        new MetalItem("90", "1500х6000", 6358.50),
                        new MetalItem("100", "1500х6000", 7065.00),
                        new MetalItem("110", "1500х6000", 7771.50),
                        new MetalItem("120", "1500х6000", 8478.00),
                        new MetalItem("130", "1500х6000", 9184.50),
                        new MetalItem("140", "1500х6000", 9891.00),
                        new MetalItem("150", "1500х6000", 10597.50),
                        new MetalItem("160", "1500х6000", 11304.00)
                };
        //endregion

        public static final String NAME = "Лист стальной";

        public static MetalItem[] getListStalnoy() {
            return listStalnoy;
        }
    }

    public static class ListOtsynkovany{
        //region Лист оцинкованный
        private static MetalItem[] listOtsynkovany = {
                new MetalItem("0.35", "1000х2000", 5.90),
                new MetalItem("0.35", "1250х2500", 9.22),
                new MetalItem("0.4", "1000х2000", 6.68),
                new MetalItem("0.4", "1250х2500", 10.44),
                new MetalItem("0.45", "1000х2000", 7.46),
                new MetalItem("0.45", "1250х2500", 11.66),
                new MetalItem("0.5", "1000х2000", 8.26),
                new MetalItem("0.5", "1250х2500", 12.91),
                new MetalItem("0.55", "1000х2000", 9.04),
                new MetalItem("0.55", "1250х2500", 14.13),
                new MetalItem("0.6", "1000х2000", 9.82),
                new MetalItem("0.6", "1250х2500", 15.34),
                new MetalItem("0.65", "1000х2000", 10.60),
                new MetalItem("0.65", "1250х2500", 16.56),
                new MetalItem("0.7", "1000х2000", 11.40),
                new MetalItem("0.7", "1250х2500", 17.81),
                new MetalItem("0.75", "1000х2000", 12.18),
                new MetalItem("0.75", "1250х2500", 19.03),
                new MetalItem("0.8", "1000х2000", 12.96),
                new MetalItem("0.8", "1250х2500", 20.25),
                new MetalItem("0.9", "1000х2000", 14.54),
                new MetalItem("0.9", "1250х2500", 22.72),
                new MetalItem("1", "1000х2000", 16.10),
                new MetalItem("1", "1250х2500", 25.16),
                new MetalItem("1.2", "1000х2000", 19.24),
                new MetalItem("1.2", "1250х2500", 30.06),
                new MetalItem("1.4", "1000х2000", 22.38),
                new MetalItem("1.4", "1250х2500", 34.97),
                new MetalItem("1.5", "1000х2000", 23.96),
                new MetalItem("1.5", "1250х2500", 37.44),
                new MetalItem("1.6", "1000х2000", 25.52),
                new MetalItem("1.6", "1250х2500", 39.88),
                new MetalItem("1.7", "1000х2000", 27.10),
                new MetalItem("1.7", "1250х2500", 42.34),
                new MetalItem("1.8", "1000х2000", 28.66),
                new MetalItem("1.8", "1250х2500", 44.78),
                new MetalItem("1.9", "1000х2000", 30.24),
                new MetalItem("1.9", "1250х2500", 47.25),
                new MetalItem("2", "1000х2000", 31.80),
                new MetalItem("2", "1250х2500", 49.69),
                new MetalItem("2.2", "1000х2000", 34.94),
                new MetalItem("2.2", "1250х2500", 54.59),
                new MetalItem("2.5", "1000х2000", 39.66),
                new MetalItem("2.5", "1250х2500", 61.97),
                new MetalItem("2.8", "1000х2000", 44.36),
                new MetalItem("2.8", "1250х2500", 69.31),
                new MetalItem("3", "1000х2000", 47.50),
                new MetalItem("3", "1250х2500", 74.22)
        };
        //endregion

        public static final String NAME = "Лист оцинкованный";

        public static MetalItem[] getListOtsynkovany() {
            return listOtsynkovany;
        }
    }

    public static class ListRifleny{
        //region Лист рифленый
        private static MetalItem[] listRifleny = {
                new MetalItem("2.5", "1250х2500", 62.8125),
                new MetalItem("3", "1250х2500", 75.625),
                new MetalItem("4", "1500х6000", 289.8),
                new MetalItem("5", "1500х6000", 364.5),
                new MetalItem("6", "1500х6000", 436.5),
                new MetalItem("8", "1500х6000", 584.1),
                new MetalItem("10", "1500х6000", 728.1),
                new MetalItem("12", "1500х6000", 871.2)
        };
        //endregion

        public static final String NAME = "Лист рифленый";

        public static MetalItem[] getListRifleny() {
            return listRifleny;
        }
    }

    public static class Krug{
        //region Круг
        private static MetalItem[] krug = {

                new MetalItem("5", "5", 0.154),
                new MetalItem("5.5", "5.5", 0.186),
                new MetalItem("6", "6", 0.222),
                new MetalItem("6.3", "6.3", 0.245),
                new MetalItem("6.5", "6.5", 0.260),
                new MetalItem("7", "7", 0.302),
                new MetalItem("8", "8", 0.395),
                new MetalItem("9", "9", 0.499),
                new MetalItem("10", "10", 0.616),
                new MetalItem("11", "11", 0.746),
                new MetalItem("12", "12", 0.888),
                new MetalItem("13", "13", 1.040),
                new MetalItem("14", "14", 1.210),
                new MetalItem("15", "15", 1.390),
                new MetalItem("16", "16", 1.580),
                new MetalItem("17", "17", 1.780),
                new MetalItem("18", "18", 2.000),
                new MetalItem("19", "19", 2.230),
                new MetalItem("20", "20", 2.470),
                new MetalItem("21", "21", 2.720),
                new MetalItem("22", "22", 2.980),
                new MetalItem("23", "23", 3.260),
                new MetalItem("24", "24", 3.550),
                new MetalItem("25", "25", 3.850),
                new MetalItem("26", "26", 4.170),
                new MetalItem("27", "27", 4.500),
                new MetalItem("28", "28", 4.830),
                new MetalItem("29", "29", 5.180),
                new MetalItem("30", "30", 5.550),
                new MetalItem("31", "31", 5.920),
                new MetalItem("32", "32", 6.310),
                new MetalItem("33", "33", 6.710),
                new MetalItem("34", "34", 7.130),
                new MetalItem("35", "35", 7.550),
                new MetalItem("36", "36", 7.990),
                new MetalItem("37", "37", 8.440),
                new MetalItem("38", "38", 8.900),
                new MetalItem("39", "39", 9.380),
                new MetalItem("40", "40", 9.860),
                new MetalItem("41", "41", 10.360),
                new MetalItem("42", "42", 10.880),
                new MetalItem("43", "43", 11.400),
                new MetalItem("44", "44", 11.940),
                new MetalItem("45", "45", 12.480),
                new MetalItem("46", "46", 13.050),
                new MetalItem("47", "47", 13.750),
                new MetalItem("48", "48", 14.200),
                new MetalItem("50", "50", 15.420),
                new MetalItem("52", "52", 16.670),
                new MetalItem("53", "53", 17.320),
                new MetalItem("54", "54", 17.650),
                new MetalItem("55", "55", 18.650),
                new MetalItem("56", "56", 19.330),
                new MetalItem("58", "58", 20.740),
                new MetalItem("60", "60", 22.190),
                new MetalItem("62", "62", 23.700),
                new MetalItem("63", "63", 24.470),
                new MetalItem("65", "65", 26.050),
                new MetalItem("67", "67", 27.680),
                new MetalItem("68", "68", 28.510),
                new MetalItem("70", "70", 30.210),
                new MetalItem("72", "72", 31.960),
                new MetalItem("75", "75", 34.680),
                new MetalItem("78", "78", 37.510),
                new MetalItem("80", "80", 39.460),
                new MetalItem("82", "82", 41.460),
                new MetalItem("85", "85", 44.540),
                new MetalItem("87", "87", 46.640),
                new MetalItem("90", "90", 49.940),
                new MetalItem("92", "92", 52.160),
                new MetalItem("95", "95", 55.640),
                new MetalItem("97", "97", 57.980),
                new MetalItem("100", "100", 61.650),
                new MetalItem("105", "105", 67.970),
                new MetalItem("110", "110", 74.600),
                new MetalItem("115", "115", 81.540),
                new MetalItem("120", "120", 88.780),
                new MetalItem("125", "125", 96.330),
                new MetalItem("130", "130", 104.200),
                new MetalItem("135", "135", 112.360),
                new MetalItem("140", "140", 120.840),
                new MetalItem("145", "145", 129.600),
                new MetalItem("150", "150", 138.720),
                new MetalItem("155", "155", 148.050),
                new MetalItem("160", "160", 157.830),
                new MetalItem("165", "165", 167.770),
                new MetalItem("170", "170", 178.180),
                new MetalItem("175", "175", 188.720),
                new MetalItem("180", "180", 199.760),
                new MetalItem("185", "185", 210.910),
                new MetalItem("190", "190", 222.570),
                new MetalItem("195", "195", 234.320),
                new MetalItem("200", "200", 246.620),
                new MetalItem("210", "210", 271.890),
                new MetalItem("220", "220", 298.400),
                new MetalItem("230", "230", 326.150),
                new MetalItem("240", "240", 355.130),
                new MetalItem("250", "250", 385.340),
                new MetalItem("260", "260", 416.570),
                new MetalItem("270", "270", 449.220),
                new MetalItem("280", "280", 483.120)

        };
//endregion

        public static final String NAME = "Круг";

        public static MetalItem[] getKrug() {
            return krug;
        }
    }

    public static class Kvadrat{

        //region Квадрат
        private static MetalItem[] kvadrat =
                {
                        new MetalItem("6", "6", 0.283),
                        new MetalItem("7", "7", 0.385),
                        new MetalItem("8", "8", 0.502),
                        new MetalItem("9", "9", 0.636),
                        new MetalItem("10", "10", 0.785),
                        new MetalItem("11", "11", 0.950),
                        new MetalItem("12", "12", 1.130),
                        new MetalItem("13", "13", 1.330),
                        new MetalItem("14", "14", 1.540),
                        new MetalItem("15", "15", 1.770),
                        new MetalItem("16", "16", 2.010),
                        new MetalItem("17", "17", 2.270),
                        new MetalItem("18", "18", 2.540),
                        new MetalItem("19", "19", 2.830),
                        new MetalItem("20", "20", 3.140),
                        new MetalItem("21", "21", 3.460),
                        new MetalItem("22", "22", 3.800),
                        new MetalItem("23", "23", 4.150),
                        new MetalItem("24", "24", 4.520),
                        new MetalItem("25", "25", 4.910),
                        new MetalItem("26", "26", 5.300),
                        new MetalItem("27", "27", 5.720),
                        new MetalItem("28", "28", 6.150),
                        new MetalItem("29", "29", 6.600),
                        new MetalItem("30", "30", 7.060),
                        new MetalItem("31", "31", 7.540),
                        new MetalItem("32", "32", 8.040),
                        new MetalItem("33", "33", 8.550),
                        new MetalItem("34", "34", 9.070),
                        new MetalItem("35", "35", 9.620),
                        new MetalItem("36", "36", 10.170),
                        new MetalItem("37", "37", 10.750),
                        new MetalItem("38", "38", 11.240),
                        new MetalItem("39", "39", 11.940),
                        new MetalItem("40", "40", 12.560),
                        new MetalItem("41", "41", 13.200),
                        new MetalItem("42", "42", 13.850),
                        new MetalItem("45", "45", 15.900),
                        new MetalItem("46", "46", 16.610),
                        new MetalItem("48", "48", 18.090),
                        new MetalItem("50", "50", 19.620),
                        new MetalItem("53", "53", 22.100),
                        new MetalItem("55", "55", 23.750),
                        new MetalItem("56", "56", 24.600),
                        new MetalItem("58", "58", 26.400),
                        new MetalItem("60", "60", 28.260),
                        new MetalItem("63", "63", 31.160),
                        new MetalItem("65", "65", 33.170),
                        new MetalItem("70", "70", 38.460),
                        new MetalItem("75", "75", 44.160),
                        new MetalItem("80", "80", 50.240),
                        new MetalItem("85", "85", 56.720),
                        new MetalItem("90", "90", 63.580),
                        new MetalItem("93", "93", 67.900),
                        new MetalItem("95", "95", 70.850),
                        new MetalItem("100", "100", 78.500),
                        new MetalItem("105", "105", 86.570),
                        new MetalItem("110", "110", 94.980),
                        new MetalItem("115", "115", 103.82),
                        new MetalItem("120", "120", 113.04),
                        new MetalItem("125", "125", 122.66),
                        new MetalItem("130", "130", 132.67),
                        new MetalItem("135", "135", 143.07),
                        new MetalItem("140", "140", 153.86),
                        new MetalItem("145", "145", 165.05),
                        new MetalItem("150", "150", 176.63),
                        new MetalItem("160", "160", 200.96),
                        new MetalItem("170", "170", 227.00),
                        new MetalItem("180", "180", 254.00),
                        new MetalItem("190", "190", 283.00),
                        new MetalItem("200", "200", 314.00)
                };
        //endregion

        public static final String NAME = "Квадрат";

        public static MetalItem[] getKvadrat() {
            return kvadrat;
        }
    }

    public static class TrubaKvadratnaya{
        //region Труба квадратная
        private static MetalItem[] trubaKvadratnaya = {

                new MetalItem("15x15х1.0", "15x15х1.0", 0.479),
                new MetalItem("15x15х1.2", "15x15х1.2", 0.501),
                new MetalItem("15x15х1.5", "15x15х1.5", 0.605),
                new MetalItem("20x20х1.2", "20x20х1.2", 0.689),
                new MetalItem("20x20х1.5", "20x20х1.5", 0.841),
                new MetalItem("20x20х2", "20x20х2", 1.08),
                new MetalItem("25x25х1.2", "25x25х1.2", 0.877),
                new MetalItem("25x25х1.5", "25x25х1.5", 1.07),
                new MetalItem("25x25х2", "25x25х2", 1.39),
                new MetalItem("30x30х1.5", "30x30х1.5", 1.31),
                new MetalItem("30x30х2", "30x30х2", 1.70),
                new MetalItem("40x40х1.5", "40x40х1.5", 1.78),
                new MetalItem("40x40х2", "40x40х2", 2.33),
                new MetalItem("40x40х2.5", "40x40х2.5", 2.85),
                new MetalItem("40x40х3", "40x40х3", 3.36),
                new MetalItem("40x40х4", "40x40х4", 4.30),
                new MetalItem("50x50х2.5", "50x50х2.5", 3.64),
                new MetalItem("50x50х3", "50x50х3", 4.31),
                new MetalItem("50x50х3.5", "50x50х3.5", 4.94),
                new MetalItem("50x50х4", "50x50х4", 5.56),
                new MetalItem("60x60х2", "60x60х2", 3.59),
                new MetalItem("60x60х2.5", "60x60х2.5", 4.43),
                new MetalItem("60x60х3", "60x60х3", 5.25),
                new MetalItem("60x60х3.5", "60x60х3.5", 6.04),
                new MetalItem("60x60х4", "60x60х4", 6.82),
                new MetalItem("80x80х3", "80x80х3", 7.13),
                new MetalItem("80x80х4", "80x80х4", 9.33),
                new MetalItem("80x80х5", "80x80х5", 11.44),
                new MetalItem("80x80х6", "80x80х6", 13.46),
                new MetalItem("100x100х3", "100x100х3", 9.02),
                new MetalItem("100x100х4", "100x100х4", 11.84),
                new MetalItem("100x100х5", "100x100х5", 14.58),
                new MetalItem("100x100х6", "100x100х6", 17.22),
                new MetalItem("100x100х7", "100x100х7", 17.3),
                new MetalItem("100x100х8", "100x100х8", 22.25),
                new MetalItem("120x120х4", "120x120х4", 14.35),
                new MetalItem("120x120х5", "120x120х5", 17.72),
                new MetalItem("120x120х6", "120x120х6", 20.99),
                new MetalItem("120x120х8", "120x120х8", 27.27),
                new MetalItem("140x140х5", "140x140х5", 20.86),
                new MetalItem("140x140х6", "140x140х6", 24.76),
                new MetalItem("150x150х5", "150x150х5", 22.43),
                new MetalItem("150x150х6", "150x150х6", 26.64),
                new MetalItem("150x150х8", "150x150х8", 34.81),
                new MetalItem("160x160х4", "160x160х4", 19.38),
                new MetalItem("160x160х5", "160x160х5", 24.00),
                new MetalItem("160x160х6", "160x160х6", 28.53),
                new MetalItem("160x160х8", "160x160х8", 37.32),
                new MetalItem("180x180х5", "180x180х5", 27.14),
                new MetalItem("180x180х6", "180x180х6", 32.30),
                new MetalItem("180x180х8", "180x180х8", 42.34),
                new MetalItem("180x180х10", "180x180х10", 52.03),
                new MetalItem("200x200х6", "200x200х6", 36.06),
                new MetalItem("200x200х8", "200x200х8", 47.37),
                new MetalItem("200x200х10", "200x200х10", 58.31),
                new MetalItem("200x200х12", "200x200х12", 68.89),
                new MetalItem("250x250х6", "250x250х6", 45.48),
                new MetalItem("250x250х8", "250x250х8", 59.93),
                new MetalItem("250x250х10", "250x250х10", 74.01),
                new MetalItem("250x250х12", "250x250х12", 87.73),
                new MetalItem("300x300х6", "300x300х6", 54.90),
                new MetalItem("300x300х8", "300x300х8", 72.49),
                new MetalItem("300x300х10", "300x300х10", 89.71),
                new MetalItem("300x300х12", "300x300х12", 106.6)

        };

        //endregion

        public static final String NAME = "Труба квадратная";

        public static MetalItem[] getTrubaKvadratnaya() {
            return trubaKvadratnaya;
        }
    }

    public static class TrubaPryamougolnaya{

        //region Труба прямоугольная

        private static MetalItem[] trubaPryamougolnaya = {

                new MetalItem("20x10x1.2 ", "20x10x1.2 ", 0.501),
                new MetalItem("20x10x1.5 ", "20x10x1.5 ", 0.605),
                new MetalItem("25x10x1.5 ", "25x10x1.5 ", 0.723),
                new MetalItem("28x25x1.2 ", "28x25x1.2 ", 0.934),
                new MetalItem("28x25x1.5 ", "28x25x1.5 ", 1.15),
                new MetalItem("28x25x2 ", "28x25x2 ", 1.48),
                new MetalItem("30x15x1.5 ", "30x15x1.5 ", 0.959),
                new MetalItem("30x20x1.5 ", "30x20x1.5 ", 1.08),
                new MetalItem("30x20x2", "30x20x2", 1.39),
                new MetalItem("40x20x1.5", "40x20x1.5", 1.31),
                new MetalItem("40x20x2", "40x20x2", 1.70),
                new MetalItem("40x25x1.5", "40x25x1.5", 1.43),
                new MetalItem("40x25x2", "40x25x2", 1.86),
                new MetalItem("40x25x2.5", "40x25x2.5", 2.27),
                new MetalItem("50x25x1.5", "50x25x1.5", 1.67),
                new MetalItem("50x20x2", "50x20x2", 2.02),
                new MetalItem("50x25x2", "50x25x2", 2.17),
                new MetalItem("50x30x2", "50x30x2", 2.32),
                new MetalItem("50x30x2.5", "50x30x2.5", 2.86),
                new MetalItem("50x40x2.0", "50x40x2.0", 2.65),
                new MetalItem("50x40x2.5", "50x40x2.5", 3.25),
                new MetalItem("50x40x3.5", "50x40x3.5", 4.39),
                new MetalItem("60x30x2", "60x30x2", 2.65),
                new MetalItem("60x30x2.5", "60x30x2.5", 3.25),
                new MetalItem("60x30x3", "60x30x3", 3.83),
                new MetalItem("60x40x2", "60x40x2", 2.96),
                new MetalItem("60x40x3", "60x40x3", 4.30),
                new MetalItem("60x40x3.5", "60x40x3.5", 4.94),
                new MetalItem("60x40x4", "60x40x4", 5.56),
                new MetalItem("80x40x2", "80x40x2", 3.59),
                new MetalItem("80x40x2.5", "80x40x2.5", 4.43),
                new MetalItem("80x40x3", "80x40x3", 5.25),
                new MetalItem("80x40x4", "80x40x4", 6.82),
                new MetalItem("80x60x3", "80x60x3", 6.19),
                new MetalItem("80x60x4", "80x60x4", 8.07),
                new MetalItem("100x50x3", "100x50x3", 6.66),
                new MetalItem("100x50x4", "100x50x4", 8.70),
                new MetalItem("100x50x5", "100x50x5", 10.65),
                new MetalItem("100x60x3", "100x60x3", 7.13),
                new MetalItem("100x60x4", "100x60x4", 9.33),
                new MetalItem("100x60x5", "100x60x5", 11.44),
                new MetalItem("100x80x4", "100x80x4", 10.59),
                new MetalItem("100x80x5", "100x80x5", 13.01),
                new MetalItem("120x60x3", "120x60x3", 8.07),
                new MetalItem("120x60x4", "120x60x4", 10.59),
                new MetalItem("120x60x5", "120x60x5", 13.00),
                new MetalItem("120x80x4", "120x80x4", 11.84),
                new MetalItem("120x80x5", "120x80x5", 13.01),
                new MetalItem("120x80x6", "120x80x6", 17.22),
                new MetalItem("140x60x4", "140x60x4", 11.84),
                new MetalItem("140x60x5", "140x60x5", 14.58),
                new MetalItem("140x100x4", "140x100x4", 14.35),
                new MetalItem("140x100x5", "140x100x5", 17.72),
                new MetalItem("140x100x6", "140x100x6", 20.99),
                new MetalItem("150x100x5", "150x100x5", 18.50),
                new MetalItem("150x100x6", "150x100x6", 21.93),
                new MetalItem("150x100x8", "150x100x8", 28.53),
                new MetalItem("160x80x5", "160x80x5", 17.72),
                new MetalItem("160x120x5", "160x120x5", 20.86),
                new MetalItem("160x120x6", "160x120x6", 24.76),
                new MetalItem("180x100x6", "180x100x6", 24.76),
                new MetalItem("180x100x8", "180x100x8", 32.29),
                new MetalItem("200x120x5", "200x120x5", 24.00),
                new MetalItem("200x120x6", "200x120x6", 28.53),
                new MetalItem("200x160x5", "200x160x5", 27.14),
                new MetalItem("200x160x6", "200x160x6", 32.30),
                new MetalItem("230x160x8", "230x160x8", 46.11)


        };

        //endregion

        public static final String NAME = "Труба прямоугольная";

        public static MetalItem[] getTrubaPryamougolnaya() {
            return trubaPryamougolnaya;
        }
    }



}
