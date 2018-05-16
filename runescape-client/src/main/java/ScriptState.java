import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("qv")
   @ObfuscatedSignature(
      signature = "Lbt;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1546943225
   )
   public static int field463;
   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "[Llc;"
   )
   static SpritePixels[] field469;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lcs;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1864734979
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("q")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("b")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Liz;",
      garbageValue = "651406254"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.SpotAnimationDefinition_indexCache.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Ljy;",
      garbageValue = "6"
   )
   public static Enum method1063(int var0) {
      Enum var1 = (Enum)Enum.EnumDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class311.EnumDefinition_indexCache.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Enum.EnumDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILcs;ZI)I",
      garbageValue = "2082592017"
   )
   static int method1062(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = OwnWorldComparator.getWidget(class69.intStack[--class45.intStackSize]);
      } else {
         var3 = var2?class184.field2379:FriendManager.field996;
      }

      DState.method3548(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class69.intStack[--class45.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = MilliTimer.localPlayer.composition.method4493();
            return 1;
         } else {
            return 2;
         }
      } else {
         class45.intStackSize -= 2;
         int var4 = class69.intStack[class45.intStackSize];
         int var5 = class69.intStack[class45.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = class120.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.offsetX2d = var6.offsetX2d;
         var3.offsetY2d = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2645 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2645 = 1;
         } else {
            var3.field2645 = 2;
         }

         if(var3.field2678 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2678;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("ks")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-96"
   )
   static void method1061() {
      if(Client.field622 && MilliTimer.localPlayer != null) {
         int var0 = MilliTimer.localPlayer.pathX[0];
         int var1 = MilliTimer.localPlayer.pathY[0];
         if(var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
            return;
         }

         Signlink.field1979 = MilliTimer.localPlayer.x;
         int var2 = class264.getTileHeight(MilliTimer.localPlayer.x, MilliTimer.localPlayer.y, class192.plane) - Client.field668;
         if(var2 < Client.field857) {
            Client.field857 = var2;
         }

         ItemContainer.field481 = MilliTimer.localPlayer.y;
         Client.field622 = false;
      }

   }
}
