import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class205 extends Node {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -905951633
   )
   int field2545;
   @ObfuscatedName("v")
   class202 field2546;
   @ObfuscatedName("e")
   class107 field2547;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 254843615
   )
   int field2548;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1728735675
   )
   int field2549;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1034524455
   )
   int field2550;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -501485
   )
   int field2551;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 888216399
   )
   int field2552;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1675542655
   )
   int field2553;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -952927577
   )
   int field2554;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1061305047
   )
   int field2555;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1355331135
   )
   int field2556;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2020809265
   )
   int field2557;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 424319579
   )
   int field2558;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -978757445
   )
   int field2559;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1681071893
   )
   int field2560;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1491639745
   )
   int field2561;
   @ObfuscatedName("c")
   class207 field2562;
   @ObfuscatedName("d")
   class117 field2563;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -156200167
   )
   int field2564;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 119584397
   )
   int field2565;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "675934302"
   )
   void method3784() {
      this.field2562 = null;
      this.field2547 = null;
      this.field2546 = null;
      this.field2563 = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "2036300700"
   )
   public static void method3788(IndexDataBase var0) {
      class252.field3391 = var0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-667616655"
   )
   public static boolean method3789(int var0) {
      return var0 >= class221.field2827.field2832 && var0 <= class221.field2812.field2832 || class221.field2813.field2832 == var0;
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-60"
   )
   static void method3791(int var0) {
      if(var0 == -1 && !Client.field1123) {
         class164.method3060();
      } else if(var0 != -1 && var0 != Client.field1166 && Client.field1165 != 0 && !Client.field1123) {
         class51.method762(2, class22.indexTrack1, var0, 0, Client.field1165, false);
      }

      Client.field1166 = var0;
   }
}
