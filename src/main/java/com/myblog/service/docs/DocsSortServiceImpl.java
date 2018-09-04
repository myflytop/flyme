package com.myblog.service.docs;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myblog.dao.docs.IDocsSortDao;
import com.myblog.entity.DocsSort;
import com.myblog.util.LayuiDataUtil;
@Service("docsSortService")
public class DocsSortServiceImpl implements IDocsSortService {
	@Resource(name="IDocsSortDao")
    private IDocsSortDao docsSortDao;
	@Override
	public int addDocsSort(DocsSort docsSort) {
		// TODO Auto-generated method stub
		return docsSortDao.addDocsSort(docsSort);
	}

	@Override
	public int updateDocsSort(DocsSort docsSort) {
		// TODO Auto-generated method stub
		return docsSortDao.updateDocsSort(docsSort);
	}

	@Override
	public int delDocsSort(int docsSortid, int docsSortstatus) {
		// TODO Auto-generated method stub
		return docsSortDao.delDocsSort(docsSortid, docsSortstatus);
	}

	@Override
	public LayuiDataUtil<DocsSort> getDocsSorts(DocsSort docsSort,int page,int limit) {
		// TODO Auto-generated method stub
		LayuiDataUtil<DocsSort> docsSorts = new LayuiDataUtil<>();
		try {
			PageHelper.startPage(page,limit);
			PageInfo<DocsSort> info=new PageInfo<DocsSort>(docsSortDao.getDocsSorts(docsSort));
			docsSorts.setCode(0);
			docsSorts.setMsg("Success");
			docsSorts.setData(info.getList());
			docsSorts.setCount(info.getTotal());
		} catch (Exception e) {
			// TODO: handle exception
			docsSorts.setCode(1);
			docsSorts.setMsg("Fail "+e.getMessage());
			docsSorts.setData(null);
			docsSorts.setCount(1);
			throw e;
		}
			
		return docsSorts;
	}
	@Override
	public int countSortName(String docsSortname, long userId) {
		// TODO Auto-generated method stub
		return docsSortDao.countSortName(docsSortname,userId);
	}

}
