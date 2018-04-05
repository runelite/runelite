import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public enum class27 implements Enumerated {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field400(3, (byte)0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field401(1, (byte)1),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field399(0, (byte)2),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field402(2, (byte)3);

   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1019907041
   )
   final int field403;
   @ObfuscatedName("m")
   final byte field404;

   class27(int var3, byte var4) {
      this.field403 = var3;
      this.field404 = var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-369819377"
   )
   public int rsOrdinal() {
      return this.field404;
   }

   @ObfuscatedName("o")
   public static final int method248(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(var2 != 0.0D) {
         double var12;
         if(var4 < 0.5D) {
            var12 = (var2 + 1.0D) * var4;
         } else {
            var12 = var4 + var2 - var2 * var4;
         }

         double var14 = var4 * 2.0D - var12;
         double var16 = 0.3333333333333333D + var0;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(6.0D * var16 < 1.0D) {
            var6 = (var12 - var14) * 6.0D * var16 + var14;
         } else if(2.0D * var16 < 1.0D) {
            var6 = var12;
         } else if(var16 * 3.0D < 2.0D) {
            var6 = var14 + (0.6666666666666666D - var16) * (var12 - var14) * 6.0D;
         } else {
            var6 = var14;
         }

         if(var0 * 6.0D < 1.0D) {
            var8 = var14 + var0 * 6.0D * (var12 - var14);
         } else if(var0 * 2.0D < 1.0D) {
            var8 = var12;
         } else if(3.0D * var0 < 2.0D) {
            var8 = (var12 - var14) * (0.6666666666666666D - var0) * 6.0D + var14;
         } else {
            var8 = var14;
         }

         if(6.0D * var20 < 1.0D) {
            var10 = (var12 - var14) * 6.0D * var20 + var14;
         } else if(2.0D * var20 < 1.0D) {
            var10 = var12;
         } else if(3.0D * var20 < 2.0D) {
            var10 = var14 + 6.0D * (0.6666666666666666D - var20) * (var12 - var14);
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(256.0D * var6);
      int var13 = (int)(var8 * 256.0D);
      int var23 = (int)(256.0D * var10);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2132202363"
   )
   static int method247(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)[Lap;",
      garbageValue = "8"
   )
   static class27[] method243() {
      return new class27[]{field399, field401, field400, field402};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "725530252"
   )
   static final void method245(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2905(var0, var1, var2);
      int[] var8 = Region.method2905(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(Lin;B)Z",
      garbageValue = "-38"
   )
   static final boolean method246(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class308.method5486(var0, var1);
            int var3 = var0.field2936[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(Lin;III)V",
      garbageValue = "1053264788"
   )
   static final void method239(Widget var0, int var1, int var2) {
      if(Client.draggedWidget == null && !Client.isMenuOpen) {
         if(var0 != null && WorldMapRegion.method533(var0) != null) {
            Client.draggedWidget = var0;
            Client.field937 = WorldMapRegion.method533(var0);
            Client.field1042 = var1;
            Client.field1114 = var2;
            class55.field660 = 0;
            Client.draggingWidget = false;
            int var3 = Client.menuOptionCount - 1;
            if(var3 != -1) {
               class22.method184(var3);
            }

         }
      }
   }
}
