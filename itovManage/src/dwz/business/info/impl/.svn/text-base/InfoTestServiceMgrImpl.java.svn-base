package dwz.business.info.impl;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dwz.business.info.InfoTestServiceMgr;
import dwz.business.info.News;
import dwz.business.info.Tests;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.TestBaseConditionVO;
import dwz.persistence.beans.InfNews;
import dwz.persistence.beans.InfoTest;
import dwz.persistence.mapper.InfTestMapper;
@Transactional(rollbackFor = Exception.class)
@Service(InfoTestServiceMgr.SERVICE_NAME)
public class InfoTestServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements InfoTestServiceMgr {
	@Autowired
	private InfTestMapper newsMapper;
	public Integer countAll0(TestBaseConditionVO vo) {
		Integer count = newsMapper.countAll0(vo);
		return count;
	}
	@Override
	public List<Tests> findPageBreakByCondition(TestBaseConditionVO vo) {
		ArrayList<Tests> bos = new ArrayList<Tests>();
		RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
		List<InfoTest> pos = newsMapper.findPageBreakByCondition(vo, rb);
		for (InfoTest po : pos) {
			bos.add(new Tests(po));
		}
		return bos;
	}
	public void insert(Tests tests) {
		this.newsMapper.insert(tests.getInfNews());
	}
	@Override
	public void update(Tests tests) {
		// TODO Auto-generated method stub
		this.newsMapper.update(tests.getInfNews());
	}
	@Override
	public Tests getTests(Integer id) {
		InfoTest infoTest = this.newsMapper.load(id);
		if (infoTest != null)
			return new Tests(infoTest);
		return null;
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.newsMapper.delete(id);
	}
}
