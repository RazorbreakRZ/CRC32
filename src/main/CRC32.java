/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.zip.Checksum;

/**
 *
 * @author Razorbreak
 */
public class CRC32 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre = args[0];
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        String str = nombre+c.get(Calendar.DATE)+c.get(Calendar.MONTH)+c.get(Calendar.YEAR)+c.get(Calendar.HOUR)+c.get(Calendar.MINUTE);
        byte bytes[] = str.getBytes();
        Checksum checksum = new java.util.zip.CRC32();
        checksum.update(bytes,0,bytes.length);
        long lngChecksum = checksum.getValue();
        System.out.println(lngChecksum);
    }
    
}
