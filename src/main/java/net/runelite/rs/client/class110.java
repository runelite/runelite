package net.runelite.rs.client;

import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dr")
public class class110 {
   @ObfuscatedName("m")
   static final String[] field1936 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("f")
   static Calendar field1937;
   @ObfuscatedName("s")
   static class172 field1938;
   @ObfuscatedName("pd")
   static short[] field1939;
   @ObfuscatedName("j")
   static final String[][] field1941 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field1937 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
