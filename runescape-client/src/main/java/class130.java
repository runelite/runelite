import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public class class130 {
   @ObfuscatedName("x")
   static final class130 field2059 = new class130(2);
   @ObfuscatedName("u")
   public static final class130 field2060 = new class130(1);
   @ObfuscatedName("f")
   static final class130 field2061 = new class130(0);
   @ObfuscatedName("at")
   static class168 field2062;
   @ObfuscatedName("j")
   static int[] field2064;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1543432355
   )
   public final int field2065;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-48"
   )
   public static void method2845() {
      while(true) {
         class199 var1 = class170.field2707;
         class169 var0;
         synchronized(class170.field2707) {
            var0 = (class169)class170.field2704.method3853();
         }

         if(var0 == null) {
            return;
         }

         var0.field2699.method3367(var0.field2698, (int)var0.field3115, var0.field2696, false);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "780546663"
   )
   public static synchronized long method2846() {
      long var0 = System.currentTimeMillis();
      if(var0 < class115.field1979) {
         class115.field1981 += class115.field1979 - var0;
      }

      class115.field1979 = var0;
      return class115.field1981 + var0;
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-234442342"
   )
   static void method2848() {
      for(class3 var0 = (class3)client.field448.method3825(); null != var0; var0 = (class3)client.field448.method3823()) {
         int var1 = var0.field64;
         if(class135.method2897(var1)) {
            boolean var2 = true;
            class173[] var3 = class173.field2770[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].field2860;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.field3115;
               class173 var5 = class153.method3177(var4);
               if(var5 != null) {
                  class39.method818(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)[B",
      garbageValue = "-126"
   )
   public static byte[] method2850(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 <= 0 || var4 >= 128) && (var4 < 160 || var4 > 255)) {
            if(var4 == 8364) {
               var2[var3] = -128;
            } else if(var4 == 8218) {
               var2[var3] = -126;
            } else if(var4 == 402) {
               var2[var3] = -125;
            } else if(var4 == 8222) {
               var2[var3] = -124;
            } else if(var4 == 8230) {
               var2[var3] = -123;
            } else if(var4 == 8224) {
               var2[var3] = -122;
            } else if(var4 == 8225) {
               var2[var3] = -121;
            } else if(var4 == 710) {
               var2[var3] = -120;
            } else if(var4 == 8240) {
               var2[var3] = -119;
            } else if(var4 == 352) {
               var2[var3] = -118;
            } else if(var4 == 8249) {
               var2[var3] = -117;
            } else if(var4 == 338) {
               var2[var3] = -116;
            } else if(var4 == 381) {
               var2[var3] = -114;
            } else if(var4 == 8216) {
               var2[var3] = -111;
            } else if(var4 == 8217) {
               var2[var3] = -110;
            } else if(var4 == 8220) {
               var2[var3] = -109;
            } else if(var4 == 8221) {
               var2[var3] = -108;
            } else if(var4 == 8226) {
               var2[var3] = -107;
            } else if(var4 == 8211) {
               var2[var3] = -106;
            } else if(var4 == 8212) {
               var2[var3] = -105;
            } else if(var4 == 732) {
               var2[var3] = -104;
            } else if(var4 == 8482) {
               var2[var3] = -103;
            } else if(var4 == 353) {
               var2[var3] = -102;
            } else if(var4 == 8250) {
               var2[var3] = -101;
            } else if(var4 == 339) {
               var2[var3] = -100;
            } else if(var4 == 382) {
               var2[var3] = -98;
            } else if(var4 == 376) {
               var2[var3] = -97;
            } else {
               var2[var3] = 63;
            }
         } else {
            var2[var3] = (byte)var4;
         }
      }

      return var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-618308885"
   )
   public static int method2851(int var0) {
      class47 var1 = class36.method783(var0);
      int var2 = var1.field1083;
      int var3 = var1.field1079;
      int var4 = var1.field1080;
      int var5 = class176.field2904[var4 - var3];
      return class176.field2905[var2] >> var3 & var5;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BS)V",
      garbageValue = "17086"
   )
   public static void method2852(byte[] var0) {
      class119 var1 = new class119(var0);
      var1.field1998 = var0.length - 2;
      class76.field1399 = var1.method2556();
      class76.field1397 = new int[class76.field1399];
      class52.field1178 = new int[class76.field1399];
      class28.field690 = new int[class76.field1399];
      class31.field744 = new int[class76.field1399];
      class76.field1400 = new byte[class76.field1399][];
      var1.field1998 = var0.length - 7 - class76.field1399 * 8;
      class76.field1396 = var1.method2556();
      class76.field1398 = var1.method2556();
      int var2 = (var1.method2554() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class76.field1399; ++var3) {
         class76.field1397[var3] = var1.method2556();
      }

      for(var3 = 0; var3 < class76.field1399; ++var3) {
         class52.field1178[var3] = var1.method2556();
      }

      for(var3 = 0; var3 < class76.field1399; ++var3) {
         class28.field690[var3] = var1.method2556();
      }

      for(var3 = 0; var3 < class76.field1399; ++var3) {
         class31.field744[var3] = var1.method2556();
      }

      var1.field1998 = var0.length - 7 - class76.field1399 * 8 - (var2 - 1) * 3;
      class7.field135 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class7.field135[var3] = var1.method2558();
         if(class7.field135[var3] == 0) {
            class7.field135[var3] = 1;
         }
      }

      var1.field1998 = 0;

      for(var3 = 0; var3 < class76.field1399; ++var3) {
         int var4 = class28.field690[var3];
         int var5 = class31.field744[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class76.field1400[var3] = var7;
         int var8 = var1.method2554();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2538();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var4 * var10] = var1.method2538();
               }
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class130(int var1) {
      this.field2065 = var1;
   }
}
