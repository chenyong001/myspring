package my.spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import my.spring.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
