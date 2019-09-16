import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.media.jai.BorderExtenderConstant;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javas.io.ExtensionFilter;
import org.apache.commons.lang.math.NumberUtils;
import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.SeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;


public class mainForm extends javax.swing.JFrame {

    /** Creates new form mainForm */
    private javax.swing.ButtonGroup buttonGroup1;
 //   private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    
	private String myFilename = "";
	private String myBorderWidth = "";
	private Color myColor;
	private int counter1 = 0;
    private int counter2 = 0;


    public mainForm() {
        
        initComponents();
           jTabbedPane1.setEnabledAt(1, false);
           jTabbedPane1.setEnabledAt(2,false);
           jTabbedPane1.setEnabledAt(3, false);
       
    }
    
    public int getCounter1() {
        return counter1;
    }
    public void setCounter1(int counter1) {
        this.counter1 = counter1;
    }
    
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jColorChooser1 = new javax.swing.JColorChooser();
        jPanel4 = new javax.swing.JPanel();
    //  jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        
        


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Border Maker");
        setResizable(false);
       
        jTabbedPane1.setAutoscrolls(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
      
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("   Color Border");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("   Image Border");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton2.setText("Apply");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton2ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jButton2.setText("Apply");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton2)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        
        jFileChooser2.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);

        jTabbedPane1.addTab("Select", jPanel2);

        jFileChooser1.setEnabled(false);
        jTabbedPane1.addTab("Select Folder", jFileChooser1);

        jFileChooser2.setEnabled(false);
        jTabbedPane1.addTab("Select Image", jFileChooser2);

        jTabbedPane2.addTab("Select Color", jColorChooser1);

    //  jButton1.setText("Apply");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Border Width : ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
               //  .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(154, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
           //   .addComponent(jButton1)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Border Width", jPanel4);

        jTabbedPane1.addTab("Color/Width", jTabbedPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Border Width");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
          jTabbedPane1.setEnabledAt(2,false);
          jTabbedPane1.setEnabledAt(1,true);
          jTabbedPane1.setEnabledAt(3,true);
  
    }
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
           
           jTabbedPane1.setEnabledAt(3,false );
           jTabbedPane1.setEnabledAt(1,true);
           jTabbedPane1.setEnabledAt(2,true);
        
}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
    	
// TODO add your handling code here:
    	 if(jRadioButton1.isSelected()){
           
             boolean x = NumberUtils.isNumber(jTextField1.getText());
  
           if (x==true) {	

          		if(!new File(jFileChooser1.getSelectedFile().toString()+"\\processed Color Border").isDirectory()){
          			
            		boolean success = (new File(jFileChooser1.getSelectedFile().toString()+"\\processed Color Border")).mkdir();

          		}
          		
          		File dir = new File(jFileChooser1.getSelectedFile().toString());
                ExtensionFilter filter = new ExtensionFilter();

               	filter.addExtension("GIF");
               	filter.addExtension("gif");
                filter.addExtension("JPG");
                filter.addExtension("jpg");
                filter.addExtension("PNG");
                filter.addExtension("png");
                filter.addExtension("BMP");
                filter.addExtension("bmp");
                filter.addExtension("TIFF");
                filter.addExtension("tiff");
                
                String[] imageFiles = dir.list(filter);
               	double myProgress = 100/imageFiles.length;
               	
               	Color c = jColorChooser1.getColor();
               	        
                double r =  c.getRed();
               	double g =  c.getGreen();
               	double  b = c.getBlue();
               	
               	for(int i = 0; i < imageFiles.length; i++){    
           			
                    String sf =  imageFiles[i];
                    setMyFilename(jFileChooser1.getSelectedFile() +"\\"+ sf);
                    
                    PlanarImage inputFile = JAI.create("fileload",getMyFilename()); 
                    ParameterBlock params = new ParameterBlock();
                      	
                 	int a = Integer.parseInt(jTextField1.getText());
                   
                	params.addSource(inputFile);
                	params.add(a);//left pad
                	params.add(a);//right pad
                	params.add(a);//top pad
                	params.add(a);//bottom pad
                	
                  	double fill[] = {r , g , b};
                  	params.add(new BorderExtenderConstant(fill));//type
                	params.add(fill);//fill color
                	
                	PlanarImage output = JAI.create("border", params);
                	
                	//save the images in Folder name processed 
                	
                	JAI.create("filestore",output,jFileChooser1.getSelectedFile() +"\\processed Color Border\\"+sf,"JPEG"); 
                	
                	myProgress = myProgress+ myProgress;
                	jProgressBar1.setValue((int) myProgress);
                 }           ////  end for loop 
               	
               	jProgressBar1.setValue(1000/imageFiles.length);
         	
         	} //if no end */
       } // radio button   1  if end
    	 
    	 if(jRadioButton2.isSelected()){
    		 
    		 	File dir = new File(jFileChooser1.getSelectedFile().toString());
    	    	BufferedImage mi=null;
    	        String format = "jpg" ;
    	    	boolean success = new File(dir.getPath()+"\\Processed Image Border").mkdir();
    	    	
    	    	if(success == true) {
    	    
    	    	ExtensionFilter filter = new ExtensionFilter();
    	        filter.addExtension("GIF");
    	       	filter.addExtension("gif");
    	        filter.addExtension("JPG");
    	        filter.addExtension("jpg");
    	        filter.addExtension("PNG");
    	        filter.addExtension("png");
    	        filter.addExtension("BMP");
    	        filter.addExtension("bmp");
    	        filter.addExtension("TIFF");
    	        filter.addExtension("tiff");
    	        
    	        String[] imageFiles = dir.list(filter);

    	        BufferedImage bi = ImageIO.read(new File(jFileChooser2.getSelectedFile().toString()));
    	         
    	        for(int a=0 ; a < imageFiles.length ; a++){
    	        	
    	        	 String fileName = imageFiles[a];
    	             String formateName[]= fileName.split("\\.");
    	             format = formateName[1];
    	        	
    	         if( (format == "TIFF") || (format == "TIF")|| (format == "tiff") || (format == "tif")) {
    	        	 format = "tif";  
    		          SeekableStream s = new FileSeekableStream(imageFiles[a]);
    		          TIFFDecodeParam param = null;
    		          ImageDecoder dec = ImageCodec.createImageDecoder("tiff", s, param);
    		          mi = PlanarImage.wrapRenderedImage(dec.decodeAsRenderedImage()).getAsBufferedImage();
    	          
    	          }
    	          else
    	          {
    	              mi = ImageIO.read(new File(dir.getPath()+"\\"+ imageFiles[a]));
    	              format = formateName[1];
    	          } 
    	        	
    	         
    	       
    	        int [] bitest = bi.getRGB(0, 0, bi.getWidth(), bi.getHeight(), null, 0, bi.getWidth());
    	        int [][] bidata = new int [bi.getWidth()][bi.getHeight()];
    	        int [][] midata = new int [mi.getWidth()][mi.getHeight()];
    	        
    	        int bwidth = bi.getWidth();
    	        int bheight = bi.getHeight();
    	        
    	        for(int i = 0; i < bi.getWidth(); i++) {
    	            for(int j = 0; j < bi.getHeight(); j++){
    	                bidata[i][j] = bi.getRGB(i, j);
    	            }
    	        }
    	        for(int i = 0; i < mi.getWidth(); i++) {
    	            for(int j = 0; j < mi.getHeight(); j++){
    	                midata[i][j] = mi.getRGB(i, j);
    	            }
    	        }
    	        int width = bi.getWidth() + mi.getWidth() + bi.getWidth();
    	        int height = bi.getHeight() + mi.getHeight() +  bi.getHeight();
    	        BufferedImage ni = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    	        counter1 = 0;
    	        counter2 = 0;
    	        for(int i = bi.getWidth(); i < mi.getWidth()+ bi.getWidth(); i++, counter1++) {
    	            for(int j = bi.getHeight(); j < mi.getHeight() + bi.getHeight(); j++){
    	                ni.setRGB(i, j, midata[counter1][counter2]);
    	                counter2++;
    	            }
    	            counter2 = 0;
    	        }
    			for(int i=0; i < width - bwidth; i= i + bwidth) {
    	        	ni.setRGB(i, 0, bwidth, bheight, bitest, 0, bi.getWidth());
    			}
    			
    			for(int i=0; i < width - bwidth; i= i + bwidth) {
    	        	ni.setRGB(i, mi.getHeight() + bi.getHeight(), bwidth, bheight, bitest, 0, bi.getWidth());
    			}
    			
    			for(int i=0; i < height - bheight; i= i + bheight) {
    	            	ni.setRGB(0, i, bwidth, bheight, bitest, 0, bi.getWidth());
    	            	setCounter1(i);
    			}
    			
    			int myCount1 = this.counter1+bheight;
    			int myCount2 = height - myCount1;

    			ni.setRGB(0, this.counter1+bheight, bwidth, myCount2, bitest, 0, bi.getWidth());
    			
    			for(int i=0; i < height - bheight; i= i + bheight) {        	
    	        	ni.setRGB(mi.getWidth()+bi.getWidth(), i, bwidth, bheight, bitest, 0, bi.getWidth());
    	        	setCounter1(i);
    			}
    			myCount1 = this.counter1+bheight;
    			myCount2 = height - myCount1;
    			ni.setRGB(mi.getWidth() + bi.getWidth(), this.counter1+bheight, bwidth, myCount2, bitest, 0, bi.getWidth());
    			
    			
    			ImageIO.write(ni, format, new File(dir.getPath()+"\\Processed Image Border\\"+imageFiles[a]));
    			
    			mi =null; 

    	        }// close for outer most for loop 
    	        
               	jProgressBar1.setValue(1000/imageFiles.length);
    	    
    	    	}
    	 
    	 }  /// radio button 2 if end
}
    
    public void setMyFilename(String myFilename) {
		this.myFilename = myFilename;
	}
    
    public String getMyFilename() {
		return myFilename;
	}

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainForm().setVisible(true);
            }
        });
    }   
}
