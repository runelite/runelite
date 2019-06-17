import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("UnderlayDefinition")
public class UnderlayDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("UnderlayDefinition_indexCache")
   static AbstractIndexCache UnderlayDefinition_indexCache;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("UnderlayDefinition_cached")
   static EvictingDualNodeHashTable UnderlayDefinition_cached;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -635678213
   )
   @Export("rgb")
   int rgb;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1465372343
   )
   @Export("hue")
   public int hue;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2031118785
   )
   @Export("saturation")
   public int saturation;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1691813081
   )
   @Export("lightness")
   public int lightness;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1484542081
   )
   @Export("hueMultiplier")
   public int hueMultiplier;

   UnderlayDefinition() {
      this.rgb = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-782326269"
   )
   @Export("init")
   void init() {
      this.setHsl(this.rgb);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "-336010991"
   )
   @Export("read")
   void read(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.readNext(var1, var3, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgr;III)V",
      garbageValue = "137131494"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.rgb = var1.readMedium();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-107"
   )
   @Export("setHsl")
   void setHsl(int var1) {
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
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
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

      if(var16 > 0.5D) {
         this.hueMultiplier = (int)(var14 * (1.0D - var16) * 512.0D);
      } else {
         this.hueMultiplier = (int)(var16 * var14 * 512.0D);
      }

      if(this.hueMultiplier < 1) {
         this.hueMultiplier = 1;
      }

      this.hue = (int)((double)this.hueMultiplier * var12);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Lip;",
      garbageValue = "618327716"
   )
   static class249[] method4839() {
      return new class249[]{class249.field3277, class249.field3273, class249.field3274};
   }

   static {
      UnderlayDefinition_cached = new EvictingDualNodeHashTable(64);
   }
}
