import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1551630633
   )
   public int field3070;
   @ObfuscatedName("c")
   public static NodeCache field3071;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1065801847
   )
   public int field3072;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 490827921
   )
   @Export("color")
   public int color;
   @ObfuscatedName("t")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 903854521
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1331172309
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1268460469
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1631152495
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 956550309
   )
   public int field3079;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 420245413
   )
   public int field3080;
   @ObfuscatedName("d")
   public static IndexDataBase field3081;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "55"
   )
   public void method3837() {
      if(this.field3079 != -1) {
         this.method3840(this.field3079);
         this.field3072 = this.hue;
         this.field3080 = this.saturation;
         this.field3070 = this.lightness;
      }

      this.method3840(this.color);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2113956728"
   )
   public void method3839(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3856(var1, var3, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "123956553"
   )
   void method3840(int var1) {
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

   public Overlay() {
      this.color = 0;
      this.texture = -1;
      this.isHidden = true;
      this.field3079 = -1;
   }

   static {
      field3071 = new NodeCache(64);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "-839232130"
   )
   void method3856(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.field3079 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }
}
