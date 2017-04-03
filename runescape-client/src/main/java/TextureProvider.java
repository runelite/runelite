import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("TextureProvider")
public class TextureProvider implements class93 {
   @ObfuscatedName("i")
   Deque field1220 = new Deque();
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 386195965
   )
   int field1222 = 0;
   @ObfuscatedName("r")
   double field1223 = 1.0D;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1384363033
   )
   int field1224 = 128;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 378637565
   )
   int field1227;
   @ObfuscatedName("f")
   class79[] field1229;
   @ObfuscatedName("l")
   IndexDataBase field1230;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method1462(double var1) {
      this.field1223 = var1;
      this.method1467();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public boolean vmethod1941(int var1) {
      return this.field1224 == 64;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-619491049"
   )
   public void method1467() {
      for(int var1 = 0; var1 < this.field1229.length; ++var1) {
         if(null != this.field1229[var1]) {
            this.field1229[var1].method1572();
         }
      }

      this.field1220 = new Deque();
      this.field1222 = this.field1227;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-37"
   )
   public void method1468(int var1) {
      for(int var2 = 0; var2 < this.field1229.length; ++var2) {
         class79 var3 = this.field1229[var2];
         if(var3 != null && var3.field1324 != 0 && var3.field1336) {
            var3.method1578(var1);
            var3.field1336 = false;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)LModIcon;",
      garbageValue = "-1325752410"
   )
   public static ModIcon method1472(IndexDataBase var0, int var1) {
      if(!class3.method27(var0, var1)) {
         return null;
      } else {
         ModIcon var3 = new ModIcon();
         var3.width = class225.field3231;
         var3.originalHeight = class146.field2038;
         var3.offsetX = class225.field3230[0];
         var3.offsetY = ItemComposition.field3003[0];
         var3.originalWidth = class225.field3232[0];
         var3.height = ChatLineBuffer.field994[0];
         var3.palette = class225.field3234;
         var3.pixels = BufferProvider.field3199[0];
         WidgetNode.method172();
         return var3;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "-55"
   )
   @Export("load")
   public int[] load(int var1) {
      class79 var2 = this.field1229[var1];
      if(var2 != null) {
         if(null != var2.field1335) {
            this.field1220.method2460(var2);
            var2.field1336 = true;
            return var2.field1335;
         }

         boolean var3 = var2.method1571(this.field1223, this.field1224, this.field1230);
         if(var3) {
            if(this.field1222 == 0) {
               class79 var4 = (class79)this.field1220.method2463();
               var4.method1572();
            } else {
               --this.field1222;
            }

            this.field1220.method2460(var2);
            var2.field1336 = true;
            return var2.field1335;
         }
      }

      return null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1733741580"
   )
   public int vmethod1942(int var1) {
      return null != this.field1229[var1]?this.field1229[var1].field1327:0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)LWorld;",
      garbageValue = "-44"
   )
   static World method1482() {
      return World.field697 < World.field708?World.worldList[++World.field697 - 1]:null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1098141878"
   )
   public boolean vmethod1946(int var1) {
      return this.field1229[var1].field1328;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "124"
   )
   public static void method1486() {
      class138.field1939.method2591();
      class138.field1940 = 1;
      class149.field2061 = null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIIZI)V",
      garbageValue = "1437163348"
   )
   public static void method1487(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class138.field1940 = 1;
      class149.field2061 = var0;
      class138.field1941 = var1;
      RSCanvas.field1777 = var2;
      NPC.field783 = var3;
      class138.field1938 = var4;
      class138.field1937 = 10000;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1408967591"
   )
   static final int method1488(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + var2 * (15731 * var2 * var2 + 789221) & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(IndexDataBase var1, IndexDataBase var2, int var3, double var4, int var6) {
      this.field1230 = var2;
      this.field1227 = var3;
      this.field1222 = this.field1227;
      this.field1223 = var4;
      this.field1224 = var6;
      int[] var7 = var1.method3345(0);
      int var8 = var7.length;
      this.field1229 = new class79[var1.method3346(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.field1229[var7[var9]] = new class79(var10);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "-1557655408"
   )
   static final void method1489(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class10.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = -Overlay.method3784(var4 + 932731 + var2, var3 + 556238 + var5) * 8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class0.overlayIds[var1][var2][var3] = var0.readByte();
               class3.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class109.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class10.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class10.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }
}
