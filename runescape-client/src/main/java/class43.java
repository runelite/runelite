import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class43 extends CacheableNode {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1009411105
   )
   public int field999;
   @ObfuscatedName("g")
   static NodeCache field1000 = new NodeCache(64);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 9577149
   )
   int field1001 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 922781491
   )
   public int field1003;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -922427135
   )
   public int field1004;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 601107371
   )
   public int field1005;
   @ObfuscatedName("l")
   public static class170 field1007;
   @ObfuscatedName("p")
   public static class62 field1010;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method889() {
      this.method892(this.field1001);
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)V",
      garbageValue = "-89"
   )
   static final void method890(String var0, int var1) {
      Client.field337.method2903(62);
      Client.field337.method2783(class54.method1165(var0) + 1);
      Client.field337.method2658(var1);
      Client.field337.method2703(var0);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "63"
   )
   void method892(int var1) {
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

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1003 = (int)(var14 * 256.0D);
      this.field1004 = (int)(var16 * 256.0D);
      if(this.field1003 < 0) {
         this.field1003 = 0;
      } else if(this.field1003 > 255) {
         this.field1003 = 255;
      }

      if(this.field1004 < 0) {
         this.field1004 = 0;
      } else if(this.field1004 > 255) {
         this.field1004 = 255;
      }

      if(var16 > 0.5D) {
         this.field1005 = (int)(512.0D * var14 * (1.0D - var16));
      } else {
         this.field1005 = (int)(var14 * var16 * 512.0D);
      }

      if(this.field1005 < 1) {
         this.field1005 = 1;
      }

      this.field999 = (int)((double)this.field1005 * var12);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1101142759"
   )
   public static void method896() {
      if(null != class143.mouse) {
         class143 var0 = class143.mouse;
         class143 var1 = class143.mouse;
         synchronized(class143.mouse) {
            class143.mouse = null;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIS)V",
      garbageValue = "22941"
   )
   void method897(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1001 = var1.method2637();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1929537231"
   )
   void method905(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2633();
         if(var3 == 0) {
            return;
         }

         this.method897(var1, var3, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "2"
   )
   public static String method906(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = Projectile.method108(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
