# 

![Alt text](Gif-ProgressBar-Android/ezgif.com-video-to-gif.gif ?raw=true "Gif-ProgressBar-Android")


Material Design GIF Progress Bar Dialog With Customisation

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file


Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Copy

Step 2. Add the dependency

	dependencies {
                
	        implementation 'com.github.mmstq:Gif-ProgressBar-Android:1.0'
		implementation 'com.android.support:cardview-v7:27.1.1' // Cardview is necessary. Neglect if already have.
	}

How To Use:

//Create a global variable

ProgressBarGIFDialog.Builder progressBarGIFDialog

//now initialise it in onCreate Method Of Your Activity

progressBarGIFDialog= new ProgressBarGIFDialog.Builder(context);

                progressBarGIFDialog.setCancelable(false) 
			
                        .setTitleColor(R.color.colorPrimary) // Set Title Color (int only)
			
                        .setLoadingGif(R.drawable.loading) // Set Loading Gif 
			
                        .setDoneGif(R.drawable.done) // Set Done Gif
			
                        .setDoneTitle("Nice Blyat") // Set Done Title
			
                        .setLoadingTitle("Loading Your Content...") // Set Loading Title
			
                        .build();
           
// To Stop The Dialog 

    progressBarGIFDialog.clear(); // This will set Done Gif & Done Title, then dialog will dismiss after 2.7 seconds
    
    
    // This library uses another library  
    
    'pl.droidsonroids.gif:android-gif-drawable:1.2.10'
    

