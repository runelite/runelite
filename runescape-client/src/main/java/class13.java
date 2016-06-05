import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class13 implements Runnable {
   @ObfuscatedName("h")
   int[] field201 = new int[500];
   @ObfuscatedName("z")
   int[] field202 = new int[500];
   @ObfuscatedName("bn")
   static class168 field203;
   @ObfuscatedName("i")
   Object field204 = new Object();
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = -1706994621
   )
   @Export("cameraZ")
   static int field205;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -591855531
   )
   int field206 = 0;
   @ObfuscatedName("t")
   boolean field208 = true;

   public void run() {
      for(; this.field208; class45.method926(50L)) {
         Object var1 = this.field204;
         synchronized(this.field204) {
            if(this.field206 < 500) {
               this.field201[this.field206] = class140.field2192;
               this.field202[this.field206] = class140.field2189;
               ++this.field206;
            }
         }
      }

   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "([Lclass173;II)V",
      garbageValue = "238517311"
   )
   static final void method140(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(null != var3) {
            if(var3.field2778 == 0) {
               if(var3.field2770 != null) {
                  method140(var3.field2770, var1);
               }

               class3 var4 = (class3)client.field443.method3748((long)var3.field2776);
               if(null != var4) {
                  int var5 = var4.field65;
                  if(class173.method3380(var5)) {
                     method140(class216.field3168[var5], var1);
                  }
               }
            }

            class0 var6;
            if(var1 == 0 && null != var3.field2883) {
               var6 = new class0();
               var6.field2 = var3;
               var6.field5 = var3.field2883;
               class171.method3363(var6);
            }

            if(var1 == 1 && var3.field2884 != null) {
               if(var3.field2777 >= 0) {
                  class173 var7 = class170.method3344(var3.field2776);
                  if(null == var7 || null == var7.field2770 || var3.field2777 >= var7.field2770.length || var3 != var7.field2770[var3.field2777]) {
                     continue;
                  }
               }

               var6 = new class0();
               var6.field2 = var3;
               var6.field5 = var3.field2884;
               class171.method3363(var6);
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-1245459275"
   )
   public static byte method143(char var0) {
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2095577629"
   )
   public static int method144(int var0) {
      class47 var2 = (class47)class47.field1072.method3716((long)var0);
      class47 var1;
      if(null != var2) {
         var1 = var2;
      } else {
         byte[] var3 = class47.field1076.method3221(14, var0);
         var2 = new class47();
         if(var3 != null) {
            var2.method950(new class119(var3));
         }

         class47.field1072.method3724(var2, (long)var0);
         var1 = var2;
      }

      int var7 = var1.field1073;
      int var4 = var1.field1074;
      int var5 = var1.field1078;
      int var6 = class176.field2926[var5 - var4];
      return class176.field2923[var7] >> var4 & var6;
   }
}
