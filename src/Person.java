import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 3487495895819393L;

    private String surname;

    private String name;

    private String patronymic;

    private Integer index;

    public Person (String surname, String name, String patronymic, Integer index) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.index = index;
    }

    public String getSurname () {
        return surname;
    }

    public void setSurname (String surname) {
        this.surname = surname;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPatronymic () {
        return patronymic;
    }

    public void setPatronymic (String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getIndex () {
        return index;
    }

    public void setIndex (Integer index) {
        this.index = index;
    }

    @Override
    public String toString () {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", index=" + index +
                '}';
    }
}
