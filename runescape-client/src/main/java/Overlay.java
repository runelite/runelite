import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 327504935
   )
   public int field3580;
   @ObfuscatedName("i")
   static IndexDataBase field3581;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1403977607
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("g")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1917221645
   )
   public int field3585;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1089800385
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -18783569
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -999131731
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1333698863
   )
   public int field3589;
   @ObfuscatedName("h")
   public static NodeCache field3590;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 886970679
   )
   public int field3591;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1379263725
   )
   @Export("color")
   public int color;

   Overlay() {
      this.color = 0;
      this.texture = -1;
      this.isHidden = true;
      this.field3580 = -1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "1323966564"
   )
   void method4735(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.field3580 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   static {
      field3590 = new NodeCache(64);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "18"
   )
   void method4738(int var1) {
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

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(256.0D * var12);
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "25117"
   )
   void method4742(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4735(var1, var3, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;I)I",
      garbageValue = "1652203529"
   )
   static int method4747(PacketBuffer var0) {
      int var1 = var0.method3470(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method3470(5);
      } else if(var1 == 2) {
         var2 = var0.method3470(8);
      } else {
         var2 = var0.method3470(11);
      }

      return var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-72"
   )
   void method4748() {
      if(this.field3580 != -1) {
         this.method4738(this.field3580);
         this.field3585 = this.hue;
         this.field3589 = this.saturation;
         this.field3591 = this.lightness;
      }

      this.method4738(this.color);
   }
}
