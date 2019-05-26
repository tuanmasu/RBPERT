package Bayes;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.model.mxICell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
public class RiskBayesNetGUI extends JFrame{
    private String fileName;
    private Double[] riskProbability;
    public RiskBayesNetGUI(String mTask , String filePath){
        super("Risk network of " + mTask);
        this.fileName = filePath;
        this.riskProbability = getRiskProbability();
        mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		graph.getModel().beginUpdate();
		try
		{
			Object v1 = (mxICell)   graph.insertVertex(parent, null,"1.Tổ chức thiếu sự trưởng thành\n" + "\n(" + Math.round(this.riskProbability[0]*100) + "%)", 0, 0,
					150, 60);
                        Object v2 = (mxICell)   graph.insertVertex(parent, null,"2.Thiếu kênh giao tiếp trong tổ chức" + "\n(" + Math.round(this.riskProbability[1]*100) + "%)", 0, 0,
					150, 60);
                        Object v3 = (mxICell)   graph.insertVertex(parent, null,"3.Không có nhân viên chính hoặc người quản lí" + "\n(" + Math.round(this.riskProbability[2]*100) + "%)", 0, 0,
					150, 60);
                        Object v4 = (mxICell)   graph.insertVertex(parent, null,"4.Quy mô tổ chức không phù hợp" + "\n(" + Math.round(this.riskProbability[3]*100) + "%)", 0, 0,
					150, 60);
                        Object v5 = (mxICell)   graph.insertVertex(parent, null,"5.Thiếu dữ liệu lịch sử" + "\n(" + Math.round(this.riskProbability[4]*100) + "%)", 0, 0,
					150, 60);
                        Object v6 = (mxICell)   graph.insertVertex(parent, null,"6.Yêu cầu thay đổi liên tục" + "\n(" + Math.round(this.riskProbability[5]*100) + "%)", 0, 0,
					150, 60);
                        Object v7 = (mxICell)   graph.insertVertex(parent, null,"7.Người liên lạc thiếu năng lực" + "\n(" + Math.round(this.riskProbability[6]*100) + "%)", 0, 0,
					150, 60);
                        Object v8 = (mxICell)   graph.insertVertex(parent, null,"8.Quản lí tổ chức không khả thi" + "\n(" + Math.round(this.riskProbability[7]*100) + "%)", 0, 0,
					150, 60);
                        Object v9 = (mxICell)   graph.insertVertex(parent, null,"9.Lập kế hoạch và dự toán chi phí không đủ" + "\n(" + Math.round(this.riskProbability[8]*100) + "%)", 0, 0,
					150, 60);
                        Object v10 = (mxICell)  graph.insertVertex(parent, null,"10.Phối hợp giữa các đơn vị liên quan" + "\n(" + Math.round(this.riskProbability[9]*100) + "%)", 0, 0,
					150, 60);
                        Object v11 = (mxICell)  graph.insertVertex(parent, null,"11.Thiếu sự cam kết của nhân viên , tinh thần thấp" + "\n(" + Math.round(this.riskProbability[10]*100) + "%)", 0, 0,
					150, 60);
                        Object v12 = (mxICell)  graph.insertVertex(parent, null,"12.Nhân viên thiếu kinh nghiệm và kỹ thuật" + "\n(" + Math.round(this.riskProbability[11]*100) + "%)", 0, 0,
					150, 60);
                        Object v13 =(mxICell)    graph.insertVertex(parent, null,"13.Không ổn định và thiếu liên tục trong nhân sự dự án" + "\n(" + Math.round(this.riskProbability[12]*100) + "%)", 0, 0,
					150, 60);
                        Object v14 = (mxICell)  graph.insertVertex(parent, null,"14.Thiếu kinh nghiệm đối với môi trường/hoạt động người dùng" + "\n(" + Math.round(this.riskProbability[13]*100) + "%)", 0, 0,
					150, 60);
                        Object v15 = (mxICell)  graph.insertVertex(parent, null,"15.Thiếu hụt các thành phần được cung cấp từ bên thứ ba" + "\n(" + Math.round(this.riskProbability[14]*100) + "%)", 0, 0,
					150, 60);
                        Object v16 = (mxICell)  graph.insertVertex(parent, null,"16.Công nghệ chưa phát triển hoàn chỉnh" + "\n(" + Math.round(this.riskProbability[15]*100) + "%)", 0, 0,
					150, 60);
                        Object v17 = (mxICell)  graph.insertVertex(parent, null,"17.Phụ thuộc nhân viên chủ chốt" + "\n(" + Math.round(this.riskProbability[16]*100) + "%)", 0, 0,
					150, 60);
                        Object v18 = (mxICell)  graph.insertVertex(parent, null,"18.Nhiều giao diện người dùng phức tạp" + "\n(" + Math.round(this.riskProbability[17]*100) + "%)", 0, 0,
					150, 60);
                        Object v19 = (mxICell)  graph.insertVertex(parent, null,"19.Thêm nhiều tính năng/ chức năng" + "\n(" + Math.round(this.riskProbability[18]*100) + "%)", 0, 0,
					150, 60);
                        Object v20 = (mxICell)  graph.insertVertex(parent, null,"20. Ghép nối giữa phần cứng và phần mềm" + "\n(" + Math.round(this.riskProbability[19]*100) + "%)", 0, 0,
					150, 60);
                        Object v21 = (mxICell)  graph.insertVertex(parent, null,"21. Phát triển chức năng phần mềm sai" + "\n(" + Math.round(this.riskProbability[20]*100) + "%)", 0, 0,
					150, 60);
                        Object v22 = (mxICell)  graph.insertVertex(parent, null,"22. Năng suất thấp trong phát triển công nghệ" + "\n(" + Math.round(this.riskProbability[21]*100) + "%)", 0, 0,
					150, 60);
                        Object v23 = (mxICell)  graph.insertVertex(parent, null,"23. Rủi ro chung" + "\n(" + Math.round(this.riskProbability[22]*100) + "%)", 0, 0,
					150, 60);
                        
                        graph.insertEdge(parent, null, null, v1, v2);
                        graph.insertEdge(parent, null, null, v1, v3);
                        graph.insertEdge(parent, null, null, v1, v4);
                        
                        graph.insertEdge(parent, null, null, v2, v7);
                        graph.insertEdge(parent, null, null, v2, v8);
                        
                        graph.insertEdge(parent, null, null, v3, v9);
                        graph.insertEdge(parent, null, null, v3, v10);
                        graph.insertEdge(parent, null, null, v3, v14);
                        
                        graph.insertEdge(parent, null, null, v4, v8);
                        
                        graph.insertEdge(parent, null, null, v5, v9);
                        graph.insertEdge(parent, null, null, v5, v21);
                        
                        graph.insertEdge(parent, null,  null, v6, v19);

                        graph.insertEdge(parent, null, null, v7, v10);
                        
                        graph.insertEdge(parent, null, null, v8, v12);
                        graph.insertEdge(parent, null, null, v8, v15);
                        
                        graph.insertEdge(parent, null, null, v9, v12);
                        graph.insertEdge(parent, null, null, v9, v13);
                        
                        graph.insertEdge(parent, null, null, v10, v15);
                        
                        graph.insertEdge(parent, null, null, v11, v21);
                        graph.insertEdge(parent, null, null, v11, v22);

                        graph.insertEdge(parent, null, null, v12, v11);
                        graph.insertEdge(parent, null, null, v12, v13);
                        graph.insertEdge(parent, null, null, v12, v17);                                           
                        graph.insertEdge(parent, null, null, v12, v18);
                        
                        graph.insertEdge(parent, null, null, v13, v23);

                        graph.insertEdge(parent, null, null, v14, v20);
                        graph.insertEdge(parent, null, null, v14, v21);
                        
                        graph.insertEdge(parent, null, null, v15, v21);
                        graph.insertEdge(parent, null, null, v15, v22);
                        
                        graph.insertEdge(parent, null, null, v16, v22);
                       
                        graph.insertEdge(parent, null, null, v17, v22);
                        
                        graph.insertEdge(parent, null, null, v18, v23);
                                               
                        graph.insertEdge(parent, null, null, v19, v23);
                        
                        graph.insertEdge(parent, null, null, v20, v23);
                        
                        graph.insertEdge(parent, null, null, v21, v23);
                        
                        graph.insertEdge(parent, null, null, v22, v23);
                        
                        
                        
			
		}
		finally
		{
			graph.getModel().endUpdate();
		}
                mxIGraphLayout layout = new mxHierarchicalLayout(graph);
                layout.execute(graph.getDefaultParent());
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
    }
    public Double[] getRiskProbability() {
		Double[] riskProbability = new Double[23];
		
		try {
			// Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
			FileInputStream fis = new FileInputStream(this.fileName);
			DataInputStream dis = new DataInputStream(fis);

			// Bước 2: Đọc dữ liệu				
			for (int i = 0; i < 23; i++) {				
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

        RiskBayesNetGUI test = new RiskBayesNetGUI("m","D:/distribution/probability1.bin");
        test.setVisible(true);
    }
    
}
