import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("x")
   public boolean field1048 = false;
   @ObfuscatedName("d")
   public static class170 field1049;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2075103583
   )
   public static int field1050;
   @ObfuscatedName("r")
   static NodeCache field1051 = new NodeCache(64);
   @ObfuscatedName("t")
   int[] field1052;
   @ObfuscatedName("n")
   short[] field1053;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 368866195
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("i")
   short[] field1055;
   @ObfuscatedName("m")
   short[] field1056;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1167941069
   )
   public int field1057 = -1;
   @ObfuscatedName("k")
   int[] field1058 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("a")
   public static class170 field1059;
   @ObfuscatedName("kq")
   static class134 field1060;
   @ObfuscatedName("g")
   short[] field1061;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-47"
   )
   void method952(Buffer var1) {
      while(true) {
         int var2 = var1.method2528();
         if(var2 == 0) {
            return;
         }

         this.method963(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "66"
   )
   @Export("ready")
   public boolean ready() {
      if(this.field1052 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1052.length; ++var2) {
            if(!field1049.method3351(this.field1052[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)LModelData;",
      garbageValue = "16502"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(null == this.field1052) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field1052.length];

         for(int var2 = 0; var2 < this.field1052.length; ++var2) {
            var1[var2] = ModelData.method2284(field1049, this.field1052[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(null != this.field1053) {
            for(var3 = 0; var3 < this.field1053.length; ++var3) {
               var4.method2239(this.field1053[var3], this.field1055[var3]);
            }
         }

         if(null != this.field1061) {
            for(var3 = 0; var3 < this.field1061.length; ++var3) {
               var4.method2240(this.field1061[var3], this.field1056[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "695450046"
   )
   void method963(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1057 = var1.method2528();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2528();
            this.field1052 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1052[var4] = var1.method2717();
            }
         } else if(var2 == 3) {
            this.field1048 = true;
         } else if(var2 == 40) {
            var3 = var1.method2528();
            this.field1053 = new short[var3];
            this.field1055 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1053[var4] = (short)var1.method2717();
               this.field1055[var4] = (short)var1.method2717();
            }
         } else if(var2 == 41) {
            var3 = var1.method2528();
            this.field1061 = new short[var3];
            this.field1056 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1061[var4] = (short)var1.method2717();
               this.field1056[var4] = (short)var1.method2717();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1058[var2 - 60] = var1.method2717();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public static String method967(CharSequence var0) {
      return class4.method48('*', var0.length());
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1980858433"
   )
   public boolean method970() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1058[var2] != -1 && !field1049.method3351(this.field1058[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "420176363"
   )
   public ModelData method972() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field1058[var3] != -1) {
            var1[var2++] = ModelData.method2284(field1049, this.field1058[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(this.field1053 != null) {
         for(var4 = 0; var4 < this.field1053.length; ++var4) {
            var5.method2239(this.field1053[var4], this.field1055[var4]);
         }
      }

      if(null != this.field1061) {
         for(var4 = 0; var4 < this.field1061.length; ++var4) {
            var5.method2240(this.field1061[var4], this.field1056[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "-1738377281"
   )
   static final void method978(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2528();
            if(var7 == 0) {
               if(var1 == 0) {
                  class5.tileHeights[0][var2][var3] = -Player.method37(932731 + var2 + var4, var3 + 556238 + var5) * 8;
               } else {
                  class5.tileHeights[var1][var2][var3] = class5.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.method2528();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class5.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class5.tileHeights[var1][var2][var3] = class5.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class26.field653[var1][var2][var3] = var0.method2529();
               class93.field1649[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class5.field80[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class5.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field79[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2528();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.method2528();
               break;
            }

            if(var7 <= 49) {
               var0.method2528();
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "27"
   )
   public static int method979(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }
}
