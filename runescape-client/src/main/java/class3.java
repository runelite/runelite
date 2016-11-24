import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
final class class3 implements Comparator {
   @ObfuscatedName("ko")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = 1252663239
   )
   static int field32;
   @ObfuscatedName("pl")
   static class1 field33;
   @ObfuscatedName("ne")
   static class65 field35;
   @ObfuscatedName("ej")
   static SpritePixels[] field37;

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "2118923506"
   )
   static final void method34(Actor var0, int var1) {
      method41(var0.x, var0.y, var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "-12"
   )
   int method35(class2 var1, class2 var2) {
      return var1.field23.totalQuantity < var2.field23.totalQuantity?-1:(var2.field23.totalQuantity == var1.field23.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method35((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-105"
   )
   static final void method41(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class11.method161(var0, var1, class166.plane) - var2;
         var0 -= XGrandExchangeOffer.cameraX;
         var3 -= Client.cameraZ;
         var1 -= Client.cameraY;
         int var4 = class84.field1444[class40.cameraPitch];
         int var5 = class84.field1445[class40.cameraPitch];
         int var6 = class84.field1444[class104.cameraYaw];
         int var7 = class84.field1445[class104.cameraYaw];
         int var8 = var7 * var0 + var6 * var1 >> 16;
         var1 = var1 * var7 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            Client.field347 = Client.camera2 / 2 + var0 * Client.scale / var1;
            Client.field394 = Client.scale * var8 / var1 + Client.camera3 / 2;
         } else {
            Client.field347 = -1;
            Client.field394 = -1;
         }

      } else {
         Client.field347 = -1;
         Client.field394 = -1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2048198023"
   )
   static void method42() {
      FileOnDisk var0 = null;

      try {
         var0 = class118.method2341("", NPC.field758.field2696, true);
         Buffer var1 = Tile.field1343.method674();
         var0.method1441(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method1442();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "109"
   )
   static void method44(String var0, String var1, String var2) {
      class41.loginMessage1 = var0;
      class41.loginMessage2 = var1;
      class41.loginMessage3 = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "2025792427"
   )
   public static boolean method45(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }
}
