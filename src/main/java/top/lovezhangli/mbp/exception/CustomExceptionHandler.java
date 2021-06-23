package top.lovezhangli.mbp.exception;

import top.lovezhangli.mbp.vo.ResponseBean;
import top.lovezhangli.mbp.vo.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Desc: ExceptionHandler
 * Author: Xu He
 * created: 2021/5/6 15:58
 */
@Slf4j
@ControllerAdvice(value = "com.hly.website.hlywebsite")
public class CustomExceptionHandler {
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseBean handleBindException(BindException e) {
        log.error("BindException: {}", e);
        String message = e.getBindingResult().getAllErrors().stream().map( DefaultMessageSourceResolvable::getDefaultMessage).collect( Collectors.joining(","));
        return new ResponseBean(false, ResponseCode.BAD_PARAM.getCode (),message);
    }


    /** get请求参数异常 */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public ResponseBean HandleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("MissingServletRequestParameterException: {}", e);
        String parameterName = e.getParameterName ();
        return new ResponseBean(false, ResponseCode.BAD_PARAM.getCode (),"参数"+parameterName+"不能为空！");
    }


    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseBody
    public ResponseBean handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("MethodArgumentTypeMismatchException: {}", e);
        return new ResponseBean(false, ResponseCode.BAD_PARAM.getCode (),"参数类型不匹配！");

    }


    /** post请求参数异常 */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ResponseBean HandleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException: {}", e);
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        StringBuffer errorMsg = new StringBuffer();
        for ( int i = 0; i < errors.size (); i++ ) {
            if (i == errors.size ()-1) {
                errorMsg.append ( errors.get ( i ).getDefaultMessage () );
            }else {
                errorMsg.append ( errors.get ( i ).getDefaultMessage () ).append ( ";" );
            }
        }
        return new ResponseBean(false, ResponseCode.BAD_PARAM.getCode (),errorMsg.toString ());
    }

    /** 表单请求参数异常 */
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseBody
    public ResponseBean handleConstraintViolationException(ConstraintViolationException e) {
        log.error("ConstraintViolationException: {}", e);
        Set<ConstraintViolation<?>> cves = e.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = cves.iterator ();
        StringBuffer errorMsg = new StringBuffer();
        for ( int i = 0; i < cves.size (); i++ ) {
            if (i == cves.size ()-1) {
                errorMsg.append(iterator.next ().getMessage ());
            } else {
                errorMsg.append(iterator.next ().getMessage ()).append ( ";" );
            }
        }
        return new ResponseBean(false, ResponseCode.BAD_PARAM.getCode (),errorMsg.toString ());
    }

    @ExceptionHandler({CustomException.class})
    @ResponseBody
    public ResponseBean handleCustomException(CustomException e) {
        log.error("自定义异常：{} ", e.getErrMsg ());
        return new ResponseBean(true, e.getErrCode (),e.getErrMsg ());
    }

    /** 其他错误 */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResponseBean exception(Exception ex) {
        log.error("其他错误：{} ", ex);
        return new ResponseBean(false, ResponseCode.UNKNOWN_ERROR);
    }
}
