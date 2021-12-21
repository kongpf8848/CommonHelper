package io.github.kongpf8848.commonhelper;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkHelper {


    public static boolean isNetworkConnected(Context context){
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService(Activity.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return (networkInfo != null) && networkInfo.isConnected();
    }


    public static String getIP(Context context){
        String ip="";
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService(Activity.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if ((networkInfo != null) && networkInfo.isConnected()){
            int type=networkInfo.getType();
            switch (type){
                case ConnectivityManager.TYPE_WIFI:
                    ip = getIPForWIFI(context);
                    break;
                case ConnectivityManager.TYPE_MOBILE:
                    ip=getIPForMobile();
                    break;
            }
        }
        return ip;
    }

    private static String getIPForWIFI(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            int i = wifiInfo.getIpAddress();
            return int2ip(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getIPForMobile() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()) {
                        if (inetAddress instanceof Inet4Address) {
                            Inet4Address ipv4  = (Inet4Address)inetAddress;
                            return ipv4.getHostAddress();
                        }
                        else if(inetAddress instanceof Inet6Address){
                            Inet6Address ipv6=(Inet6Address)inetAddress;
                            return ipv6.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    private static String int2ip(int ipInt) {
        return (ipInt & 0xFF) + "." + ((ipInt >> 8) & 0xFF) + "." + ((ipInt >> 16) & 0xFF) + "." + ((ipInt >> 24) & 0xFF);
    }

}
