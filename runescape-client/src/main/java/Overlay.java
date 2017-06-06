import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 181602479
   )
   public int field3582;
   @ObfuscatedName("c")
   static NodeCache field3583;
   @ObfuscatedName("b")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 154216053
   )
   public int field3585;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1345183575
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("i")
   public static IndexDataBase field3587;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 263567549
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1436593653
   )
   @Export("color")
   public int color;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1701679545
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 632414307
   )
   public int field3591;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1912249967
   )
   public int field3592;
   @ObfuscatedName("cx")
   static IndexData field3594;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1104700891
   )
   @Export("saturation")
   public int saturation;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1508948101"
   )
   void method4672() {
      if(this.field3582 != -1) {
         this.method4675(this.field3582);
         this.field3591 = this.hue;
         this.field3592 = this.saturation;
         this.field3585 = this.lightness;
      }

      this.method4675(this.color);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void method4675(int var1) {
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
      double var16 = (var8 + var10) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(256.0D * var12);
      this.saturation = (int)(var14 * 256.0D);
      this.lightness = (int)(256.0D * var16);
      if(this.saturation < 0) {
         this.saturation = 0;
      } else if(this.saturation > 255) {
         this.saturation = 255;
      }

      if(this.lightness < 0) {
         this.lightness = 0;
      } else if(this.lightness > 255) {
         this.lightness = 255;
      }

   }

   static {
      field3583 = new NodeCache(64);
   }

   Overlay() {
      this.color = 0;
      this.texture = -1;
      this.isHidden = true;
      this.field3582 = -1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1277403909"
   )
   void method4676(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4679(var1, var3, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIB)V",
      garbageValue = "-94"
   )
   void method4679(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.field3582 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("i")
   public static String method4684(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class268.field3670[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
