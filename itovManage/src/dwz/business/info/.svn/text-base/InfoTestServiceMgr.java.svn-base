package dwz.business.info;
import java.util.List;
import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.persistence.TestBaseConditionVO;
public interface InfoTestServiceMgr extends BusinessObjectServiceMgr {
	String SERVICE_NAME = "InfoTestServiceMgr";
	List<Tests> findPageBreakByCondition(TestBaseConditionVO vo);
	Integer countAll0(TestBaseConditionVO vo);
	void insert(Tests tests);
	void update(Tests tests);
	
	Tests getTests(Integer id);
	
	void delete(Integer id);
}
