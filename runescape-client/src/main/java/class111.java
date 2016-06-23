import java.awt.Image;
import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public class class111 {
   @ObfuscatedName("en")
   static class78[] field1959;
   @ObfuscatedName("u")
   static final String[] field1960 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("er")
   static class80[] field1962;
   @ObfuscatedName("x")
   static Calendar field1964;
   @ObfuscatedName("qv")
   static Image field1965;
   @ObfuscatedName("f")
   static final String[][] field1967 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;ZI)V",
      garbageValue = "2062169133"
   )
   public static void method2475(class167 var0, class167 var1, boolean var2) {
      class40.field969 = var0;
      class40.field951 = var1;
      class40.field974 = var2;
   }

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field1964 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "89"
   )
   static void method2477(String var0, String var1, String var2) {
      class31.field730 = var0;
      class31.field733 = var1;
      class31.field734 = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "285344101"
   )
   public static boolean method2479(char var0) {
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         return true;
      } else {
         if(var0 != 0) {
            char[] var1 = class165.field2659;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var3 == var0) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-1461437221"
   )
   static int method2480(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = 1 + (var0 << 4);
      }

      return var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass168;IB)V",
      garbageValue = "114"
   )
   static void method2481(class168 var0, int var1) {
      if(class171.field2727 != null) {
         class171.field2727.field1998 = 5 + 8 * var1;
         int var2 = class171.field2727.method2696();
         int var3 = class171.field2727.method2696();
         var0.method3369(var2, var3);
      } else {
         class50.method1072((class168)null, 255, 255, 0, (byte)0, true);
         class171.field2728[var1] = var0;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(CB)B",
      garbageValue = "-46"
   )
   public static byte method2482(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }
}
