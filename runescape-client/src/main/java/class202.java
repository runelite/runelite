import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class202 {
   @ObfuscatedName("i")
   byte[] field2500;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -800475699
   )
   int field2501;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1518117271
   )
   int field2502;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1439081429
   )
   int field2503;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -451570291
   )
   int field2504;
   @ObfuscatedName("c")
   byte[] field2505;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2065648417
   )
   int field2506;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1386576291
   )
   int field2507;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1684519863
   )
   int field2508;

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1096630953"
   )
   static final void method3644(int var0, int var1, int var2, int var3) {
      if(Client.field1186 == 1) {
         class13.field278[Client.field1000 / 100].method5047(Client.field1175 - 8, Client.field1038 - 8);
      }

      if(Client.field1186 == 2) {
         class13.field278[Client.field1000 / 100 + 4].method5047(Client.field1175 - 8, Client.field1038 - 8);
      }

      Client.field985 = 0;
      int var4 = class41.baseX + (World.localPlayer.x >> 7);
      int var5 = WorldMapType3.baseY + (World.localPlayer.y >> 7);
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         Client.field985 = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         Client.field985 = 1;
      }

      if(Client.field985 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         Client.field985 = 0;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-626031694"
   )
   static int method3645(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = WorldMapType3.method199(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class232.field3187:class2.field15;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class83.intStack[--class83.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method4007(var4, class83.scriptStringStack[--class51.scriptStringStackSize]);
            return 1;
         } else {
            --class51.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class83.intStackSize -= 2;
         var4 = class83.intStack[class83.intStackSize];
         int var5 = class83.intStack[class83.intStackSize + 1];
         var3.dragParent = FileOnDisk.method2351(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2780 = class83.intStack[--class83.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2727 = class83.intStack[--class83.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2728 = class83.intStack[--class83.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class83.scriptStringStack[--class51.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.field2730 = class83.scriptStringStack[--class51.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
