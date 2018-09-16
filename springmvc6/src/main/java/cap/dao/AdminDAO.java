package cap.dao;

import cap.model.Admin;

import java.util.List;

public interface AdminDAO {
    public Admin login(Admin admin);

    List<Admin> findByPage(int pageNo, int pageSize);

    public Admin findAdmin(int id);

    int getTotalCount();

    int update(int id, Admin admin);

    int delete(int id);

    int insert(Admin admin);
}
