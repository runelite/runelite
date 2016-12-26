import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1751809229
   )
   public int field3035;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1213517961
   )
   @Export("color")
   public int color = 0;
   @ObfuscatedName("i")
   public static class182 field3037;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2060379517
   )
   @Export("texture")
   public int texture = -1;
   @ObfuscatedName("g")
   public boolean field3039 = true;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -677498591
   )
   public int field3040 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -336784201
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -517758039
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1648332807
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1725717051
   )
   public int field3044;
   @ObfuscatedName("e")
   public static NodeCache field3045 = new NodeCache(64);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1969251971
   )
   public int field3046;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = 487939899
   )
   static int field3047;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1520021541
   )
   static int field3048;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2046007464"
   )
   public void method3662(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3663(var1, var3, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "873488975"
   )
   void method3663(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.field3039 = false;
      } else if(var2 == 7) {
         this.field3040 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-26118"
   )
   void method3664(int var1) {
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
      this.hue = (int)(var12 * 256.0D);
      this.saturation = (int)(var14 * 256.0D);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1185412302"
   )
   public void method3672() {
      if(this.field3040 != -1) {
         this.method3664(this.field3040);
         this.field3044 = this.hue;
         this.field3035 = this.saturation;
         this.field3046 = this.lightness;
      }

      this.method3664(this.color);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[Lclass40;",
      garbageValue = "42"
   )
   static class40[] method3675() {
      return new class40[]{class40.field815, class40.field814, class40.field817, class40.field816};
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-1231529409"
   )
   public static int method3676(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
