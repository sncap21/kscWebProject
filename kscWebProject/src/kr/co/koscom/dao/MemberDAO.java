package kr.co.koscom.dao;

import java.util.List;
import kr.co.koscom.dto.MemberDTO;

public interface MemberDAO {
	public int addMember(MemberDTO member);
	public int deleteMember(String id);
	public MemberDTO getMember(String id);
	public List<MemberDTO> getMemberList();

}
