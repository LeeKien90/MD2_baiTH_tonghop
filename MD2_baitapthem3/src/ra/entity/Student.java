package ra.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudentManagement {
    private String studentId;
    private String studentName;
    private int age;
    private Boolean sex;
    private StudentClass classStudent;
    private List<Float> listMarkJavaScript = new ArrayList<>();
    private List<Float> listMarkJavaCore = new LinkedList<>();
    private List<Float> listMarkJavaWeb = new ArrayList<>();
    private float avgMark;
    private String gpa;
    private Boolean studentStatus;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, Boolean sex, StudentClass classStudent, List<Float> listMarkJavaScript, List<Float> listMarkJavaCore, List<Float> listMarkWeb, float avgMark, String gpa, Boolean studentStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.classStudent = classStudent;
        this.listMarkJavaScript = listMarkJavaScript;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaWeb = listMarkWeb;
        this.avgMark = avgMark;
        this.gpa = gpa;
        this.studentStatus = studentStatus;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public StudentClass getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(StudentClass classStudent) {
        this.classStudent = classStudent;
    }

    public List<Float> getListMarkJavaScript() {
        return listMarkJavaScript;
    }

    public void setListMarkJavaScript(List<Float> listMarkJavaScript) {
        this.listMarkJavaScript = listMarkJavaScript;
    }

    public List<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(List<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public List<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(List<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public Boolean getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(Boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhap ma sinh vien");
        do {
            this.studentId =sc.nextLine();
            if (this.studentId.trim().length() == 6){
                if (this.studentId.trim().charAt(0) == 'S'){
                    break;
                }else {
                    System.out.println("Vui long nhap ma sinh vien bat dau bang ky tu S");
                }
            }else {
                System.out.println("Vui long nhap ma sinh vien gom 6 ky tu");
            }
        }while (true);
        System.out.println("Nhap vao ten sinh vien");
        do {
            this.studentName = sc.nextLine();
            if (this.studentName.trim().length()>=6 && this.studentName.trim().length()<=50){
                break;
            }else {
                System.out.println("Vui long nhap ten sinh vien tu 6 den 50 ky tu");
            }
        }while (true);
        System.out.println("Nhap vao tuoi sinh vien");
        do {
            this.age = Integer.parseInt(sc.nextLine());
            if (this.age >=18){
                break;
            }else {
                System.out.println("Vui long nhap tuoi sinh vien lop hon hoac bang 18 tuoi");
            }
        }while (true);
        System.out.println("Nhap vao gioi tinh sinh vien");
        this.sex = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Nhap cac diem thi JavaScript: ");
        inputMark(listMarkJavaScript, sc);
        System.out.println("Nhap cac diem thi JavaCore: ");
        inputMark(listMarkJavaCore,sc);
        System.out.println("Nhap cac diem thi JavaWeb: ");
        inputMark(listMarkJavaWeb,sc);
        System.out.println("Nhap vao trang thai sinh vien");
        this.studentStatus = Boolean.parseBoolean(sc.nextLine());

    }

    public static void inputMark(List<Float> listMark, Scanner sc){
        int cnt = listMark.size()+1;
        do {
            System.out.printf("Nhap diem thi lan %d: \n", cnt);
            listMark.add(Float.parseFloat(sc.nextLine()));
            cnt++;
            System.out.printf("Ban co muon nhap diem thi lan %d khoong \n", cnt);
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("Lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice != 1){
                break;
            }
        }while (true);
    }
    @Override
    public void displayData() {
        System.out.printf("Mã SV: %s - Tên SV: %s - Tuổi: %d - Giới tính: %b - Lớp: %s\n",
                this.studentId,this.studentName,this.age,this.sex,this.classStudent.getClassName());
        System.out.printf("Điểm JavaScript: ");
        for (Float js_mark : listMarkJavaScript) {
            System.out.printf("%f\t", js_mark);
        }
        System.out.printf("\n");
        System.out.printf("Điểm JavaCore: ");
        for (Float js_mark : listMarkJavaCore) {
            System.out.printf("%f\t", js_mark);
        }
        System.out.printf("\n");
        System.out.printf("Điểm JavaWeb: ");
        for (Float js_mark : listMarkJavaWeb) {
            System.out.printf("%f\t", js_mark);
        }
        System.out.printf("\n");
        System.out.printf("Diem TB: %f - Xep loai: %s - Trang thai: %b\n", this.avgMark, this.gpa, this.studentStatus);
    }
    public void calAvgMark() {
        this.avgMark = (listMarkJavaScript.get(listMarkJavaScript.size() - 1) +
                listMarkJavaCore.get(listMarkJavaCore.size() - 1) +
                listMarkJavaWeb.get(listMarkJavaWeb.size() - 1)) / 3;
    }
    public void getGPA(){
        if (this.avgMark<5){
            this.gpa="Yeu";
        }else if(this.avgMark<7){
            this.gpa = "Trung binh";
        }else if(this.avgMark<9){
            this.gpa = "Kha";
        }else {
            this.gpa = "Gioi";
        }
    }
}
