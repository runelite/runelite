import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class14 {
   @ObfuscatedName("ev")
   static SpritePixels[] field205;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 101814837
   )
   int field206 = -1;
   @ObfuscatedName("t")
   String[] field208;
   @ObfuscatedName("a")
   static int[] field211;
   @ObfuscatedName("bk")
   static ModIcon[] field213;
   @ObfuscatedName("n")
   int[] field215;
   @ObfuscatedName("f")
   class23 field216;

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "8"
   )
   static void method157(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class153.method3170(var0.parentId);
      int var2;
      int var3;
      if(null == var1) {
         var2 = class153.field2296;
         var3 = class93.field1616;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      World.method648(var0, var2, var3, false);
      Ignore.method92(var0, var2, var3);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "65"
   )
   static void method158() {
      Client.field397.method2768(206);
      Client.field397.method2518(class158.method3187());
      Client.field397.method2519(class153.field2296);
      Client.field397.method2519(class93.field1616);
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIII)V",
      garbageValue = "53937214"
   )
   static final void method159(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field329) {
         Client.field364 = 32;
      } else {
         Client.field364 = 0;
      }

      Client.field329 = false;
      int var7;
      if(class143.field2205 == 1 || !ChatMessages.field276 && class143.field2205 == 4) {
         if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < 16 + var2) {
            var0.scrollY -= 4;
            MessageNode.method750(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var2 + var3) {
            var0.scrollY += 4;
            MessageNode.method750(var0);
         } else if(var5 >= var1 - Client.field364 && var5 < Client.field364 + var1 + 16 && var6 >= 16 + var2 && var6 < var2 + var3 - 16) {
            var7 = (var3 - 32) * var3 / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = (var4 - var3) * var8 / var9;
            MessageNode.method750(var0);
            Client.field329 = true;
         }
      }

      if(Client.field477 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.field477 * 45;
            MessageNode.method750(var0);
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1193512511"
   )
   static void method160(int var0) {
      if(var0 == -1 && !Client.field470) {
         class154.method3172();
      } else if(var0 != -1 && Client.field517 != var0 && Client.field516 != 0 && !Client.field470) {
         class165.method3218(2, class47.field1050, var0, 0, Client.field516, false);
      }

      Client.field517 = var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-3"
   )
   static void method161() {
      class189.field3050 = null;
      class79.field1431 = null;
      class79.field1432 = null;
      XItemContainer.field221 = null;
      class137.field2130 = null;
      BufferProvider.field1450 = null;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "968372060"
   )
   static final void method162(int var0, int var1, int var2, int var3) {
      if(Client.field392 == 1) {
         class28.field678[Client.field391 / 100].method1763(Client.field389 - 8, Client.field390 - 8);
      }

      if(Client.field392 == 2) {
         class28.field678[Client.field391 / 100 + 4].method1763(Client.field389 - 8, Client.field390 - 8);
      }

      ObjectComposition.method853();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "35"
   )
   public static boolean method163(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "1565851983"
   )
   public static String method164(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class168.field2698[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }
}
