package top.lovezhangli.mbp.controller;


import top.lovezhangli.mbp.entity.LoginUser;
import top.lovezhangli.mbp.vo.ResponseCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Xu He
 * @since 2021-05-11
 */
@RestController
@RequestMapping("/user")
public class LoginUserController {
    @PostMapping
    public ResponseCode register(@Valid @RequestBody LoginUser user) {
        return null;
    }


}
