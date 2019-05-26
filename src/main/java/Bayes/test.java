package Bayes;

import com.mxgraph.model.mxICell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class test extends JFrame{
    private String fileName;
    private Double[] riskProbability;
    public test(String mTask , String filePath){
        super("Risk network of " + mTask);
        this.fileName = filePath;
        this.riskProbability = takeRiskProbability();
        mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		graph.getModel().beginUpdate();
		try
		{
			Object v1 = (mxICell)   graph.insertVertex(parent, null,"1.Quy mô lớn, phân tán\n" + "\n(" + Math.round(this.riskProbability[0]*100) + "%)", 50, 0,
					150, 60);
                        Object v2 = (mxICell)   graph.insertVertex(parent, null,"2.Đào tạo không đủ" + "\n(" + Math.round(this.riskProbability[1]*100) + "%)", 0, 100,
					150, 60);
                        Object v3 = (mxICell)   graph.insertVertex(parent, null,"3.Sự chuẩn bị/ dự định thừa" + "\n(" + Math.round(this.riskProbability[2]*100) + "%)", 600, 100,
					150, 60);
                        Object v4 = (mxICell)   graph.insertVertex(parent, null,"4.Đội không tập trung, năng suất kém" + "\n(" + Math.round(this.riskProbability[3]*100) + "%)", 700, 400,
					150, 60);
                        Object v5 = (mxICell)   graph.insertVertex(parent, null,"5.Quy trình không phù hợp" + "\n(" + Math.round(this.riskProbability[4]*100) + "%)", 290, 300,
					150, 60);
                        Object v6 = (mxICell)   graph.insertVertex(parent, null,"6.Người tốt nhất không có sẵn" + "\n(" + Math.round(this.riskProbability[5]*100) + "%)", 350, 100,
					150, 60);
                        Object v7 = (mxICell)   graph.insertVertex(parent, null,"7.Con người không đúng các kĩ năng" + "\n(" + Math.round(this.riskProbability[6]*100) + "%)", 50, 400,
					150, 60);
                        Object v8 = (mxICell)   graph.insertVertex(parent, null,"8.Nhân viên không cam kết trong toàn dự án" + "\n(" + Math.round(this.riskProbability[7]*100) + "%)", 550, 600,
					150, 60);
                        Object v9 = (mxICell)   graph.insertVertex(parent, null,"9.Nhân viên làm không có đúng kỳ vọng" + "\n(" + Math.round(this.riskProbability[8]*100) + "%)", 700, 300,
					150, 60);
                        Object v10 = (mxICell)  graph.insertVertex(parent, null,"10.Nhân viên thiếu đào tạo cần thiết" + "\n(" + Math.round(this.riskProbability[9]*100) + "%)", 300, 400,
					150, 60);
                        Object v11 = (mxICell)  graph.insertVertex(parent, null,"11.Kĩ thuật không phù hợp" + "\n(" + Math.round(this.riskProbability[10]*100) + "%)", 180, 200,
					150, 60);
                        Object v12 = (mxICell)  graph.insertVertex(parent, null,"12.Phần mềm thiếu hỗ trợ lập kế hoạch, theo dõi" + "\n(" + Math.round(this.riskProbability[11]*100) + "%)", 400, 200,
					150, 60);
                        Object v13 =(mxICell)    graph.insertVertex(parent, null,"13.Phần mềm thiếu kiểm soát, theo dõi hoạt động thay đổi" + "\n(" + Math.round(this.riskProbability[12]*100) + "%)", 500, 400,
					150, 60);
                        Object v14 = (mxICell)  graph.insertVertex(parent, null,"14.Thang đo không chính xác" + "\n(" + Math.round(this.riskProbability[13]*100) + "%)", 720, 500,
					150, 60);
                        Object v15 = (mxICell)  graph.insertVertex(parent, null,"15.Công nghệ không phù hợp" + "\n(" + Math.round(this.riskProbability[14]*100) + "%)", 60, 500,
					150, 60);
                        Object v16 = (mxICell)  graph.insertVertex(parent, null,"16.Công nghệ chưa hoàn chỉnh" + "\n(" + Math.round(this.riskProbability[15]*100) + "%)", 900, 300,
					150, 60);
                        Object v17 = (mxICell)  graph.insertVertex(parent, null,"17.Người dùng không chắc về yêu cầu" + "\n(" + Math.round(this.riskProbability[16]*100) + "%)", 920, 500,
					150, 60);
                        Object v18 = (mxICell)  graph.insertVertex(parent, null,"18.Thiếu sự cam kết của quản lý cấp trên" + "\n(" + Math.round(this.riskProbability[17]*100) + "%)", 700, 0,
					150, 60);
                        Object v19 = (mxICell)  graph.insertVertex(parent, null,"19.Thiếu kinh nghiệm quản lý" + "\n(" + Math.round(this.riskProbability[18]*100) + "%)", 300, 0,
					150, 60);
                        Object v20 = (mxICell)  graph.insertVertex(parent, null,"Total Risk" + "\n(" + Math.round(this.riskProbability[19]*100) + "%)", 450, 700,
					150, 60);
                        
                        graph.insertEdge(parent, null, null, v1, v2);
                        graph.insertEdge(parent, null, null, v1, v5);
                        graph.insertEdge(parent, null, null, v1, v19);
                        graph.insertEdge(parent, null, null, v2, v7);
                        graph.insertEdge(parent, null, null, v2, v10);
                        
                        graph.insertEdge(parent, null, null, v3, v4);
                        graph.insertEdge(parent, null, null, v3, v8);
                        graph.insertEdge(parent, null, null, v3, v9);
                        graph.insertEdge(parent, null, null, v4, v8);
                        graph.insertEdge(parent, null, null, v5, v20);
                        
                        graph.insertEdge(parent, null,  null, v6, v5);
                        graph.insertEdge(parent, null, null, v6, v4);
                        graph.insertEdge(parent, null, null, v7, v15);
                        graph.insertEdge(parent, null, null, v7, v20);
                        graph.insertEdge(parent, null, null, v8, v20);
                        
                        graph.insertEdge(parent, null, null, v9, v4);
                        graph.insertEdge(parent, null, null, v9, v14);
                        graph.insertEdge(parent, null, null, v10, v20);
                        graph.insertEdge(parent, null, null, v11, v12);
                        graph.insertEdge(parent, null, null, v11, v10);
                        
                        graph.insertEdge(parent, null, null, v11, v7);
                        graph.insertEdge(parent, null, null, v11, v13);
                        graph.insertEdge(parent, null, null, v12, v5);
                        graph.insertEdge(parent, null, null, v12, v8);
                        graph.insertEdge(parent, null, null, v12, v9);
                                            
                        graph.insertEdge(parent, null, null, v12, v17);
                        graph.insertEdge(parent, null, null, v13, v14);
                        graph.insertEdge(parent, null, null, v13, v17);
                        graph.insertEdge(parent, null, null, v14, v8);
                        graph.insertEdge(parent, null, null, v15, v20);
                        
                        graph.insertEdge(parent, null, null, v16, v14);
                        graph.insertEdge(parent, null, null, v16, v17);
                        graph.insertEdge(parent, null, null, v17, v20);
                        graph.insertEdge(parent, null, null, v18, v4);
                        graph.insertEdge(parent, null, null, v18, v17);
                        
                        graph.insertEdge(parent, null, null, v19, v3);
                        graph.insertEdge(parent, null, null, v19, v6);
                        graph.insertEdge(parent, null, null, v19, v15);
                        
                        
                        
			
		}
		finally
		{
			graph.getModel().endUpdate();
		}
//                mxIGraphLayout layout = new mxHierarchicalLayout(graph);
//                layout.execute(graph.getDefaultParent());
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
    }
    public Double[] takeRiskProbability() {
		Double[] riskProbability = new Double[20];
		
		try {
			// Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
			FileInputStream fis = new FileInputStream(this.fileName);
			DataInputStream dis = new DataInputStream(fis);

			// Bước 2: Đọc dữ liệu				
			for (int i = 0; i < 20; i++) {				
				riskProbability[i] = dis.readDouble();				
			}

			// Bước 3: Đóng luồng
			fis.close();
			dis.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return riskProbability;
	}
    private int rand(int min, int max) {
        try {
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public static void main(String[] args) {
        test testframe = new test("test", "probability1.bin");
        testframe.setVisible(true);
        testframe.setDefaultCloseOperation(testframe.EXIT_ON_CLOSE);
    }
    
}
