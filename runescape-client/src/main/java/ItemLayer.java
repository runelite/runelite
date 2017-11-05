import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("oh")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1130465413
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1451545287
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -531875471
   )
   @Export("y")
   int y;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -137711895
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2094860075
   )
   @Export("height")
   int height;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "30530"
   )
   public static int method2450(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Lhj;",
      garbageValue = "60"
   )
   public static Widget method2454(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(class215.widgets[var1] == null || class215.widgets[var1][var2] == null) {
         boolean var3 = WorldMapData.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return class215.widgets[var1][var2];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Ljv;",
      garbageValue = "1424639255"
   )
   public static class277 method2453(int var0) {
      class277[] var1 = NPC.method1698();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class277 var3 = var1[var2];
         if(var0 == var3.field3743) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Lco;",
      garbageValue = "589398177"
   )
   static World method2451() {
      World.field1283 = 0;
      World var0;
      if(World.field1283 < World.worldCount) {
         var0 = class266.worldList[++World.field1283 - 1];
      } else {
         var0 = null;
      }

      return var0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "1483533673"
   )
   static int method2452(int var0, Script var1, boolean var2) {
      Widget var3 = method2454(class81.intStack[--class278.intStackSize]);
      if(var0 == 2500) {
         class81.intStack[++class278.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class81.intStack[++class278.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class81.intStack[++class278.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class81.intStack[++class278.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class81.intStack[++class278.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class81.intStack[++class278.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
