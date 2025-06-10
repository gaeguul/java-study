package org.scoula.exception;

import javax.servlet.http.*;
import lombok.extern.log4j.*;
import org.springframework.http.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

  @ExceptionHandler(Exception.class)
  public String except(Exception ex, Model model) {
    log.error("Exception ......." + ex.getMessage());
    model.addAttribute("exception", ex);
    log.error(model);
    return "error_page"; // view 이름
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handle404(NoHandlerFoundException ex, Model model, HttpServletRequest request) {
    log.error(ex);
    model.addAttribute("uri", request.getRequestURI());
    return "custom404";
  }
}
