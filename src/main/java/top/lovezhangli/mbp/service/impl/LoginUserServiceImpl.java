package top.lovezhangli.mbp.service.impl;

import top.lovezhangli.mbp.entity.LoginUser;
import top.lovezhangli.mbp.mapper.LoginUserMapper;
import top.lovezhangli.mbp.service.ILoginUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xu He
 * @since 2021-05-11
 */
@Service
public class LoginUserServiceImpl extends ServiceImpl<LoginUserMapper, LoginUser> implements ILoginUserService {

}
