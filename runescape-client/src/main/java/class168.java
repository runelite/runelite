import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class168 implements class165 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   public static final class168 field2396;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   static final class168 field2397;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   public static final class168 field2398;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   public static final class168 field2403;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[Lfn;"
   )
   static final class168[] field2401;
   @ObfuscatedName("z")
   @Export("userHome")
   static String userHome;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 1695622361
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1161120371
   )
   public final int field2400;

   static {
      field2396 = new class168(14, 0);
      field2397 = new class168(15, 4);
      field2398 = new class168(16, -2);
      field2403 = new class168(18, -2);
      field2401 = new class168[32];
      class168[] var0 = new class168[]{field2396, field2397, field2403, field2398};
      class168[] var1 = var0;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         field2401[var1[var2].field2400] = var1[var2];
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class168(int var1, int var2) {
      this.field2400 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "1830008729"
   )
   static int method3095(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class64.method1017(class82.intStack[--class82.intStackSize]);
      } else {
         var3 = var2?class234.field3210:class82.field1253;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class82.intStack[--class82.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.setAction(var4, class82.scriptStringStack[--class259.scriptStringStackSize]);
            return 1;
         } else {
            --class259.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class82.intStackSize -= 2;
         var4 = class82.intStack[class82.intStackSize];
         int var5 = class82.intStack[class82.intStackSize + 1];
         var3.dragParent = DecorativeObject.method2896(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2791 = class82.intStack[--class82.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2789 = class82.intStack[--class82.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2790 = class82.intStack[--class82.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class82.scriptStringStack[--class259.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class82.scriptStringStack[--class259.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1626478232"
   )
   static final void method3096(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class18.getTileHeight(var0, var1, class28.plane) - var2;
         var0 -= class45.cameraX;
         var3 -= class279.cameraZ;
         var1 -= Client.cameraY;
         int var4 = Graphics3D.SINE[class45.cameraPitch];
         int var5 = Graphics3D.COSINE[class45.cameraPitch];
         int var6 = Graphics3D.SINE[class230.cameraYaw];
         int var7 = Graphics3D.COSINE[class230.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var3 * var4 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.screenY = var0 * Client.scale / var1 + Client.viewportHeight / 2;
            Client.screenX = Client.viewportWidth / 2 + var8 * Client.scale / var1;
         } else {
            Client.screenY = -1;
            Client.screenX = -1;
         }

      } else {
         Client.screenY = -1;
         Client.screenX = -1;
      }
   }
}
