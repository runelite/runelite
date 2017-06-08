import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("Overlay")
public class Overlay extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 489869697
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("p")
   public static NodeCache field3596;
   @ObfuscatedName("f")
   @Export("isHidden")
   public boolean isHidden;
   @ObfuscatedName("n")
   static IndexDataBase field3598;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -574299461
   )
   @Export("texture")
   public int texture;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -289654855
   )
   public int field3600;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1853567877
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1478305867
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -727210359
   )
   @Export("color")
   public int color;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1700721245
   )
   public int field3604;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1892405705
   )
   public int field3605;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1991603655
   )
   public int field3606;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-920033068"
   )
   void method4696() {
      if(this.field3600 != -1) {
         this.method4699(this.field3600);
         this.field3604 = this.hue;
         this.field3605 = this.saturation;
         this.field3606 = this.lightness;
      }

      this.method4699(this.color);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "53"
   )
   void method4697(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4698(var1, var3, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIB)V",
      garbageValue = "3"
   )
   void method4698(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.color = var1.read24BitInt();
      } else if(var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.isHidden = false;
      } else if(var2 == 7) {
         this.field3600 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2089216833"
   )
   void method4699(int var1) {
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
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(var12 * 256.0D);
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
      field3596 = new NodeCache(64);
   }

   Overlay() {
      this.color = 0;
      this.texture = -1;
      this.isHidden = true;
      this.field3600 = -1;
   }
}
