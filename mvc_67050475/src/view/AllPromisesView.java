package view;

import model.Promise;
import java.util.List;

public class AllPromisesView {
    public void display(List<Promise> promises) {
        System.out.println("\n=== รายการคำสัญญาทั้งหมด ===");
        System.out.println(String.format("%-6s | %-12s | %-30s | %-10s", "ID", "วันที่", "รายละเอียด", "สถานะ"));
        for (Promise p : promises) {
            System.out.printf("%-6s | %-12s | %-30s | %-10s\n", p.getPromiseId(), p.getDate(), p.getDetail(), p.getStatus());
        }
        System.out.println("============================");
    }
}