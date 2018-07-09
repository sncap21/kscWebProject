package kr.co.koscom.dao;

import java.util.Date;
import kr.co.koscom.dto.BoardDTO;
import kr.co.koscom.dto.MemberDTO;

public interface BoardDAO {

	public int addBoard(BoardDTO board);
	public int deleteBoard(double sequence, String writeDate);
	public BoardDTO getBoard();
	public BoardDTO getBoardById(String id);

}
