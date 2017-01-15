import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1101158255
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("x")
   static NodeCache field3023 = new NodeCache(64);
   @ObfuscatedName("f")
   @Export("isHidden")
   public boolean field3025 = true;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1728351637
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -501719475
   )
   public int field3027 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2072331167
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("u")
   static class182 field3029;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -960098849
   )
   @Export("texture")
   public int texture = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -96317645
   )
   public int field3031;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -308624535
   )
   public int field3032;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 981794743
   )
   public int field3033;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -373011265
   )
   static int field3034;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2058708219
   )
   @Export("color")
   public int color = 0;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-450211652"
   )
   void method3728() {
      if(this.field3027 != -1) {
         this.method3731(this.field3027);
         this.field3031 = this.hue;
         this.field3032 = this.saturation;
         this.field3033 = this.lightness;
      }

      this.method3731(this.color);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1085950745"
   )
   void method3729(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3730(var1, var3, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIS)V",
      garbageValue = "13141"
   )
   void method3730(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.field3025 = false;
      } else if(var2 == 7) {
         this.field3027 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1877244043"
   )
   void method3731(int var1) {
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
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(var12 * 256.0D);
      this.saturation = (int)(256.0D * var14);
      this.lightness = (int)(var16 * 256.0D);
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
}
