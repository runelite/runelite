import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 974914631
   )
   public int field2820;
   @ObfuscatedName("i")
   public static NodeCache field2821 = new NodeCache(64);
   @ObfuscatedName("f")
   static IndexDataBase field2822;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2088441921
   )
   public int field2823;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1578280761
   )
   int field2824 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -55427937
   )
   public int field2825;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1068709481
   )
   public int field2826;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "273578395"
   )
   void method3532() {
      this.method3534(this.field2824);
   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(LWidget;I)I",
      garbageValue = "-128721427"
   )
   static int method3533(Widget var0) {
      class133 var1 = (class133)Client.widgetFlags.method2417((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.field1918:var0.field2291;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-334746683"
   )
   void method3534(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field2820 = (int)(var14 * 256.0D);
      this.field2825 = (int)(var16 * 256.0D);
      if(this.field2820 < 0) {
         this.field2820 = 0;
      } else if(this.field2820 > 255) {
         this.field2820 = 255;
      }

      if(this.field2825 < 0) {
         this.field2825 = 0;
      } else if(this.field2825 > 255) {
         this.field2825 = 255;
      }

      if(var16 > 0.5D) {
         this.field2826 = (int)(512.0D * var14 * (1.0D - var16));
      } else {
         this.field2826 = (int)(var14 * var16 * 512.0D);
      }

      if(this.field2826 < 1) {
         this.field2826 = 1;
      }

      this.field2823 = (int)((double)this.field2826 * var12);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "535015862"
   )
   void method3538(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field2824 = var1.read24BitInt();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2103980261"
   )
   void method3544(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3538(var1, var3, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-52"
   )
   public static void method3547(boolean var0) {
      if(var0 != class109.isMembersWorld) {
         ItemComposition.field2952.reset();
         ItemComposition.itemModelCache.reset();
         ItemComposition.itemSpriteCache.reset();
         class109.isMembersWorld = var0;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "773457321"
   )
   public static int method3548(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var9;
            if(var8 >= 48 && var8 <= 57) {
               var9 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var9 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var9 = var8 - 87;
            }

            if(var9 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var9 = -var9;
            }

            int var10 = var9 + var1 * var5;
            if(var5 != var10 / var1) {
               throw new NumberFormatException();
            }

            var5 = var10;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
