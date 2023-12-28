package kakao.project.student;

public class Student {

    private int ID;
    private String name;
    private String Sex;
    private int PresentTableNumber;

    public Student() {
        ID = 0;
        name = null;
        Sex = null;
        PresentTableNumber = 0;
    }

    Student(int nID, String nName, String nSex) {
        ID = nID;
        name = nName;
        Sex = nSex;
    }

    Student(int nID, String nName, String nSex, int nPresentTableNumber) {
        ID = nID;
        name = nName;
        Sex = nSex;
        PresentTableNumber = nPresentTableNumber;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        this.Sex = sex;
    }

    public int getPresnetTableNumber() {
        return PresentTableNumber;
    }

    public void setPresentTableNumber(int PresentTableNumber) {
        this.PresentTableNumber = PresentTableNumber;
    }

}
//占쏙옙占쏙옙占쏙옙占�
//�씡�옱 留λ턿 �뀒�뒪
//민혁쓰
//민혁 맥
