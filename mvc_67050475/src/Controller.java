import model.*;
import view.*;

import java.util.*;

public class Controller {
    List<Politician> politicians = new ArrayList<>();
    List<Promise> promises = new ArrayList<>();
    List<PromiseUpdate> updates = new ArrayList<>();

    AllPromisesView viewAll = new AllPromisesView();
    PromiseDetailView viewDetail = new PromiseDetailView();
    PoliticianView viewPol = new PoliticianView();
    UpdateFormView viewUpdate = new UpdateFormView();

    public void loadData() {
        List<String[]> polData = DataManager.readCSV("politicians.csv");
        for (String[] row : polData) {
            if(row.length >= 3) politicians.add(new Politician(row[0], row[1], row[2]));
        }
        
        List<String[]> promData = DataManager.readCSV("promises.csv");
        for (String[] row : promData) {
            if(row.length >= 5) promises.add(new Promise(row[0], row[1], row[2], row[3], row[4]));
        }

        List<String[]> updData = DataManager.readCSV("promise_updates.csv");
        for (String[] row : updData) {
            if(row.length >= 3) updates.add(new PromiseUpdate(row[0], row[1], row[2]));
        }
        
        promises.sort(Comparator.comparing(p -> p.getDate()));
    }

    public void showAllPromises() {
        viewAll.display(promises);
    }

    public void showPoliticians() {
        viewPol.display(politicians, promises);
    }

    public void selectPromise(String promiseId, String userRole) {
        Promise p = null;
        for(Promise promo : promises) {
            if(promo.getPromiseId().equals(promiseId)) {
                p = promo;
                break;
            }
        }

        if (p == null) { 
            System.out.println("ไม่พบรหัสคำสัญญานี้"); 
            return; 
        }

        String polName = "ไม่ระบุ";
        for(Politician pol : politicians) {
            if(pol.getId().equals(p.getPoliticianId())) {
                polName = pol.getName();
                break;
            }
        }
        
        List<PromiseUpdate> history = new ArrayList<>();
        for(PromiseUpdate u : updates) {
            if(u.getPromiseId().equals(p.getPromiseId())) {
                history.add(u);
            }
        }

        viewDetail.display(p, polName, history);

        if (userRole.equalsIgnoreCase("admin")) {
            updateProcess(p);
        }
    }

    public void updateProcess(Promise p) {
        if (p.getStatus().equalsIgnoreCase("Lost")) {
            viewUpdate.showError("ʶสถานะ 'เงียบหาย' ไม่สามารถอัปเดตได้ตามกฎข้อบังคับ");
            return;
        }

        if (viewUpdate.confirmUpdate()) {
            String[] inputs = viewUpdate.getInput(); 
            String newDate = inputs[0];
            String newDetail = inputs[1];
            String newStatus = inputs[2];

            updates.add(new PromiseUpdate(p.getPromiseId(), newDate, newDetail));
            p.setStatus(newStatus);
            DataManager.appendCSV("promise_updates.csv", p.getPromiseId() + "," + newDate + "," + newDetail);
            List<String> lines = new ArrayList<>();

            for(Promise pro : promises) {
                lines.add(pro.getPromiseId() + "," + pro.getPoliticianId() + "," + pro.getDetail() + "," + pro.getDate() + "," + pro.getStatus());
            }

            DataManager.writeCSV("promises.csv", lines);
            viewUpdate.showSuccess();
            selectPromise(p.getPromiseId(), "admin");
        }
    }
}