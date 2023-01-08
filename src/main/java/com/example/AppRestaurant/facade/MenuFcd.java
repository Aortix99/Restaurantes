package com.example.AppRestaurant.facade;

import com.example.AppRestaurant.conexion.ManagerConexion;
import com.example.AppRestaurant.dto.MenuDto;
import com.example.AppRestaurant.exception.FacadeEXception;
import com.example.AppRestaurant.manager.MenuMgrInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class MenuFcd implements MenuFdcInterface{
    @Autowired
    private MenuMgrInterface Mgr;
    @Override
    public void save(MenuDto M) throws FacadeEXception {
  try {
      ManagerConexion.getInstance().open();
      Mgr.save(M);
      ManagerConexion.getInstance().commit();
  }catch (Exception E){
      ManagerConexion.getInstance().rollback();
      throw new FacadeEXception(E);

  }finally {
      ManagerConexion.getInstance().close();
  }
    }

    @Override
    public void delete(int I) throws FacadeEXception {
        try {
            ManagerConexion.getInstance().open();
            Mgr.delete(I);
            ManagerConexion.getInstance().commit();
        }catch (Exception E){
            throw new FacadeEXception(E);

        }finally {
            ManagerConexion.getInstance().close();
        }
    }

    @Override
    public List<MenuDto> selectall() throws FacadeEXception {
        try {
            ManagerConexion.getInstance().open();
            return Mgr.selectall();
        }catch (Exception E){
            throw new FacadeEXception(E);

        }finally {
            ManagerConexion.getInstance().close();
        }
    }
}
