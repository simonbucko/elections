package volby.controlers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    @GetMapping()
    public String test (){
        return "Server is running!";
    }

}
