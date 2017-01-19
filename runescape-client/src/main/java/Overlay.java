import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1469664831
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -448860585
   )
   @Export("color")
   public int color = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 854134719
   )
   public int field3043;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 650468389
   )
   public int field3044 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -699428479
   )
   @Export("texture")
   public int texture = -1;
   @ObfuscatedName("c")
   public static NodeCache field3046 = new NodeCache(64);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 959611789
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -734800219
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1955924383
   )
   public int field3049;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -730063141
   )
   public int field3050;
   @ObfuscatedName("a")
   @Export("isHidden")
   public boolean isHidden = true;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-787436813"
   )
   public void method3596(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3600(var1, var3, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-526020515"
   )
   void method3597(int var1) {
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
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1782605632"
   )
   public void method3598() {
      if(this.field3044 != -1) {
         this.method3597(this.field3044);
         this.field3043 = this.hue;
         this.field3050 = this.saturation;
         this.field3049 = this.lightness;
      }

      this.method3597(this.color);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIB)V",
      garbageValue = "10"
   )
   void method3600(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.field3044 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "2037036491"
   )
   public static final boolean method3607(String var0, String var1, String var2, String var3) {
      return var0 != null && null != var2?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }
}
