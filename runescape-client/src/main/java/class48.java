import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class48 extends CacheableNode {
   @ObfuscatedName("d")
   public static NodeCache field1072 = new NodeCache(64);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 493689463
   )
   public int field1074 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1407235369
   )
   public int field1075 = -1;
   @ObfuscatedName("z")
   public boolean field1076 = true;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1469232931
   )
   public int field1077 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1191980641
   )
   public int field1079;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1113774111
   )
   public int field1080;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 933864923
   )
   public int field1081;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -831647027
   )
   public int field1082;
   @ObfuscatedName("a")
   static class170 field1084;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2027386267
   )
   public int field1086;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 465905077
   )
   public int field1087;
   @ObfuscatedName("dn")
   static int[] field1089;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1917868729"
   )
   void method996(int var1) {
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
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1086 = (int)(var12 * 256.0D);
      this.field1079 = (int)(var14 * 256.0D);
      this.field1080 = (int)(256.0D * var16);
      if(this.field1079 < 0) {
         this.field1079 = 0;
      } else if(this.field1079 > 255) {
         this.field1079 = 255;
      }

      if(this.field1080 < 0) {
         this.field1080 = 0;
      } else if(this.field1080 > 255) {
         this.field1080 = 255;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-109015197"
   )
   void method997() {
      if(this.field1077 != -1) {
         this.method996(this.field1077);
         this.field1081 = this.field1086;
         this.field1082 = this.field1079;
         this.field1087 = this.field1080;
      }

      this.method996(this.field1074);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "1186197918"
   )
   void method1004(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1074 = var1.method2532();
      } else if(var2 == 2) {
         this.field1075 = var1.method2528();
      } else if(var2 == 5) {
         this.field1076 = false;
      } else if(var2 == 7) {
         this.field1077 = var1.method2532();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-779573338"
   )
   void method1006(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2528();
         if(var3 == 0) {
            return;
         }

         this.method1004(var1, var3, var2);
      }
   }
}
