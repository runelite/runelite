import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class179 implements class134 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1975040471
   )
   public final int field2661;
   @ObfuscatedName("c")
   static final class179 field2662;
   @ObfuscatedName("n")
   static final class179 field2663;
   @ObfuscatedName("d")
   static final class179 field2664;
   @ObfuscatedName("t")
   static final class179 field2665;
   @ObfuscatedName("p")
   static final class179 field2666;
   @ObfuscatedName("q")
   static final class179 field2667;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1567231149
   )
   final int field2668;
   @ObfuscatedName("l")
   public final boolean field2669;
   @ObfuscatedName("v")
   public final boolean field2670;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1946751124"
   )
   public int vmethod4163() {
      return this.field2668;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class179(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2668 = var1;
      this.field2661 = var2;
      this.field2669 = var4;
      this.field2670 = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;B)V",
      garbageValue = "6"
   )
   public static void method3272(IndexDataBase var0) {
      CombatInfoListHolder.field753 = var0;
   }

   static {
      field2664 = new class179(0, -1, true, false, true);
      field2662 = new class179(1, 0, true, true, true);
      field2663 = new class179(2, 1, true, true, false);
      field2667 = new class179(3, 2, false, false, true);
      field2665 = new class179(4, 3, false, false, true);
      field2666 = new class179(5, 10, false, false, true);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1388666456"
   )
   public static void method3273() {
      Sequence.field3087.reset();
      Sequence.field3088.reset();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-584371457"
   )
   static int method3274(int var0, Script var1, boolean var2) {
      int var9;
      int var10;
      if(var0 == 100) {
         class32.intStackSize -= 3;
         var10 = class32.intStack[class32.intStackSize];
         var9 = class32.intStack[class32.intStackSize + 1];
         int var5 = class32.intStack[class32.intStackSize + 2];
         if(var9 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = class128.method2364(var10);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
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
               var12.type = var9;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class200.field2894 = var12;
               } else {
                  Script.field942 = var12;
               }

               class124.method2350(var6);
               return 1;
            }
         }
      } else {
         Widget var3;
         if(var0 == 101) {
            var3 = var2?class200.field2894:Script.field942;
            Widget var4 = class128.method2364(var3.id);
            var4.children[var3.index] = null;
            class124.method2350(var4);
            return 1;
         } else if(var0 == 102) {
            var3 = class128.method2364(class32.intStack[--class32.intStackSize]);
            var3.children = null;
            class124.method2350(var3);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var3 = class128.method2364(class32.intStack[--class32.intStackSize]);
               if(var3 != null) {
                  class32.intStack[++class32.intStackSize - 1] = 1;
                  if(var2) {
                     class200.field2894 = var3;
                  } else {
                     Script.field942 = var3;
                  }
               } else {
                  class32.intStack[++class32.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class32.intStackSize -= 2;
            var10 = class32.intStack[class32.intStackSize];
            var9 = class32.intStack[class32.intStackSize + 1];
            Widget var11 = class0.method13(var10, var9);
            if(var11 != null && var9 != -1) {
               class32.intStack[++class32.intStackSize - 1] = 1;
               if(var2) {
                  class200.field2894 = var11;
               } else {
                  Script.field942 = var11;
               }
            } else {
               class32.intStack[++class32.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
