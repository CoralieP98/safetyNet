package safetyNet.safetyNet.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import safetyNet.safetyNet.service.ChildAlertService;
import safetyNet.safetyNet.service.DTO.ChildAlertDTO;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("safetyNet")
public class ChildAlertController {

    public  final ChildAlertService childAlertService;

    public ChildAlertController(ChildAlertService childAlertService) {
        this.childAlertService = childAlertService;
    }

    @GetMapping("childAlert")
    public List<ChildAlertDTO> childAlert(@RequestParam(name="address") String address) throws ParseException {
        return childAlertService.childAlertList(address);
    }
}
