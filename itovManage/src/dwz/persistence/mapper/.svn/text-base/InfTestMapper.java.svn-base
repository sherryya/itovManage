package dwz.persistence.mapper;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import dwz.business.info.Tests;
import dwz.dal.BaseMapper;
import dwz.persistence.TestBaseConditionVO;
import dwz.persistence.beans.InfoTest;
@Repository
public interface InfTestMapper extends BaseMapper<InfoTest, Integer> {
	List<InfoTest> findPageBreakByCondition(TestBaseConditionVO vo, RowBounds rb);
	int countAll0(TestBaseConditionVO vo);
	void insert(Tests tests);
	void update(Tests tests);
}
