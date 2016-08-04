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
         class42.method886();
         if(class136.field2123.field143) {
            class78.method1721(99, "", "Roofs are now all hidden");
         } else {
            class78.method1721(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         client.field433 = !client.field433;
      }

      if(client.field460 >= 2) {
         if(var0.equalsIgnoreCase("fpson")) {
            client.field433 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            client.field433 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            if(client.field299 > 0) {
               class129.method2964();
            } else {
               class138.method3024(40);
               class52.field1153 = class40.field904;
               class40.field904 = null;
            }
         }

         if(var0.equalsIgnoreCase("errortest") && client.field297 == 2) {
            throw new RuntimeException();
         }
      }

      client.field337.method2903(139);
      client.field337.method2783(var0.length() + 1);
      client.field337.method2703(var0);
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)V",
      garbageValue = "-536155875"
   )
   static void method1777(class176 var0) {
      if(var0.field2829 == client.field497) {
         client.field498[var0.field2938] = true;
      }

   }
}
