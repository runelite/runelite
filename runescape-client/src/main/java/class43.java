import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class43 extends CacheableNode {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1908485451
   )
   public int field998;
   @ObfuscatedName("d")
   public static NodeCache field999 = new NodeCache(64);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -596255703
   )
   int field1000 = 0;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = 1847055997
   )
   static int field1001;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 463847891
   )
   public int field1002;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -517925765
   )
   public int field1003;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1818457405
   )
   public int field1004;
   @ObfuscatedName("a")
   public static class170 field1008;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "866769696"
   )
   void method885(int var1) {
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
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1002 = (int)(256.0D * var14);
      this.field1003 = (int)(var16 * 256.0D);
      if(this.field1002 < 0) {
         this.field1002 = 0;
      } else if(this.field1002 > 255) {
         this.field1002 = 255;
      }

      if(this.field1003 < 0) {
         this.field1003 = 0;
      } else if(this.field1003 > 255) {
         this.field1003 = 255;
      }

      if(var16 > 0.5D) {
         this.field1004 = (int)(var14 * (1.0D - var16) * 512.0D);
      } else {
         this.field1004 = (int)(512.0D * var16 * var14);
      }

      if(this.field1004 < 1) {
         this.field1004 = 1;
      }

      this.field998 = (int)((double)this.field1004 * var12);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "25673"
   )
   public void method886() {
      this.method885(this.field1000);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-85"
   )
   public void method887(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2528();
         if(var3 == 0) {
            return;
         }

         this.method890(var1, var3, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "-994595135"
   )
   void method890(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1000 = var1.method2532();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1961921425"
   )
   public static void method897() {
      class143 var0 = class143.mouse;
      synchronized(class143.mouse) {
         class143.field2220 = class143.field2217;
         class143.field2225 = class143.field2218;
         class143.field2222 = class143.field2219;
         class143.field2227 = class143.field2215;
         class143.field2223 = class143.field2224;
         class143.field2226 = class143.field2221;
         class143.field2230 = class143.field2216;
         class143.field2215 = 0;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)[Lclass157;",
      garbageValue = "80"
   )
   public static class157[] method898() {
      return new class157[]{class157.field2355, class157.field2348, class157.field2349, class157.field2350, class157.field2352, class157.field2351};
   }
}
