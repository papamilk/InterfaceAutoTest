package blk.interfacetesting.service.common;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author Mark
 * @date 2018/1/24
 */
public interface ParseDataFileService {
    /**
     * 清空指定的平台数据库记录
     * @param dbName 数据库名称
     */
    void dbInit(String dbName);

    /**
     * 解析并保存上传的数据文件
     * @param multipartFile 上传的文件数据
     * @param isOverWrite 是否覆盖重名场景
     * @return 错误信息 Map对象
     *          key:msg                 value: 错误提示
     *          key:validationInfo      value: 具体错误信息List
     */
    Map<String, Object> parseDataFile(MultipartFile multipartFile, boolean isOverWrite);

    /**
     * 验证期望结果是否符合Json格式
     * @param expectResult 期望结果
     * @return 符合返回字符串"符合Json格式"，若不符合，返回具体错误信息
     */
    String validateExpectResult(String expectResult);
}
