import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class43 extends CacheableNode {
   @ObfuscatedName("r")
   public static NodeCache field978 = new NodeCache(64);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 769747919
   )
   int field979 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 195068213
   )
   public int field980;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1805752203
   )
   public int field981;
   @ObfuscatedName("x")
   public static class170 field982;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2059153925
   )
   public int field983;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -501491595
   )
   public int field989;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "255"
   )
   public void method843() {
      this.method853(this.field979);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "-1507668185"
   )
   void method845(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field979 = var1.method2560();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-11"
   )
   public void method850(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2556();
         if(var3 == 0) {
            return;
         }

         this.method845(var1, var3, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1366797831"
   )
   void method853(int var1) {
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
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field981 = (int)(var14 * 256.0D);
      this.field989 = (int)(256.0D * var16);
      if(this.field981 < 0) {
         this.field981 = 0;
      } else if(this.field981 > 255) {
         this.field981 = 255;
      }

      if(this.field989 < 0) {
         this.field989 = 0;
      } else if(this.field989 > 255) {
         this.field989 = 255;
      }

      if(var16 > 0.5D) {
         this.field983 = (int)(var14 * (1.0D - var16) * 512.0D);
      } else {
         this.field983 = (int)(512.0D * var16 * var14);
      }

      if(this.field983 < 1) {
         this.field983 = 1;
      }

      this.field980 = (int)(var12 * (double)this.field983);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)LSpritePixels;",
      garbageValue = "-797732406"
   )
   public static SpritePixels method856(class170 var0, int var1, int var2) {
      return !NPCComposition.method775(var0, var1, var2)?null:class0.method3();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-426934541"
   )
   public static int method857(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-9"
   )
   public static void method858(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class79.field1420 = var1.method2551();
      class79.field1421 = new int[class79.field1420];
      class79.field1423 = new int[class79.field1420];
      class20.field567 = new int[class79.field1420];
      class79.field1424 = new int[class79.field1420];
      class13.field191 = new byte[class79.field1420][];
      var1.offset = var0.length - 7 - class79.field1420 * 8;
      class79.field1422 = var1.method2551();
      class79.field1419 = var1.method2551();
      int var2 = (var1.method2556() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class79.field1420; ++var3) {
         class79.field1421[var3] = var1.method2551();
      }

      for(var3 = 0; var3 < class79.field1420; ++var3) {
         class79.field1423[var3] = var1.method2551();
      }

      for(var3 = 0; var3 < class79.field1420; ++var3) {
         class20.field567[var3] = var1.method2551();
      }

      for(var3 = 0; var3 < class79.field1420; ++var3) {
         class79.field1424[var3] = var1.method2551();
      }

      var1.offset = var0.length - 7 - class79.field1420 * 8 - 3 * (var2 - 1);
      class79.field1425 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class79.field1425[var3] = var1.method2560();
         if(class79.field1425[var3] == 0) {
            class79.field1425[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class79.field1420; ++var3) {
         int var4 = class20.field567[var3];
         int var5 = class79.field1424[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class13.field191[var3] = var7;
         int var8 = var1.method2556();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2557();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var4 * var10] = var1.method2557();
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;S)V",
      garbageValue = "-30286"
   )
   public static void method859(class170 var0) {
      class48.field1069 = var0;
   }
}
