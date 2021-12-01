<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.oreilly.servlet.*" %>
<%@ page import="com.oreilly.servlet.multipart.*" %>
<%@ page import="javax.imageio.*" %>
<%@ page import="java.awt.image.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
// 세션을 확인해서 통과 여부 시키기
String m_id = (String)session.getAttribute("m_id");
String m_age = (String)session.getAttribute("m_age");

if (m_id == null || m_age == null) {
	out.println("정상 경로가 아님... <br><br>");
	return;
}
%>

<%
MultipartRequest  multi = new MultipartRequest(request, "c:/Upload", 
	5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
	
String tmp;
Enumeration params = multi.getParameterNames(); //주의! 넘어오는 순서가 반대.
tmp = (String) params.nextElement();
String addVal = multi.getParameter(tmp);
tmp = (String) params.nextElement();
String algo = multi.getParameter(tmp);

// ** 파일 전송 **
Enumeration files = multi.getFileNames();
tmp = (String) files.nextElement();
String filename = multi.getFilesystemName(tmp);
out.println("<p>업로드 파일명 :" + filename);

///////////////////////

String input = addVal;

// 전역 변수 선언
int[][][] inImage=null;
int inH=0, inW=0;
int[][][] outImage=null;
int outH=0, outW=0;


// (1) JSP 파일 처리
File inFp;
FileInputStream inFs;
inFp = new File("c:/Upload/" + filename);  // mypic.png
// 칼라 이미지 처리
BufferedImage cImage = ImageIO.read(inFp);
// (2) JSP 배열 처리 : 파일 --> 메모리(2차배열)
//(중요!) 입력 폭, 높이 결정
inW = cImage.getHeight();
inH = cImage.getWidth();

inImage = new int[3][inH][inW];
// 파일 --> 메모리
for (int i=0; i<inH; i++) {
	for (int k=0; k<inW; k++) {
		int rgb = cImage.getRGB(i,k);
		int r = (rgb >> 16) & 0xFF;
		int g = (rgb >> 8) & 0xFF;
		int b = (rgb >> 0) & 0xFF;
		inImage[0][i][k] = r;
		inImage[1][i][k] = g;
		inImage[2][i][k] = b;		
	}
}

// (3) 영상처리 알고리즘 적용하기.
switch(algo) {
case "100" : 	// 반전 알고리즘 : out = 255 - in
	// (중요!) 출력 폭, 높이 결정 --> 알고리즘에 의존.
	outH = inH;
	outW = inW;
	outImage = new int[3][outH][outW];
	// ## 진짜 영상처리 알고리즘 ##
	for(int rgb=0; rgb<3; rgb++) {
		for(int i=0; i<inH; i++) {
			for (int k=0; k<inW; k++) {
				outImage[rgb][i][k] = inImage[rgb][i][k];
			}
		}
	}
	break;
case "101" : 	// 반전 알고리즘 : out = 255 - in
	// (중요!) 출력 폭, 높이 결정 --> 알고리즘에 의존.
	outH = inH;
	outW = inW;
	outImage = new int[3][outH][outW];
	// ## 진짜 영상처리 알고리즘 ##
	for(int rgb=0; rgb<3; rgb++) {
		for(int i=0; i<inH; i++) {
			for (int k=0; k<inW; k++) {
				outImage[rgb][i][k] = 255 - inImage[rgb][i][k];
			}
		}
	}
	break;
case "102" : 	// 밝게/어둡게 : out = in + para
	// (중요!) 출력 폭, 높이 결정 --> 알고리즘에 의존.
	outH = inH;
	outW = inW;
	outImage = new int[3][outH][outW];
	// ## 진짜 영상처리 알고리즘 ## 
	for(int rgb=0; rgb<3; rgb++) {
		for(int i=0; i<inH; i++) {
			for (int k=0; k<inW; k++) {
				int v = inImage[rgb][i][k] + Integer.parseInt(input);
				if (v > 255)
					v = 255;
				if (v <0)
					v = 0;
				outImage[rgb][i][k] = v;
			}
		}
	}
	break;

case "103" :
	outH = inH;
	outW = inW;
	outImage = new int[3][outH][outW];
	// ## 진짜 영상처리 알고리즘 ## 
	int R,G,B;
	for(int rgb=0; rgb<3; rgb++) {
		for(int i=0; i<inH; i++) {
			for (int k=0; k<inW; k++) {
			R = inImage[0][i][k];
			G = inImage[1][i][k];
			B = inImage[2][i][k];
			int RGB = (int)(R+G+B/3);
			if(RGB <= 127)
				RGB=0;
			else
				RGB=255;
			outImage[0][i][k] =RGB;
			outImage[1][i][k] =RGB;
			outImage[2][i][k] =RGB;
			}
		}
	}
	break;

case "201" :
	int scale = Integer.parseInt(input);
	outH = scale*inH;
	outW = scale*inW;
	outImage = new int[3][outH][outW];
	// ## 진짜 영상처리 알고리즘 ## 
	
	for(int rgb=0; rgb<3; rgb++) {
		for(int i=0; i<inH; i++) {
			for (int k=0; k<inW; k++) {
			outImage[rgb][scale*i][scale*k]=inImage[rgb][i][k];
			}
		}
	}
	break;
case "202" :
	int scale1 = Integer.parseInt(input);
	outH = inH/scale1;
	outW = inW/scale1;
	outImage = new int[3][outH][outW];
	// ## 진짜 영상처리 알고리즘 ## 
	
	for(int rgb=0; rgb<3; rgb++) {
		for(int i=0; i<inH; i++) {
			for (int k=0; k<inW; k++) {
			outImage[rgb][i/scale1][k/scale1]=inImage[rgb][i][k];
			}
		}
	}
	break;
case "301" :
	
	outH = inH;
	outW = inW;
	
	double[][] mask = {{1.0/9.0, 1.0/9.0, 1.0/9.0},
			           {1.0/9.0, 1.0/9.0, 1.0/9.0},	
			           {1.0/9.0, 1.0/9.0, 1.0/9.0}};
	int[][][] tmpimage = new int[3][inH+2][inW+2];
	// ## 진짜 영상처리 알고리즘 ## 
	
	
	for(int rgb=0; rgb<3; rgb++) {
		for(int i=0; i<inH; i++) {
			for (int k=0; k<inW; k++) {
			tmpimage[rgb][i+1][k+1]=inImage[rgb][i][k];
			}
		}
	}
	outImage = new int[3][outH][outW];
	for(int rgb=0; rgb<3; rgb++) {
		for(int i=0; i<inH; i++) {
			for (int k=0; k<inW; k++) {
				double x =0.0;
				for(int m=0; m<3; m++){
					for(int n=0; n<3; n++){
						x += mask[m][n]*tmpimage[rgb][i+m][k+n];
					}
				}
					if(x>255)
						x = 255;
					if(x<0)
						x=0;
					outImage[rgb][i][k]=(int)x;
	   		}
		}
	}
	break;
case "302" :
	
	outH = inH;
	outW = inW;
	
	int[][] mask1 = {{-1,0,0},{0,0,0}, {0,0,1}};
	int[][][] tmpimage1 = new int[3][inH+2][inW+2];
	// ## 진짜 영상처리 알고리즘 ## 
	
	
	for(int rgb=0; rgb<3; rgb++) {
		for(int i=0; i<inH; i++) {
			for (int k=0; k<inW; k++) {
			tmpimage1[rgb][i][k]= 127;
			}
		}
	}
	for(int rgb=0; rgb<3; rgb++) {
		for(int i=0; i<inH; i++) {
			for (int k=0; k<inW; k++) {
			tmpimage1[rgb][i+1][k+1]= inImage[rgb][i][k];
			}
		}
	}
	outImage = new int[3][outH][outW];
	for(int rgb=0; rgb<3; rgb++) {
		for(int i=0; i<inH; i++) {
			for (int k=0; k<inW; k++) {
				int x =0;
				for(int m=0; m<3; m++){
					for(int n=0; n<3; n++){
						x += mask1[m][n]*tmpimage1[rgb][i+m][k+n];
					}
				}
					x +=127;
					if(x>255)
						x = 255;
					if(x<0)
						x=0;
					outImage[rgb][i][k]=x;
	   		}
		}
	}
	break;
}
// (4) 결과를 파일에 쓰기
File outFp;
FileOutputStream outFs;
String outname = "out_"+ filename;
outFp = new File("c:/out/"+ outname);
// 칼라 이미지 저장
BufferedImage outCImage = new BufferedImage(outH, outW,
		BufferedImage.TYPE_INT_RGB);
// 메모리 --> 파일

	for(int i=0; i<outH; i++) {
		for(int k=0; k<outW; k++) {
			int r = outImage[0][i][k];
			int g = outImage[1][i][k];
			int b = outImage[2][i][k];
			int px =0;
			px = px | (r << 16);
			px = px | (g << 8);
			px = px | (b << 0);
			outCImage.setRGB(i,k,px);
		}
	}

ImageIO.write(outCImage,"jpg", outFp);
out.println(algo + "  <h1> 처리 끝! </h1>");
String url = "<p><h1><a href='http://192.168.56.101:8080/SampleJSP/";
url += "download.jsp?file=" + outname + "'>다운로드</a></h1>";
out.println(url);
%>
<form method="post" action="4-02_color_client.jsp">
	<p> <input type="submit" value="영상처리 페이지">
</form>

</body>
</html>