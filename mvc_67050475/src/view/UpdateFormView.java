package view;

import java.util.Scanner;

public class UpdateFormView {
    public String[] getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- ฟอร์มบันทึกความคืบหน้า ---");
        
        System.out.print("1. ใส่วันที่ (YYYY-MM-DD): ");
        String date = sc.nextLine();
        
        System.out.print("2. รายละเอียดความคืบหน้า: ");
        String detail = sc.nextLine();
        
        System.out.print("3. สถานะล่าสุด (InProgress/Lost): ");
        String status = sc.nextLine();
        
        return new String[]{date, detail, status};
    }
    
    public boolean confirmUpdate() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ต้องการอัปเดตข้อมูลนี้ใช่หรือไม่? (y/n): ");
        String confirm = sc.nextLine();
        return confirm.equalsIgnoreCase("y");
    }

    public void showError(String message) {
        System.out.println("!!! Error: " + message);
    }
    
    public void showSuccess() {
        System.out.println("บันทึกข้อมูลเรียบร้อย!");
    }
}