package cap.service;

import cap.model.Admin;
import cap.util.PageBean;

public interface AdminService {
    public Admin login(Admin admin);

    PageBean findByPage(int pageNo, int pageSize);

    public Admin findAdmin(int id);

    int update(int id, Admin admin);

    int delete(int id);

    int insert(Admin admin);

}
