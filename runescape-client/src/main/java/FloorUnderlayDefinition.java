import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1975442425
   )
   public int field3337;
   @ObfuscatedName("c")
   public static NodeCache field3338;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2003276359
   )
   int field3339;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2145115963
   )
   public int field3341;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1926734449
   )
   public int field3342;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 438713947
   )
   public int field3343;
   @ObfuscatedName("i")
   public static IndexDataBase field3345;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-68"
   )
   void method4352() {
      this.method4366(this.field3339);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "956960643"
   )
   void method4353(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4354(var1, var3, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIB)V",
      garbageValue = "-67"
   )
   void method4354(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field3339 = var1.read24BitInt();
      }

   }

   FloorUnderlayDefinition() {
      this.field3339 = 0;
   }

   static {
      field3338 = new NodeCache(64);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-31"
   )
   void method4366(int var1) {
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
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field3341 = (int)(256.0D * var14);
      this.field3343 = (int)(256.0D * var16);
      if(this.field3341 < 0) {
         this.field3341 = 0;
      } else if(this.field3341 > 255) {
         this.field3341 = 255;
      }

      if(this.field3343 < 0) {
         this.field3343 = 0;
      } else if(this.field3343 > 255) {
         this.field3343 = 255;
      }

      if(var16 > 0.5D) {
         this.field3342 = (int)(512.0D * (1.0D - var16) * var14);
      } else {
         this.field3342 = (int)(var14 * var16 * 512.0D);
      }

      if(this.field3342 < 1) {
         this.field3342 = 1;
      }

      this.field3337 = (int)((double)this.field3342 * var12);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)Z",
      garbageValue = "-36"
   )
   static boolean method4368(CharSequence var0, int var1, boolean var2) {
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

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  return false;
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var5 != var9 / var1) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
