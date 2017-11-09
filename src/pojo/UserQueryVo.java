package pojo;

import java.util.List;

/**
 * @Author:L1ANN
 * @Description: User包装类
 * @Date:Created in 17:20 2017/11/9
 * @Modified By:
 */
public class UserQueryVo {
    private User user;
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
