package com.myblog.service.docs;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myblog.dao.docs.IDocsDao;
import com.myblog.entity.Docs;
@Service("docsService")
public class DocsServiceImpl implements IDocsService {
    @Resource(name="IDocsDao")
	private IDocsDao docsDao;
	@Override
	public int addDocs(Docs docs) {
		// TODO Auto-generated method stub
		return docsDao.addDocs(docs);
	}

	@Override
	public int delDocs(int docsId, int docsStatus) {
		// TODO Auto-generated method stub
		return docsDao.delDocs(docsId, docsStatus);
	}

	@Override
	public int updateDocs(Docs docs) {
		// TODO Auto-generated method stub
		return docsDao.updateDocs(docs);
	}

	@Override
	public List<Docs> getDocs(Docs docs) {
		// TODO Auto-generated method stub
		return docsDao.getDocs(docs);
	}

}
