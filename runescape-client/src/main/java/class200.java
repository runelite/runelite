import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class200 extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1751809229
   )
   public int field3035;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1213517961
   )
   public int field3036 = 0;
   @ObfuscatedName("i")
   public static class182 field3037;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2060379517
   )
   public int field3038 = -1;
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
   public int field3041;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -517758039
   )
   public int field3042;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1648332807
   )
   public int field3043;
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
         this.field3036 = var1.read24BitInt();
      } else if(var2 == 2) {
         this.field3038 = var1.readUnsignedByte();
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
      this.field3041 = (int)(var12 * 256.0D);
      this.field3042 = (int)(var14 * 256.0D);
      this.field3043 = (int)(var16 * 256.0D);
      if(this.field3042 < 0) {
         this.field3042 = 0;
      } else if(this.field3042 > 255) {
         this.field3042 = 255;
      }

      if(this.field3043 < 0) {
         this.field3043 = 0;
      } else if(this.field3043 > 255) {
         this.field3043 = 255;
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
         this.field3044 = this.field3041;
         this.field3035 = this.field3042;
         this.field3046 = this.field3043;
      }

      this.method3664(this.field3036);
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
