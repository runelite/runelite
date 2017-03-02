import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -44419953
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1412982755
   )
   @Export("color")
   public int color = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1855101497
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1410927031
   )
   @Export("texture")
   public int texture = -1;
   @ObfuscatedName("k")
   @Export("isHidden")
   public boolean isHidden = true;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -383719373
   )
   public int field3050 = -1;
   @ObfuscatedName("b")
   public static class182 field3051;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -369313735
   )
   public int field3052;
   @ObfuscatedName("l")
   public static NodeCache field3053 = new NodeCache(64);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1110736153
   )
   public int field3054;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 908967609
   )
   public int field3055;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1802292113
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 1458966335
   )
   static int field3057;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "-1354095570"
   )
   void method3833(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.field3050 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2026707969"
   )
   public void method3836() {
      if(this.field3050 != -1) {
         this.method3837(this.field3050);
         this.field3054 = this.hue;
         this.field3055 = this.saturation;
         this.field3052 = this.lightness;
      }

      this.method3837(this.color);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1169270956"
   )
   void method3837(int var1) {
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

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(var12 * 256.0D);
      this.saturation = (int)(256.0D * var14);
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "506513826"
   )
   public void method3848(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3833(var1, var3, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1146755558"
   )
   public static int method3854(CharSequence var0) {
      return class152.method2838(var0, 10, true);
   }
}
