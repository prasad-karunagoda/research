package prasad.research.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
@Api(tags = {"Calculator"})
public class CalculatorController {

    @GetMapping("/add")
    @ApiOperation("Adds given two numbers and returns the sum.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a", value = "First number", example = "5"),
            @ApiImplicitParam(name = "b", value = "Second number", example = "3")})
    public int add(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int a, @RequestParam int b) {
        return a - b;
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b) {
        return a * b;
    }

    @GetMapping("/divide")
    @ApiOperation("Divide the first number by the second number and returns the result.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dividend", value = "Dividend", example = "5"),
            @ApiImplicitParam(name = "divisor", value = "Divisor", example = "3")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Invalid input")})
    public double divide(@RequestParam int dividend, @RequestParam int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor must not be 0.");
        }
        return (double) dividend / divisor;
    }
}
