import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class101 extends RuntimeException {
   @ObfuscatedName("k")
   String field1637;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 1767587923235982761L
   )
   public static long field1638;
   @ObfuscatedName("q")
   static ModIcon field1639;
   @ObfuscatedName("g")
   Throwable field1641;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 371197977
   )
   @Export("menuHeight")
   static int menuHeight;

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(Lclass25;B)V",
      garbageValue = "18"
   )
   static final void method1916(class25 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field573 == 0) {
         var1 = Client.region.method1717(var0.field586, var0.field574, var0.field581);
      }

      if(var0.field573 == 1) {
         var1 = Client.region.method1718(var0.field586, var0.field574, var0.field581);
      }

      if(var0.field573 == 2) {
         var1 = Client.region.method1719(var0.field586, var0.field574, var0.field581);
      }

      if(var0.field573 == 3) {
         var1 = Client.region.method1720(var0.field586, var0.field574, var0.field581);
      }

      if(var1 != 0) {
         int var5 = Client.region.method1721(var0.field586, var0.field574, var0.field581, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field576 = var2;
      var0.field575 = var3;
      var0.field583 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIILRegion;[LCollisionData;I)V",
      garbageValue = "274920023"
   )
   static final void method1924(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.method2772();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.method2772();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.readUnsignedByte();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var2 + var10;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class10.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class6.method72(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-2126392362"
   )
   static SpritePixels method1926() {
      SpritePixels var0 = new SpritePixels();
      var0.field3210 = class225.field3215;
      var0.field3208 = class225.field3216;
      var0.field3207 = class225.field3217[0];
      var0.field3206 = RSCanvas.field1748[0];
      var0.width = class225.field3218[0];
      var0.height = Item.field897[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = class154.field2106[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class167.field2191[var2[var3] & 255];
      }

      class185.method3361();
      return var0;
   }

   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "32767"
   )
   protected static final void method1927() {
      class5.field51.vmethod2017();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field1767[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field1772[var0] = 0L;
      }

      class41.field857 = 0;
   }
}
