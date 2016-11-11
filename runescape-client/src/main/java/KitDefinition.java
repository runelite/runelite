import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("y")
   int[] field1045 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("h")
   public static class170 field1046;
   @ObfuscatedName("g")
   static NodeCache field1047 = new NodeCache(64);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 261350617
   )
   public int field1048 = -1;
   @ObfuscatedName("u")
   int[] field1049;
   @ObfuscatedName("d")
   short[] field1050;
   @ObfuscatedName("l")
   short[] field1051;
   @ObfuscatedName("j")
   short[] field1053;
   @ObfuscatedName("i")
   public static class170 field1054;
   @ObfuscatedName("m")
   short[] field1056;
   @ObfuscatedName("s")
   public boolean field1060 = false;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1212662280"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.field1049 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field1049.length];

         for(int var2 = 0; var2 < this.field1049.length; ++var2) {
            var1[var2] = ModelData.method2245(field1046, this.field1049[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(this.field1050 != null) {
            for(var3 = 0; var3 < this.field1050.length; ++var3) {
               var4.method2315(this.field1050[var3], this.field1051[var3]);
            }
         }

         if(null != this.field1056) {
            for(var3 = 0; var3 < this.field1056.length; ++var3) {
               var4.method2258(this.field1056[var3], this.field1053[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-63"
   )
   public ModelData method953() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var5 = 0; var5 < 5; ++var5) {
         if(this.field1045[var5] != -1) {
            var1[var2++] = ModelData.method2245(field1046, this.field1045[var5], 0);
         }
      }

      ModelData var3 = new ModelData(var1, var2);
      int var4;
      if(this.field1050 != null) {
         for(var4 = 0; var4 < this.field1050.length; ++var4) {
            var3.method2315(this.field1050[var4], this.field1051[var4]);
         }
      }

      if(this.field1056 != null) {
         for(var4 = 0; var4 < this.field1056.length; ++var4) {
            var3.method2258(this.field1056[var4], this.field1053[var4]);
         }
      }

      return var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1035754984"
   )
   void method958(Buffer var1) {
      while(true) {
         int var2 = var1.method2544();
         if(var2 == 0) {
            return;
         }

         this.method959(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "686321066"
   )
   void method959(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1048 = var1.method2544();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2544();
            this.field1049 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1049[var4] = var1.method2546();
            }
         } else if(var2 == 3) {
            this.field1060 = true;
         } else if(var2 == 40) {
            var3 = var1.method2544();
            this.field1050 = new short[var3];
            this.field1051 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1050[var4] = (short)var1.method2546();
               this.field1051[var4] = (short)var1.method2546();
            }
         } else if(var2 == 41) {
            var3 = var1.method2544();
            this.field1056 = new short[var3];
            this.field1053 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1056[var4] = (short)var1.method2546();
               this.field1053[var4] = (short)var1.method2546();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1045[var2 - 60] = var1.method2546();
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1725343975"
   )
   @Export("ready")
   public boolean ready() {
      if(this.field1049 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1049.length; ++var2) {
            if(!field1046.method3291(this.field1049[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "1702290337"
   )
   public static int method966(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var4 + var6] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
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
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var4 + var6] = -119;
         } else if(var7 == 352) {
            var3[var4 + var6] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var4 + var6] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var4 + var6] = -110;
         } else if(var7 == 8220) {
            var3[var4 + var6] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var4 + var6] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var4 + var6] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var4 + var6] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var4 + var6] = -98;
         } else if(var7 == 376) {
            var3[var4 + var6] = -97;
         } else {
            var3[var4 + var6] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "37"
   )
   public boolean method968() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1045[var2] != -1 && !field1046.method3291(this.field1045[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }
}
