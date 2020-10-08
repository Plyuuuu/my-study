package github.veikkoroc.design_partten.structuraltype.proxy.jdk.impl;

import github.veikkoroc.design_partten.structuraltype.proxy.jdk.api.DocumentDao;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 0:24
 */
public class DocumentDaoImpl implements DocumentDao {
    @Override
    public Boolean deleteDocumentById(String documentId) {
        String s = "001";
        if (s.equals(documentId)){
            System.out.println("删除文档 001 成功!");
            return true;
        }
        return false;
    }
}
