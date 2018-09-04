package com.myblog.dao.docs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myblog.entity.Docs;

public interface IDocsDao {
	int addDocs(Docs docs);

	int delDocs(@Param("docsId")int docsId,@Param("docsStatus")int docsStatus);

	int updateDocs(Docs docs);

	List<Docs> getDocs(Docs docs);
}
