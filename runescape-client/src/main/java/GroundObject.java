import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 317210155
   )
   static int field1781;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1760689955
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 201130473
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1325890519
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1637945327
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1127107045
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1749006899"
   )
   static void method2738(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1209[var5] != var0) {
            var2[var4] = World.field1209[var5];
            var3[var4] = World.field1211[var5];
            ++var4;
         }
      }

      World.field1209 = var2;
      World.field1211 = var3;
      Tile.method2753(World.worldList, 0, World.worldList.length - 1, World.field1209, World.field1211);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-73"
   )
   static final void method2739(String var0) {
      class243.method4617(var0 + " is already on your friend list");
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILct;ZB)I",
      garbageValue = "86"
   )
   static int method2737(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class5.getWidget(class81.intStack[--class81.intStackSize]);
      } else {
         var3 = var2?class20.field338:class81.field1267;
      }

      if(var0 == 1927) {
         if(class81.field1270 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2934 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.objs = var3.field2934;
            var4.field797 = class81.field1270 + 1;
            Client.field1047.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1769584333"
   )
   static final int method2736(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var3 * (var0 & 16711935) + (var1 & 16711935) * var2 & -16711936) + ((var0 & 65280) * var3 + (var1 & 65280) * var2 & 16711680) >> 8;
   }
}
