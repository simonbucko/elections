package volby.controlers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/test")
public class TestREST {

    @GetMapping()
    public String test (){
        return "Server is running!";
    }

}
