package ra.entity;

import java.util.Scanner;

public class StudentClass implements IStudentManagement{
    private String classId;
    private String className;
    private String  descriptions;
    private int classStatus;

    public StudentClass() {
    }

    public StudentClass(String classId, String className, String descriptions, int classStatus) {
        this.classId = classId;
        this.className = className;
        this.descriptions = descriptions;
        this.classStatus = classStatus;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }


    @Override
    public void inputData(Scanner sc) {
        System.out.println("nhap vao ma lop");
        do {
            this.classId = sc.nextLine();
            if (this.classId.trim().length()==5){
                if (this.classId.charAt(0)=='J'){
                    break;
                }else {
                    System.out.println("vui long nhap ma lop bat dau bang ky tu J");
                }
            }else {
                System.out.println("vui long nhap ma gom 5 ky tu");
            }
        }while (true);
//        char result = this.classId.charAt(0);
//        while (this.classId.trim().length() != 5 && result != 'J'){
//            System.out.println("Ma lop bat dau bang 'J' va bao gom 5 ky tu");
//            this.classId = sc.nextLine();
//        }

        System.out.println("Ten lop");
        do {
            this.className =sc.nextLine();
            if (this.className.trim().length() <=10){
                break;
            }else {
                System.out.println("vui long nhap ten lop toi da 10 ky tu");
            }
        }  while (true);
//        while (this.className.trim().length() <= 10){
//            System.out.println("Ten lop toi da 10 ky tu");
//            this.className = sc.nextLine();
//        }
        System.out.println("Mo ta lop");
        this.descriptions = sc.nextLine();
        System.out.println("Trang thai lop");
        this.classStatus = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Ma lop: %s - Ten lop: %s - Mo ta lop: %s - Trang thai lop: %d\n",
                this.classId, this.className,this.descriptions,this.classStatus);
    }
}
