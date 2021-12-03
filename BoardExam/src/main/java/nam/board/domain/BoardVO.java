package nam.board.domain;

public class BoardVO {
	// 11 26 미니게시판 만들기
	private int seqno;
	private String mwriter;
	private String mtitle;
	private String mregDate;
	private String mcontent;

	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}

	public String getMwriter() {
		return mwriter;
	}

	public void setMwriter(String mwriter) {
		this.mwriter = mwriter;
	}

	public String getMtitle() {
		return mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public String getMregDate() {
		return mregDate;
	}

	public void setMregDate(String mregDate) {
		this.mregDate = mregDate;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

}
