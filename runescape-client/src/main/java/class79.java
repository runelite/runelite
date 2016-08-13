import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class79 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1719111797
   )
   static int field1454;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1362303461
   )
   static int field1456;
   @ObfuscatedName("e")
   public static int[] field1457;
   @ObfuscatedName("k")
   public static int[] field1458;
   @ObfuscatedName("u")
   public static int[] field1459;
   @ObfuscatedName("nw")
   static class77 field1463;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -573698869
   )
   static int field1466;

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-780821785"
   )
   static final void method1754(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class136.field2123.field143 = !class136.field2123.field143;
         ObjectComposition.method886();
         if(class136.field2123.field143) {
            SecondaryBufferProvider.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            SecondaryBufferProvider.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.field433 = !Client.field433;
      }

      if(Client.field460 >= 2) {
         if(var0.equalsIgnoreCase("fpson")) {
            Client.field433 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.field433 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            if(Client.field299 > 0) {
               class129.method2964();
            } else {
               class138.setGameState(40);
               class52.field1153 = class40.field904;
               class40.field904 = null;
            }
         }

         if(var0.equalsIgnoreCase("errortest") && Client.field297 == 2) {
            throw new RuntimeException();
         }
      }

      Client.field337.method2903(139);
      Client.field337.method2783(var0.length() + 1);
      Client.field337.method2703(var0);
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-536155875"
   )
   static void method1777(Widget var0) {
      if(var0.field2829 == Client.field497) {
         Client.field498[var0.boundsIndex] = true;
      }

   }
}
