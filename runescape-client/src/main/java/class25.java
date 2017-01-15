import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public final class class25 extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -229869115
   )
   int field567;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1544617017
   )
   int field568;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -639363951
   )
   int field569;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -235555221
   )
   int field570;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 395592561
   )
   int field571;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1398556439
   )
   int field572;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1914490451
   )
   int field574;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1025159939
   )
   int field576 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1765468721
   )
   int field577 = -1;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -342519775
   )
   static int field580;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 694661705
   )
   int field581;
   @ObfuscatedName("do")
   static int[] field582;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1185369503
   )
   int field584;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1643557185
   )
   int field585;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "1657078692"
   )
   public static SpritePixels[] method592(class182 var0, String var1, String var2) {
      int var3 = var0.method3277(var1);
      int var4 = var0.method3278(var3, var2);
      SpritePixels[] var5;
      if(!XGrandExchangeOffer.method60(var0, var3, var4)) {
         var5 = null;
      } else {
         SpritePixels[] var6 = new SpritePixels[class225.field3215];

         for(int var7 = 0; var7 < class225.field3215; ++var7) {
            SpritePixels var8 = var6[var7] = new SpritePixels();
            var8.field3205 = class225.field3214;
            var8.field3207 = class202.field3060;
            var8.field3209 = class225.field3213[var7];
            var8.field3208 = class225.field3216[var7];
            var8.width = class225.field3217[var7];
            var8.height = class178.field2653[var7];
            int var9 = var8.height * var8.width;
            byte[] var10 = class119.field1845[var7];
            var8.image = new int[var9];

            for(int var11 = 0; var11 < var9; ++var11) {
               var8.image[var11] = class225.field3218[var10[var11] & 255];
            }
         }

         class225.field3213 = null;
         class225.field3216 = null;
         class225.field3217 = null;
         class178.field2653 = null;
         class225.field3218 = null;
         class119.field1845 = (byte[][])null;
         var5 = var6;
      }

      return var5;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "-472441571"
   )
   static final void method593(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class88.field1531.length; ++var2) {
         class88.field1531[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class88.field1531[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               class97.field1627[var5] = (class88.field1531[var5 - 128] + class88.field1531[var5 - 1] + class88.field1531[1 + var5] + class88.field1531[128 + var5]) / 4;
            }
         }

         int[] var6 = class88.field1531;
         class88.field1531 = class97.field1627;
         class97.field1627 = var6;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = 16 + var4 + var0.offsetX;
                  int var8 = 16 + var3 + var0.offsetY;
                  int var7 = (var8 << 7) + var5;
                  class88.field1531[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "-4998"
   )
   static String method594() {
      String var0 = "";

      MessageNode var1;
      for(Iterator var2 = class47.field922.iterator(); var2.hasNext(); var0 = var0 + var1.name + ':' + var1.value + '\n') {
         var1 = (MessageNode)var2.next();
      }

      return var0;
   }
}
