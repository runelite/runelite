import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public final class class25 extends Node {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -288058197
   )
   int field559;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1659979541
   )
   int field560;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1972108959
   )
   int field562;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1242998061
   )
   int field563;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1801454723
   )
   int field564;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1508800869
   )
   int field565;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -627338037
   )
   int field567;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 961292465
   )
   int field568;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1449523783
   )
   int field569 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1212593289
   )
   int field570 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1378386301
   )
   int field571;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1764125635
   )
   int field572;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public static int method572() {
      return class105.keyboardIdleTicks;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-16"
   )
   static final void method573() {
      for(class33 var0 = (class33)Client.field412.method2412(); var0 != null; var0 = (class33)Client.field412.method2426()) {
         if(WallObject.plane == var0.field736 && !var0.field739) {
            if(Client.gameCycle >= var0.field730) {
               var0.method674(Client.field354);
               if(var0.field739) {
                  var0.unlink();
               } else {
                  Renderable.region.method1710(var0.field736, var0.field733, var0.field738, var0.field735, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "9532"
   )
   static void method574() {
      if(Client.field432) {
         Widget var0 = class105.method1992(class40.field814, Client.field433);
         if(var0 != null && null != var0.field2253) {
            class18 var1 = new class18();
            var1.field180 = var0;
            var1.field188 = var0.field2253;
            XItemContainer.method160(var1, 200000);
         }

         Client.field432 = false;
         class33.method682(var0);
      }
   }
}
