import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
public class class52 extends CacheableNode {
   @ObfuscatedName("u")
   public int[] field1137;
   @ObfuscatedName("q")
   public static NodeCache field1138 = new NodeCache(64);
   @ObfuscatedName("f")
   public char field1139;
   @ObfuscatedName("c")
   public char field1140;
   @ObfuscatedName("k")
   public static class170 field1142;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2048725145
   )
   public int field1143;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1632349417
   )
   public int field1144 = 0;
   @ObfuscatedName("v")
   public String field1145 = "null";
   @ObfuscatedName("h")
   public String[] field1146;
   @ObfuscatedName("cy")
   static class227 field1149;
   @ObfuscatedName("y")
   public int[] field1150;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-317235912"
   )
   public void method1077(Buffer var1) {
      while(true) {
         int var2 = var1.method2571();
         if(var2 == 0) {
            return;
         }

         this.method1079(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-187112923"
   )
   static int method1078() {
      return ++class11.field166 - 1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1125880647"
   )
   void method1079(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1139 = (char)var1.method2571();
      } else if(var2 == 2) {
         this.field1140 = (char)var1.method2571();
      } else if(var2 == 3) {
         this.field1145 = var1.method2579();
      } else if(var2 == 4) {
         this.field1143 = var1.method2576();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1144 = var1.method2691();
            this.field1150 = new int[this.field1144];
            this.field1146 = new String[this.field1144];

            for(var3 = 0; var3 < this.field1144; ++var3) {
               this.field1150[var3] = var1.method2576();
               this.field1146[var3] = var1.method2579();
            }
         } else if(var2 == 6) {
            this.field1144 = var1.method2691();
            this.field1150 = new int[this.field1144];
            this.field1137 = new int[this.field1144];

            for(var3 = 0; var3 < this.field1144; ++var3) {
               this.field1150[var3] = var1.method2576();
               this.field1137[var3] = var1.method2576();
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "-1175677541"
   )
   public static int method1083(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var4 + var6] = -128;
            } else if(var7 == 8218) {
               var3[var4 + var6] = -126;
            } else if(var7 == 402) {
               var3[var4 + var6] = -125;
            } else if(var7 == 8222) {
               var3[var4 + var6] = -124;
            } else if(var7 == 8230) {
               var3[var6 + var4] = -123;
            } else if(var7 == 8224) {
               var3[var6 + var4] = -122;
            } else if(var7 == 8225) {
               var3[var4 + var6] = -121;
            } else if(var7 == 710) {
               var3[var6 + var4] = -120;
            } else if(var7 == 8240) {
               var3[var6 + var4] = -119;
            } else if(var7 == 352) {
               var3[var6 + var4] = -118;
            } else if(var7 == 8249) {
               var3[var6 + var4] = -117;
            } else if(var7 == 338) {
               var3[var4 + var6] = -116;
            } else if(var7 == 381) {
               var3[var4 + var6] = -114;
            } else if(var7 == 8216) {
               var3[var6 + var4] = -111;
            } else if(var7 == 8217) {
               var3[var6 + var4] = -110;
            } else if(var7 == 8220) {
               var3[var4 + var6] = -109;
            } else if(var7 == 8221) {
               var3[var6 + var4] = -108;
            } else if(var7 == 8226) {
               var3[var4 + var6] = -107;
            } else if(var7 == 8211) {
               var3[var6 + var4] = -106;
            } else if(var7 == 8212) {
               var3[var4 + var6] = -105;
            } else if(var7 == 732) {
               var3[var4 + var6] = -104;
            } else if(var7 == 8482) {
               var3[var4 + var6] = -103;
            } else if(var7 == 353) {
               var3[var6 + var4] = -102;
            } else if(var7 == 8250) {
               var3[var6 + var4] = -101;
            } else if(var7 == 339) {
               var3[var6 + var4] = -100;
            } else if(var7 == 382) {
               var3[var6 + var4] = -98;
            } else if(var7 == 376) {
               var3[var6 + var4] = -97;
            } else {
               var3[var4 + var6] = 63;
            }
         } else {
            var3[var6 + var4] = (byte)var7;
         }
      }

      return var5;
   }
}
