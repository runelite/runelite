import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("g")
   public static NodeCache field3030 = new NodeCache(64);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1357469201
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1841412093
   )
   @Export("color")
   public int color = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 482026771
   )
   @Export("texture")
   public int texture = -1;
   @ObfuscatedName("d")
   @Export("isHidden")
   public boolean isHidden = true;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1703510931
   )
   public int field3035 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2098983885
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("p")
   public static class182 field3037;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2143510523
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1775646057
   )
   public int field3039;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 342323871
   )
   public int field3040;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1652420199
   )
   public int field3041;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "1708464539"
   )
   void method3729(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.field3035 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-102"
   )
   public void method3734(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3729(var1, var3, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2014721681"
   )
   public void method3742() {
      if(this.field3035 != -1) {
         this.method3744(this.field3035);
         this.field3039 = this.hue;
         this.field3040 = this.saturation;
         this.field3041 = this.lightness;
      }

      this.method3744(this.color);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-48"
   )
   void method3744(int var1) {
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
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(256.0D * var12);
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)[LModIcon;",
      garbageValue = "-1388230067"
   )
   static ModIcon[] method3745(class182 var0, int var1, int var2) {
      return !class196.method3575(var0, var1, var2)?null:KitDefinition.method3510();
   }
}
