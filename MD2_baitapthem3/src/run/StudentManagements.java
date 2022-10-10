package run;

import ra.entity.Student;
import ra.entity.StudentClass;

import java.util.*;

public class StudentManagements {
    static List<StudentClass> listClass = new ArrayList<>();
    static List<Student> listStudent = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-----------STUDENTCLASS---------");
            System.out.println("1. Quan ly lop");
            System.out.println("2. Quan ly sinh vien");
            System.out.println("3. Thoat");
            System.out.println("Lua chon");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    StudentManagements.ManagementClass(sc);
                    break;
                case 2:
                    StudentManagements.StudentManagement(sc);
                    break;
                case 3:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1-3");
                    break;
            }
        } while (true);
    }

    public static void ManagementClass(Scanner sc) {
        boolean exitManagementClass = true;
        do {
            System.out.println("***************Quản lý Lớp Học*************");
            System.out.println("1. Thêm mới lớp học");
            System.out.println("2. Cập nhật thông tin lớp học");
            System.out.println("3.  Hiển thị thông tin lớp học");
            System.out.println("4. Thống kê các lớp học đang hoạt động (ClassStatus = true)");
            System.out.println("5. Tìm kiếm lớp học theo tên lớp học");
            System.out.println("6. Thoát");
            int choiceClass = Integer.parseInt(sc.nextLine());
            switch (choiceClass) {
                case 1:
                    StudentManagements.inputListClass(sc);
                    break;
                case 2:
                    StudentManagements.updateClass(sc);
                    break;
                case 3:
                    StudentManagements.displayListClass();
                    break;
                case 4:
                    StudentManagements.getClassAtive();
                    break;
                case 5:
                    StudentManagements.seachClassByName(sc);
                    break;
                case 6:
                    exitManagementClass = false;
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1-6");
            }
        } while (exitManagementClass);
    }
    public static void inputListClass(Scanner sc) {
        System.out.println("Nhap vao so lop nhap thong tin: ");
        int countClass = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < countClass; i++) {
            //Nhap thong tin cho tung lop
            StudentClass studentClassNew = new StudentClass();
            studentClassNew.inputData(sc);
            //add vao danh sach lop
            listClass.add(studentClassNew);
        }
    }
    public static void updateClass(Scanner sc) {
        System.out.println("Nhap vao ma lop can cap nhat thong tin: ");
        String classId = sc.nextLine();
        //Kiem tra ma lop co ton tai trong danh sach khong? co --> cap nhat
        boolean existClass = false;
        for (StudentClass studentClass : listClass) {
            if (studentClass.getClassId().equals(classId)) {
                //Ton tai lop trong danh sach --> cap nhat
                System.out.println("Nhap vao ten lop can cap nhat: ");
                String className = sc.nextLine();
                if (className != "" && className.length() != 0) {
                    //Cap nhat ten lop
                    studentClass.setClassName(className);
                }
                System.out.println("Nhap vao mo ta lop can cap nhat: ");
                String description = sc.nextLine();
                if (description != "" && description.length() != 0) {
                    studentClass.setDescriptions(description);
                }
                System.out.println("Nhap vao trang thai lop can cap nhat: ");
                String classStatus = sc.nextLine();
                if (classStatus != "" && classStatus.length() != 0) {
                    studentClass.setClassStatus(Integer.parseInt(classStatus));
                }
                existClass = true;
                break;
            }
        }
        if (!existClass) {
            System.out.println("Khong ton tai lop co ma lop nhu vay");
        }
    }

    public static void displayListClass(){
        System.out.println("Thông tin danh sách lớp học: ");
            for (StudentClass studentClass : listClass) {
                studentClass.displayData();
            }
    }

    public static void getClassAtive(){
        System.out.println("Damh sách các lớp học đang hoạt động: ");
        int countClassAtive = 0;
        for (StudentClass studentClass : listClass) {
            if (studentClass.getClassStatus() == 0) {
                studentClass.displayData();
                countClassAtive++;
            }
        }
        System.out.printf("Co %d lop dang hoat dong\n", countClassAtive);
    }

    public static void seachClassByName(Scanner sc){
        System.out.println("Nhập vào lớp hoc cần tìm kiếm: ");
        String classNameSeach = sc.nextLine();
        boolean existClass = false;
        for (StudentClass studentClass : listClass) {
            if (studentClass.getClassName().contains(classNameSeach)) {
                studentClass.displayData();
                existClass = true;
            }
        }
        if (!existClass) {
            System.out.println("Khong ton tai tên lop");
        }
    }

    public static void StudentManagement(Scanner sc) {
        boolean studentExit = true;
        do {
            System.out.println("*****************QUAN LY SINH VIEN****************");
            System.out.println("1. Them moi sinh vien");
            System.out.println("2. Cap nhat thong tin sinh vien");
            System.out.println("3. Hien thi thong tin sinh vien");
            System.out.println("4. Tinh diem trung binh");
            System.out.println("5. Xep loai sinh vien");
            System.out.println("6. Sap xep sinh vien theo diem trung binh tang dan");
            System.out.println("7. Tim kiem sinh vien theo ten sinh vien:");
            System.out.println("8. Thong ke sinh vien dat gioi, kha, trung binh, yeu");
            System.out.println("9. Thong ke cac sinh vien pass qua cac mon hoc");
            System.out.println("10. Thoat");
            System.out.print("Su lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    StudentManagements.inputListStudent(sc);
                    break;
                case 2:
                    StudentManagements.updateStudent(sc);
                    break;
                case 3:
                    StudentManagements.displayListStudent();
                    break;
                case 4:
                    StudentManagements.calAvgMarkListStudent();
                    break;
                case 5:
                    StudentManagements.classtifyStudent();
                    break;
                case 6:
                    StudentManagements.sortStudentByAvgMarkASC();
                    break;
                case 7:
                    StudentManagements.seachStudentByStudentName(sc);
                    break;
                case 8:
                    StudentManagements.getStatisticStudent();
                    break;
                case 9:
                    StudentManagements.getStaticticsAvgMark();
                    break;
                case 10:
                    studentExit = false;
                    break;
                default:
                    System.err.println("Vui long chon tu 1-6");
            }
        } while (studentExit);
    }

    public static void inputListStudent(Scanner sc){
        System.out.println("Nhap vao so sinh vien can nhap thong tin");
        int cnt = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cnt; i++) {
//            Nhap thong tin 1 sinh vien
            Student studentNew = new Student();
            studentNew.inputData(sc);
//            Nhap thong tin lop sinh vien
            System.out.println("Chon lop hoc cho sinh vien");
            int index = 1;
            for (StudentClass stClass: listClass) {
                System.out.printf("%d.%s\n", index, stClass.getClassName());
                index++;
            }
            System.out.println("Su lua chon cua ban");
            int choice = Integer.parseInt(sc.nextLine());
//            Gan vao cho thuoc tinh studentClass cua doi tuong studentNew
            studentNew.setClassStudent(listClass.get(choice - 1));
//            add vao listStudent
            listStudent.add(studentNew);
        }
    }
    public static void updateStudent(Scanner sc) {
        System.out.println("Nhap vao ma sinh vien can cap nhap thong tin: ");
        String studentUpdate = sc.nextLine();
        for (Student student : listStudent) {
            if (student.getStudentId().equals(studentUpdate)){
//                Cap nhap thong tin sinh vien
                System.out.println("Nhap vao ten sinh vien can cap nhap: ");
                String studentName = "";
                do {
                    studentName = sc.nextLine();
                    if (studentName != "" && studentName.length() != 0){
                        if (studentName.length() >= 6 && studentName.length() <= 50) {
                            student.setStudentName(studentName);
                            break;
                        }
                    }
                } while (true);
                System.out.println("Nhap vao tuoi sinh vien can cap nhap: ");
                String age = "";
                do {
                    age = sc.nextLine();
                    if (age != "" && age.length() != 0){
                        if (Integer.parseInt(age) >= 18) {
                            student.setAge(Integer.parseInt(age));
                            break;
                        } else {
                            System.out.println("Nhap tuoi sinh vien tren 18 tuoi");
                        }
                    }
                }while (true);
                System.out.println("Nhap vao gioi tinh can cap nhap");
                String sex = sc.nextLine();
                if (sex != "" && sex.length() != 0);
                student.setSex(Boolean.parseBoolean(sex));
            }
//          Cap nhap lop cho sinh vien
            System.out.println("Chon lop sinh vien");
            int cntClass = 1;
            for (StudentClass studentClass : listClass) {
                System.out.printf("%d. %s\n", cntClass, studentClass.getClassName());
                cntClass++;
            }
            System.out.printf("%d. Khong cap nhat lop\n", cntClass);
            System.out.print("Su lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice != cntClass) {
                //Cap nhat lop cho sinh vien
                student.setClassStudent(listClass.get(choice - 1));
            }
//            Cap nhap cac diem cho sinh vien
            StudentManagements.updateStudentMark(student.getListMarkJavaScript(), sc, student, "JavaScript");
            StudentManagements.updateStudentMark(student.getListMarkJavaCore(),sc,student,"JavaCore");
            StudentManagements.updateStudentMark(student.getListMarkJavaWeb(),sc,student,"JavaWeb");
//            Tinh lai diem trung binh cua sinh vien
            student.getAvgMark();
//            Xep loai lai cho sinh vien
            student.getGPA();
//            Cap nhap trang thai sinh vien
            System.out.println("Nhap vao trang thai sinh vien can cap nhap: ");
            String studentStatus = sc.nextLine();
            if (studentStatus != "" && studentStatus.length()    != 0) {
                student.setStudentStatus(Boolean.parseBoolean(studentStatus));
            }
        }
    }
    public static void updateStudentMark(List<Float> listMark, Scanner sc, Student student, String subject) {
        System.out.printf("Cap nhat diem %s cho sinh vien: \n", subject);
        System.out.println("1. Nhap moi diem cho sinh vien");
        System.out.println("2. Them moi diem cho sinh vien");
        System.out.println("3. Cap nhat 1 diem trong danh sach");
        System.out.println("4. Khong cap nhat");
        System.out.print("Lua chon cua ban: ");
        int choiceJS = Integer.parseInt(sc.nextLine());
        switch (choiceJS) {
            case 1:
                List<Float> listJS = new ArrayList<>();
                Student.inputMark(listJS, sc);
                student.setListMarkJavaScript(listJS);
                break;
            case 2:
                Student.inputMark(student.getListMarkJavaScript(), sc);
                break;
            case 3:
                System.out.println("Nhap vao lan thi muon cap nhat: ");
                int examTimes = Integer.parseInt(sc.nextLine());
                System.out.println("Nhap vao diem thi cap nhat:");
                float mark = Float.parseFloat(sc.nextLine());
                //Cap nhat
                student.getListMarkJavaScript().set(examTimes - 1, mark);
                break;
        }
    }
    public static void displayListStudent(){
        System.out.println("Thong tin danh sach sinh vien");
        for (Student student : listStudent) {
            student.displayData();
        }
    }
    public static void calAvgMarkListStudent(){
        for (Student student : listStudent) {
            student.calAvgMark();
        }
        System.out.println("Da tinh diem trung binh cho sinh vien");
    }
    public static void classtifyStudent(){
        for (Student student : listStudent) {
            student.getGPA();
        }
        System.out.println("Da xep loai cho tat ca sinh vien");
    }
    public static void sortStudentByAvgMarkASC(){
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        });
    }
    public static void seachStudentByStudentName(Scanner sc){
        System.out.println("Nhap vao ten sinh vien can tim");
        String studentNameSearch = sc.nextLine();
        boolean exitStudent = false;
        for (Student student : listStudent) {
            if (student.getStudentName().contains(studentNameSearch)) {
                student.displayData();
                exitStudent = true;
            }
        }
        if (!exitStudent) {
            System.out.println("Khong tim thay sinh vien nao co ten nhu vay");
        }
    }
    public static void getStatisticStudent() {
        int cntExellent = 0, cntGood = 0, cntAvegage = 0, cntWeek = 0;
        for (Student student : listStudent) {
            if (student.getAvgMark() < 5) {
                cntWeek++;
            } else if (student.getAvgMark() < 7) {
                cntAvegage++;
            } else if (student.getAvgMark() < 9) {
                cntGood++;
            } else {
                cntExellent++;
            }
        }
        System.out.printf("So sinh vien gioi: %d - Kha: %d - Trung binh: %d - Yeu: %d\n", cntExellent, cntGood, cntAvegage, cntWeek);
    }
    public static void getStaticticsAvgMark() {
        int cntPass = 0;
        for (Student student : listStudent) {
            int jsSize = student.getListMarkJavaScript().size();
            int jcSize = student.getListMarkJavaCore().size();
            int jwSize = student.getListMarkJavaWeb().size();
            if (student.getAvgMark() >= 5 && student.getListMarkJavaScript().get(jsSize-1)>=5
            && student.getListMarkJavaCore().get(jcSize-1)>=5&&student.getListMarkJavaWeb().get(jwSize-1)>=5){
                cntPass++;
            }
        }
        System.out.printf("Co %d sinh vien Pass \n", cntPass);
    }
}

