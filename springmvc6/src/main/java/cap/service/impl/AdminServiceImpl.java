package cap.service.impl;

import cap.dao.AdminDAO;
import cap.model.Admin;
import cap.service.AdminService;
import cap.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDAO adminDAO;

    @Override
    public Admin login(Admin admin) {
        return adminDAO.login(admin);
    }

    @Override
    public PageBean findByPage(int pageNo, int pageSize) {
        PageBean pageBean = new PageBean();
        List<Admin> adminList = adminDAO.findByPage(pageNo, pageSize);
        int totalCount = adminDAO.getTotalCount();
        pageBean.setPageNo(pageNo);
        pageBean.setPageSize(pageSize);
        pageBean.setList(adminList);
        pageBean.setTotalRecords(totalCount);
        return pageBean;
    }

    @Override
    public Admin findAdmin(int id) {
        return adminDAO.findAdmin(id);
    }

    @Override
    public int update(int id, Admin admin) {
        return adminDAO.update(id, admin);
    }

    @Override
    public int delete(int id) {
        return adminDAO.delete(id);
    }

    @Override
    public int insert(Admin admin) {
        return adminDAO.insert(admin);
    }
}