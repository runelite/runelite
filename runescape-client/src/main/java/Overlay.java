import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 781754687
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -672958447
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1254273969
   )
   @Export("color")
   public int color;
   @ObfuscatedName("w")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("p")
   public static IndexDataBase field3594;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1928157231
   )
   public int field3595;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1927181109
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("m")
   static NodeCache field3597;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1130968679
   )
   public int field3598;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 327861065
   )
   public int field3599;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 776026573
   )
   public int field3600;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1142630739
   )
   @Export("texture")
   public int texture;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "875341598"
   )
   void method4554() {
      if(this.field3595 != -1) {
         this.method4557(this.field3595);
         this.field3599 = this.hue;
         this.field3600 = this.saturation;
         this.field3598 = this.lightness;
      }

      this.method4557(this.color);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1563462737"
   )
   void method4555(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4556(var1, var3, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIB)V",
      garbageValue = "0"
   )
   void method4556(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.field3595 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1790699713"
   )
   void method4557(int var1) {
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
      this.hue = (int)(256.0D * var12);
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

   static {
      field3597 = new NodeCache(64);
   }

   Overlay() {
      this.color = 0;
      this.texture = -1;
      this.isHidden = true;
      this.field3595 = -1;
   }
}
