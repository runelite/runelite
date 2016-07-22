import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class45 extends class207 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2030730803
   )
   int field1025 = 128;
   @ObfuscatedName("w")
   static class170 field1026;
   @ObfuscatedName("e")
   public static class196 field1027 = new class196(64);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1105791821
   )
   public int field1028 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1822392973
   )
   int field1029;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 82691909
   )
   int field1030;
   @ObfuscatedName("v")
   short[] field1031;
   @ObfuscatedName("o")
   public static class196 field1032 = new class196(30);
   @ObfuscatedName("x")
   short[] field1033;
   @ObfuscatedName("k")
   short[] field1034;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2060735611
   )
   int field1035 = 0;
   @ObfuscatedName("r")
   short[] field1037;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2005455739
   )
   int field1038 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1818169829
   )
   int field1039 = 0;
   @ObfuscatedName("m")
   static class170 field1040;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1174268283
   )
   int field1043 = 128;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "23"
   )
   void method940(class122 var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method941(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "-1721892973"
   )
   void method941(class122 var1, int var2) {
      if(var2 == 1) {
         this.field1030 = var1.method2706();
      } else if(var2 == 2) {
         this.field1028 = var1.method2706();
      } else if(var2 == 4) {
         this.field1043 = var1.method2706();
      } else if(var2 == 5) {
         this.field1025 = var1.method2706();
      } else if(var2 == 6) {
         this.field1038 = var1.method2706();
      } else if(var2 == 7) {
         this.field1039 = var1.method2556();
      } else if(var2 == 8) {
         this.field1035 = var1.method2556();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2556();
            this.field1037 = new short[var3];
            this.field1033 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1037[var4] = (short)var1.method2706();
               this.field1033[var4] = (short)var1.method2706();
            }
         } else if(var2 == 41) {
            var3 = var1.method2556();
            this.field1034 = new short[var3];
            this.field1031 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1034[var4] = (short)var1.method2706();
               this.field1031[var4] = (short)var1.method2706();
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Lclass108;",
      garbageValue = "104"
   )
   public final class108 method942(int var1) {
      class108 var2 = (class108)field1032.method3817((long)this.field1029);
      if(null == var2) {
         class103 var3 = class103.method2323(field1026, this.field1030, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field1037 != null) {
            for(var4 = 0; var4 < this.field1037.length; ++var4) {
               var3.method2317(this.field1037[var4], this.field1033[var4]);
            }
         }

         if(this.field1034 != null) {
            for(var4 = 0; var4 < this.field1034.length; ++var4) {
               var3.method2298(this.field1034[var4], this.field1031[var4]);
            }
         }

         var2 = var3.method2305(this.field1039 + 64, this.field1035 + 850, -30, -50, -30);
         field1032.method3823(var2, (long)this.field1029);
      }

      class108 var5;
      if(this.field1028 != -1 && var1 != -1) {
         var5 = class28.method646(this.field1028).method912(var2, var1);
      } else {
         var5 = var2.method2369(true);
      }

      if(this.field1043 != 128 || this.field1025 != 128) {
         var5.method2395(this.field1043, this.field1025, this.field1043);
      }

      if(this.field1038 != 0) {
         if(this.field1038 == 90) {
            var5.method2376();
         }

         if(this.field1038 == 180) {
            var5.method2376();
            var5.method2376();
         }

         if(this.field1038 == 270) {
            var5.method2376();
            var5.method2376();
            var5.method2376();
         }
      }

      return var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "108"
   )
   static void method958(byte[] var0) {
      class122 var1 = new class122(var0);
      var1.field2045 = var0.length - 2;
      class79.field1456 = var1.method2706();
      class79.field1459 = new int[class79.field1456];
      class79.field1460 = new int[class79.field1456];
      class79.field1463 = new int[class79.field1456];
      class117.field2021 = new int[class79.field1456];
      class10.field151 = new byte[class79.field1456][];
      var1.field2045 = var0.length - 7 - class79.field1456 * 8;
      class79.field1457 = var1.method2706();
      class79.field1458 = var1.method2706();
      int var2 = (var1.method2556() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class79.field1456; ++var3) {
         class79.field1459[var3] = var1.method2706();
      }

      for(var3 = 0; var3 < class79.field1456; ++var3) {
         class79.field1460[var3] = var1.method2706();
      }

      for(var3 = 0; var3 < class79.field1456; ++var3) {
         class79.field1463[var3] = var1.method2706();
      }

      for(var3 = 0; var3 < class79.field1456; ++var3) {
         class117.field2021[var3] = var1.method2706();
      }

      var1.field2045 = var0.length - 7 - class79.field1456 * 8 - (var2 - 1) * 3;
      class79.field1462 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class79.field1462[var3] = var1.method2576();
         if(class79.field1462[var3] == 0) {
            class79.field1462[var3] = 1;
         }
      }

      var1.field2045 = 0;

      for(var3 = 0; var3 < class79.field1456; ++var3) {
         int var4 = class79.field1463[var3];
         int var5 = class117.field2021[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class10.field151[var3] = var7;
         int var8 = var1.method2556();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2573();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var4 * var10 + var9] = var1.method2573();
               }
            }
         }
      }

   }
}
