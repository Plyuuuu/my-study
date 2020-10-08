package github.veikkoroc.design_partten.structuraltype.proxy.jdk.api;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 0:19
 */
public interface DocumentDao {
    /**
     * 通过id删除Document
     * @param documentId
     * @return
     */
    Boolean deleteDocumentById(String documentId);
}
