package blk.interfacetesting.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mark
 * @date 2018/1/24
 */
@Repository
public class ExecuteTestDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ExecuteTestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void dbInit(String dbName) {
        String[] tables = {
                "cmtb_attachment",
                "iftb_execute_main",
                "iftb_execute_test_case",
                "iftb_test_data",
                "iftb_test_data_dependency",
                "iftb_url_test_case",
                "mstb_dynamic_param",
                "mstb_project",
                "mstb_test_case",
                "mstb_url_management",
                "mstb_url_parameters",
                "oftb_dbname",
                "oftb_project_init_script",
                "tstb_result_main",
                "tstb_result_sub",
                "tstb_result_test_case",
                "tstb_result_test_data",
                "tstb_result_url"
        };
        for (String tableName : tables) {
            String sql = "TRUNCATE TABLE " + dbName + "." + tableName;
            jdbcTemplate.update(sql);
        }
    }

    public List<Map<String, Object>> executeQuery(String sql) {
        return jdbcTemplate.queryForList(sql);
    }

    public int executeUpdate(String sql) {
        return jdbcTemplate.update(sql);
    }
}
