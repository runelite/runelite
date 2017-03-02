import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class47 {
   @ObfuscatedName("i")
   static final class136 field923 = new class136();
   @ObfuscatedName("l")
   static final class121 field924 = new class121(1024);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 222427427
   )
   static int field925 = 0;
   @ObfuscatedName("b")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();
   @ObfuscatedName("z")
   static int[] field928;

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZI)V",
      garbageValue = "-1521992680"
   )
   static final void method945(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            if(var6) {
               Client.field432 = Client.menuOptionCount;
            }

            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "320944133"
   )
   static int method947(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field337 = 250;
         return 1;
      } else {
         return 2;
      }
   }

   class47() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(LWidget;I)LWidget;",
      garbageValue = "-1399013018"
   )
   static Widget method955(Widget var0) {
      Widget var1 = class72.method1465(var0);
      if(var1 == null) {
         var1 = var0.parent;
      }

      return var1;
   }
}
