import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        
        controller.loadData(); 
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== ระบบติดตามคำสัญญานักการเมือง ===");
        System.out.print("Login As (admin/guest): ");
        String role = sc.nextLine();
        
        while(true) {
            System.out.println("\n=== เมนูหลัก (" + role + ") ===");
            System.out.println("1. ดูคำสัญญาทั้งหมด (Promise List)");
            System.out.println("2. ดูรายละเอียดและอัปเดต (Detail & Update)");
            System.out.println("3. ดูรายชื่อนักการเมือง (Politician List)");
            System.out.println("0. ออกจากระบบ (Exit)");
            System.out.print("เลือกข้อ: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                controller.showAllPromises();
            } 
            
            else if (choice.equals("2")) {
                System.out.print("ใส่รหัสคำสัญญา (เช่น P001): ");
                String pid = sc.nextLine();
                controller.selectPromise(pid, role);
            } 
            
            else if (choice.equals("3")) {
                controller.showPoliticians();
            } 
            
            else if (choice.equals("0")) {
                System.out.println("จบการทำงาน");
                break;
            } 
            
            else {
                System.out.println("เลือกผิด กรุณาเลือกใหม่");
            }
        }
    }
}