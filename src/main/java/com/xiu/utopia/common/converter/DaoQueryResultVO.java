package com.xiu.utopia.common.converter;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 整合了PageHepler 可以用户进行 暂时用不到
 * @param <T>
 */
public class DaoQueryResultVO<T> extends PageInfo<T> implements Serializable
{
    private static final long serialVersionUID = -6401449740378930924L;

    private List<T> lstResultList;

    public DaoQueryResultVO(List<T> list)
    {
        super(list);
        if (getSize() >= 0)
        {
            lstResultList = new ArrayList<T>();
            lstResultList.addAll(getList().subList(0, getSize()));
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "DaoQueryResultVO [lstResultList=" + lstResultList + ", toString()=" + super.toString() + "]";
    }

    /**
     * @return the lstResultList
     */
    public List<T> getLstResultList()
    {
        return lstResultList;
    }
}