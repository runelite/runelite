import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public class class121 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2058610665
   )
   static int field1990 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 134517175
   )
   static int field1991 = 0;
   @ObfuscatedName("d")
   static byte[][] field1992 = new byte[1000][];
   @ObfuscatedName("t")
   static String[] field1993;
   @ObfuscatedName("y")
   static byte[][] field1994 = new byte[50][];
   @ObfuscatedName("x")
   static byte[][] field1995 = new byte[250][];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1439660829
   )
   static int field1996 = 0;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "-1843994206"
   )
   public static int method2776(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var1 + var6);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var4 + var6] = -128;
            } else if(var7 == 8218) {
               var3[var4 + var6] = -126;
            } else if(var7 == 402) {
               var3[var4 + var6] = -125;
            } else if(var7 == 8222) {
               var3[var6 + var4] = -124;
            } else if(var7 == 8230) {
               var3[var6 + var4] = -123;
            } else if(var7 == 8224) {
               var3[var4 + var6] = -122;
            } else if(var7 == 8225) {
               var3[var4 + var6] = -121;
            } else if(var7 == 710) {
               var3[var4 + var6] = -120;
            } else if(var7 == 8240) {
               var3[var4 + var6] = -119;
            } else if(var7 == 352) {
               var3[var6 + var4] = -118;
            } else if(var7 == 8249) {
               var3[var4 + var6] = -117;
            } else if(var7 == 338) {
               var3[var6 + var4] = -116;
            } else if(var7 == 381) {
               var3[var6 + var4] = -114;
            } else if(var7 == 8216) {
               var3[var4 + var6] = -111;
            } else if(var7 == 8217) {
               var3[var4 + var6] = -110;
            } else if(var7 == 8220) {
               var3[var6 + var4] = -109;
            } else if(var7 == 8221) {
               var3[var6 + var4] = -108;
            } else if(var7 == 8226) {
               var3[var4 + var6] = -107;
            } else if(var7 == 8211) {
               var3[var4 + var6] = -106;
            } else if(var7 == 8212) {
               var3[var6 + var4] = -105;
            } else if(var7 == 732) {
               var3[var4 + var6] = -104;
            } else if(var7 == 8482) {
               var3[var6 + var4] = -103;
            } else if(var7 == 353) {
               var3[var6 + var4] = -102;
            } else if(var7 == 8250) {
               var3[var4 + var6] = -101;
            } else if(var7 == 339) {
               var3[var6 + var4] = -100;
            } else if(var7 == 382) {
               var3[var6 + var4] = -98;
            } else if(var7 == 376) {
               var3[var6 + var4] = -97;
            } else {
               var3[var6 + var4] = 63;
            }
         } else {
            var3[var6 + var4] = (byte)var7;
         }
      }

      return var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-27"
   )
   static synchronized byte[] method2777(int var0) {
      byte[] var1;
      if(var0 == 100 && field1996 > 0) {
         var1 = field1992[--field1996];
         field1992[field1996] = null;
         return var1;
      } else if(var0 == 5000 && field1990 > 0) {
         var1 = field1995[--field1990];
         field1995[field1990] = null;
         return var1;
      } else if(var0 == 30000 && field1991 > 0) {
         var1 = field1994[--field1991];
         field1994[field1991] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass168;IIIBZI)V",
      garbageValue = "-2147483647"
   )
   static void method2779(class168 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class172 var8 = (class172)class171.field2720.method3807(var6);
      if(null == var8) {
         var8 = (class172)class171.field2712.method3807(var6);
         if(null == var8) {
            var8 = (class172)class171.field2715.method3807(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3889();
                  class171.field2720.method3797(var8, var6);
                  --class171.field2716;
                  ++class171.field2711;
               }

            } else {
               if(!var5) {
                  var8 = (class172)class171.field2717.method3807(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class172();
               var8.field2733 = var0;
               var8.field2736 = var3;
               var8.field2734 = var4;
               if(var5) {
                  class171.field2720.method3797(var8, var6);
                  ++class171.field2711;
               } else {
                  class171.field2728.method3873(var8);
                  class171.field2715.method3797(var8, var6);
                  ++class171.field2716;
               }

            }
         }
      }
   }
}
