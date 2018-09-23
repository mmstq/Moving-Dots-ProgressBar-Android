# Gif-ProgressBar-Android
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
	}

How To Use:

//Create a global variable

ProgressBarGIFDialog.Builder progressBarGIFDialog

//now initialise it in onCreate Method Of Your Activity

progressBarGIFDialog= new ProgressBarGIFDialog.Builder(MainActivity.this);
                progressBarGIFDialog.setCancelable(false)
                        .setTitleColor(R.color.colorPrimary)
                        .setLoadingGifID(R.drawable.loading)
                        .setDoneGifID(R.drawable.done)
                        .setDoneTitle("Nice Blyat")
                        .setLoadingTitle("Loading Your Content...")
                        .build();
           
// To Stop The Dialog 

    progressBarGIFDialog.clear();
