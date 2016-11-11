import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class43 extends CacheableNode {
   @ObfuscatedName("h")
   public static NodeCache field996 = new NodeCache(64);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1691188459
   )
   int field997 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 473235959
   )
   public int field998;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 807741351
   )
   public int field999;
   @ObfuscatedName("i")
   public static class170 field1000;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1249308297
   )
   public int field1001;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -968325323
   )
   public int field1005;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1620643465"
   )
   public void method883() {
      this.method886(this.field997);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "302319865"
   )
   void method885(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field997 = var1.method2548();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "64471935"
   )
   void method886(int var1) {
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
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field999 = (int)(256.0D * var14);
      this.field998 = (int)(256.0D * var16);
      if(this.field999 < 0) {
         this.field999 = 0;
      } else if(this.field999 > 255) {
         this.field999 = 255;
      }

      if(this.field998 < 0) {
         this.field998 = 0;
      } else if(this.field998 > 255) {
         this.field998 = 255;
      }

      if(var16 > 0.5D) {
         this.field1001 = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.field1001 = (int)(512.0D * var14 * var16);
      }

      if(this.field1001 < 1) {
         this.field1001 = 1;
      }

      this.field1005 = (int)((double)this.field1001 * var12);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Ljava/lang/String;Ljava/lang/String;B)Lclass227;",
      garbageValue = "1"
   )
   public static class227 method888(class170 var0, class170 var1, String var2, String var3) {
      int var4 = var0.method3304(var2);
      int var5 = var0.method3305(var4, var3);
      class227 var6;
      if(!class22.method559(var0, var4, var5)) {
         var6 = null;
      } else {
         byte[] var8 = var1.method3292(var4, var5);
         class227 var7;
         if(var8 == null) {
            var7 = null;
         } else {
            class227 var9 = new class227(var8, class79.field1439, class79.field1438, class79.field1443, class79.field1440, class129.field2092, class79.field1441);
            ChatLineBuffer.method649();
            var7 = var9;
         }

         var6 = var7;
      }

      return var6;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1609287093"
   )
   public void method894(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2544();
         if(var3 == 0) {
            return;
         }

         this.method885(var1, var3, var2);
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1975371437"
   )
   static void method895() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(class117.method2480(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[1 + var1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
