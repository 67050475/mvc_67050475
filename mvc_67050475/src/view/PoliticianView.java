package view;

import model.Promise;
import model.Politician;
import java.util.List;

public class PoliticianView {
    public void display(List<Politician> politicians, List<Promise> allPromises) {
        System.out.println("\n=== รายชื่อนักการเมืองและคำสัญญา ===");
        
        for (Politician pol : politicians) {
            System.out.println("------------------------------------------------");
            System.out.println("ชื่อ: " + pol.getName() + " (" + pol.getParty() + ")");
            System.out.println("คำสัญญาที่ให้ไว้:");
            boolean found = false;

            for (Promise p : allPromises) {
                if (p.getPoliticianId().equals(pol.getId())) {
                    System.out.println("   - [" + p.getStatus() + "] " + p.getDetail() + " (วันที่: " + p.getDate() + ")");
                    found = true;
                }
            }
            
            if (!found) {
                System.out.println("   (ไม่มีข้อมูลคำสัญญา)");
            }
        }
        System.out.println("------------------------------------------------");
    }
}
