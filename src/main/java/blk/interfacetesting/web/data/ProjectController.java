package blk.interfacetesting.web.data;

import blk.common.bean.PageResultBean;
import blk.common.bean.ResultBean;
import blk.common.util.Constants;
import blk.interfacetesting.modle.data.MstbProject;
import blk.interfacetesting.modle.data.MstbProjectCriteria;
import blk.interfacetesting.service.data.ProjectService;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mark
 * @date 2018/1/19
 */
@Validated
@RequestMapping("/project")
@RestController
@CrossOrigin(origins = "*")
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageResultBean<List<MstbProject>> getList(
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.begin.illegal}") String begin,
            @Pattern(regexp = "^[1-9]\\d*|0$", message = "{page.length.illegal}") String length) {
        if (null == begin || null == length) {
            return new PageResultBean<List<MstbProject>>(projectService.getList());
        }
        return new PageResultBean<List<MstbProject>>(projectService.getList(Integer.parseInt(begin),
                Integer.parseInt(length)));
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<MstbProject> getOne(
            @NotNull(message = "{project.mpId.isnull}") @Pattern(regexp = "^[1-9]\\d{0,10}$", message = "{project.mpId.illegal}") String mpId) {
        return new ResultBean<MstbProject>(projectService.query(Integer.parseInt(mpId)));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> add(@Valid MstbProject project, BindingResult bindingResult) {
        projectService.add(project);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("mpId", project.getMpId());
        return new ResultBean<Map<String, Integer>>(map);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Object>> update(@Valid MstbProject project, BindingResult bindingResult) {
        projectService.update(project);
        return new ResultBean<Map<String, Object>>(Constants.EMPTY_MAP);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, Integer>> delete(@Valid MstbProject project, BindingResult bindingResult) {
        MstbProjectCriteria criteria = new MstbProjectCriteria();
        criteria.createCriteria().andMpIdEqualTo(project.getMpId());
        projectService.delete(criteria);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("mpId", project.getMpId());
        return new ResultBean<Map<String, Integer>>(map);
    }

    @RequestMapping(value = "/checkName", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultBean<Map<String, String>> checkName(@NotBlank(message = "{project.mpName.illegal}") String mpName) {
        boolean result = projectService.checkName(mpName);
        Map<String, String> map = new HashMap<String, String>();
        if (result) {
            map.put("valid", "true");
        } else {
            map.put("valid", "false");
        }
        return new ResultBean<Map<String, String>>(map);
    }
}
