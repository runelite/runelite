import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("ContextMenuRow")
public class ContextMenuRow {
   @ObfuscatedName("f")
   @Export("cacheLocations")
   static String[] cacheLocations;
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -129097769
   )
   @Export("param0")
   int param0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1218839675
   )
   @Export("param1")
   int param1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 894094735
   )
   @Export("type")
   int type;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1768120371
   )
   @Export("identifier")
   int identifier;
   @ObfuscatedName("v")
   @Export("option")
   String option;

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1815964140"
   )
   static void method1764() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(class25.method189(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
                  Client.field889[var1] = Client.field889[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
