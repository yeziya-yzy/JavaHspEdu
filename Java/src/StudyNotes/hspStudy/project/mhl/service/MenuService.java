package StudyNotes.hspStudy.project.mhl.service;


import StudyNotes.hspStudy.project.mhl.dao.MenuDAO;
import StudyNotes.hspStudy.project.mhl.domain.Menu;

import java.util.List;

/**
 * @author 韩顺平
 * @version 1.0
 * 完成对menu表的各种操作(通过调用MenuDAO)
 */
public class MenuService {

    //定义MenuDAO 属性
    private MenuDAO menuDAO = new MenuDAO();

    //返回所有的菜品, 返回给界面使用
    public List<Menu> list() {
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }

    //需要方法，根据id, 返回Menu对象
    public Menu getMenuById(int id) {
        return menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
    }
}
