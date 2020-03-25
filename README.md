# InternetChecking

=> Create a class named NetworkListener.java and extend it from BroadcastReceiver.

=> Create another class named MyApplication.java and extend it from Application. 
    This class will be called whenever app is launched. Here setConnectivityListener() method is used to 
    initiate the connectivity listener.
    
=>  In MainActivity.java calling MyApplication.getInstance().setConnectivityListener(this) inside onResume() method.

=> Implement the activity from NetworkListenerr.InternetListener which will override onNetworkConnectionChanged() method.

=> onNetworkConnectionChanged() method will be triggered whenever device is connected / disconnected from internet. 
    You need to take appropriate action here.
 
=> Open AndroidManifest.xml and do the below changes.
  > Add MyApplication to <application> tag.
  > Add ConnectivityReceiver as <receiver>.
  > Declare INTERNET and ACCESS_NETWORK_STATE permissions.
