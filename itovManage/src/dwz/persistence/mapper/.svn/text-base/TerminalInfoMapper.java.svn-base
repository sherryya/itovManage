package dwz.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.InfNews;
import dwz.persistence.beans.TerminalInfo;

@Repository
public interface TerminalInfoMapper extends BaseMapper<InfNews, Integer> {

	List<TerminalInfo> queryTerminalList(TerminalInfo terminal);
	
	int queryCountTerminalList();

}
