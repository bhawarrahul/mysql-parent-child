package com.mysql.parent.child.run;

import com.mysql.parent.child.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RunController {
    @Autowired
    private Execution execution;
    @GetMapping("getAll")
    public ResponseEntity<List<Employee>> getEmployee() {
        return ResponseEntity.ok(execution.fetchParentChildData());
    }
}
