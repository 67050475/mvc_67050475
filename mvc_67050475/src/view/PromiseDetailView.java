package view;

import model.Promise;
import model.PromiseUpdate;
import java.util.List;

public class PromiseDetailView {
    public void display(Promise p, String politicianName, List<PromiseUpdate> updates) {
        System.out.println("\n=== รายละเอียดคำสัญญา ===");
        System.out.println("รหัส: " + p.getPromiseId());
        System.out.println("หัวข้อ: " + p.getDetail());
        System.out.println("ผู้สัญญา: " + politicianName);
        System.out.println("สถานะปัจจุบัน: " + p.getStatus());
        System.out.println("--- ประวัติความคืบหน้า ---");
        if (updates.isEmpty()) {
            System.out.println("- ยังไม่มีความคืบหน้า");
        } else {
            for (PromiseUpdate u : updates) {
                System.out.println("- " + u.getDate() + ": " + u.getDetail());
            }
        }
        System.out.println("=========================");
    }
}