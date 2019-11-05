# ElgoPdf 
Step 1. Add the uses-permission in manifest file...
      
      manifest{
      <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
       }
  
Step 2. Add the JitPack repository to your build file

      allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency
      
      dependencies {
	        implementation 'com.github.mraheel48:ElgoPdf:1.0.1'
	}
      
# Usage!
Step 3. Go to MainActivity and create an obj of the createPdf..
	
	ArrayList<String> Category = new ArrayList<>();
	
    	@Override
    	protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
	
	Category.add("First");
        Category.add("First 1");
        Category.add("First 2");
        Category.add("First 3");
        Category.add("First 4");
	
	final createPdf obj = new createPdf(MainActivity.this);
	
        obj.setAttribute(null, null, null, null);
        obj.setData("ElgoByte", "11/05/2019");
        obj.setTable("Table_Name", "Column1_Name", Category);
	//Calling createPdf to create pdf
	obj.createPdf();
      
		
    	}
	
