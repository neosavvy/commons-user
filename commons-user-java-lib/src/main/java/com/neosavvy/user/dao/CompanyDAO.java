package com.neosavvy.user.dao;

import com.neosavvy.user.dto.CompanyDTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lgleason
 * Date: Nov 27, 2009
 * Time: 2:49:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CompanyDAO {
    public List<CompanyDTO> getCompanies();

    public void saveCompany(CompanyDTO user);

    public CompanyDTO findCompanyById(int id);

    public List<CompanyDTO> findCompanies(CompanyDTO company);

}
