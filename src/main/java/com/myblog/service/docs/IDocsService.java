package com.myblog.service.docs;

import java.util.List;


import com.myblog.entity.Docs;

public interface IDocsService {
	int addDocs(Docs docs);

	int delDocs(int docsId, int docsStatus);

	int updateDocs(Docs docs);

	List<Docs> getDocs(Docs docs);
}
