package safetyNet.safetyNet.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import safetyNet.safetyNet.service.ChildAlertService;

@RestController
@RequestMapping("safetyNet")
public class ChildAlertController {

    public  final ChildAlertService childAlertService;

    public ChildAlertController(ChildAlertService childAlertService) {
        this.childAlertService = childAlertService;
    }
}
