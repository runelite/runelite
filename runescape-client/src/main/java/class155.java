import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public class class155 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 2672204831880706969L
   )
   static long field2102;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -2075207510273707797L
   )
   static long field2103;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-279729224"
   )
   static int method3043(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         class32.field752 -= 3;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[1 + class32.field752];
         int var5 = class32.field756[class32.field752 + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = World.method670(var3);
            if(null == var6.children) {
               var6.children = new Widget[1 + var5];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class26.field624 = var12;
               } else {
                  class32.field754 = var12;
               }

               class2.method36(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class26.field624:class32.field754;
            Widget var10 = World.method670(var9.id);
            var10.children[var9.index] = null;
            class2.method36(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = World.method670(class32.field756[--class32.field752]);
            var9.children = null;
            class2.method36(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = World.method670(class32.field756[--class32.field752]);
               if(null != var9) {
                  class32.field756[++class32.field752 - 1] = 1;
                  if(var2) {
                     class26.field624 = var9;
                  } else {
                     class32.field754 = var9;
                  }
               } else {
                  class32.field756[++class32.field752 - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class32.field752 -= 2;
            var3 = class32.field756[class32.field752];
            var4 = class32.field756[class32.field752 + 1];
            Widget var11 = class40.method826(var3, var4);
            if(null != var11 && var4 != -1) {
               class32.field756[++class32.field752 - 1] = 1;
               if(var2) {
                  class26.field624 = var11;
               } else {
                  class32.field754 = var11;
               }
            } else {
               class32.field756[++class32.field752 - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1523467763"
   )
   static void method3046(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var0);
      if(null != var1) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   class155() throws Throwable {
      throw new Error();
   }
}
