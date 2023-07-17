public class Netbook {
    String name;

    String articl;
    Integer ozu;
    Integer hardDisk;
    String os;
    String color;


    public Integer getOzu() {
        return ozu;
    }

    public Netbook(String articl, String name, Integer ozu, Integer hardDisk, String os, String color) {
        this.articl = articl;
        this.name = name;
        this.ozu = ozu;
        this.hardDisk = hardDisk;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Артикул: " + articl+
                " Название: " + name +
                " Цвет: " + color +
                " Операционная система: " + os+
                " Объем ЖД: "+hardDisk+
                " ОЗУ: " + ozu;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + 21 * os.hashCode() + 7 * ozu.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Netbook)){
            return false;
        }
        Netbook netbook = (Netbook) obj;
        return articl.equalsIgnoreCase(netbook.articl) && name.equalsIgnoreCase(netbook.name) &&
                os.equalsIgnoreCase(netbook.os) && ozu == netbook.ozu;
    }


}
