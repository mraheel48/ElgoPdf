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
	        implementation 'com.github.mraheel48:ElgoPdf:1.0.0'
	}
      
# Usage!
Step 3. Go to MainActivity and create an obj of the createPdf..

	 @Override
    	protected void onCreate(Bundle savedInstanceState) {
    
   	 final createPdf obj = new createPdf(MainActivity.this);
	//and call the obj of any think for testing
	obj.pdfTest();
	
	    }
	
