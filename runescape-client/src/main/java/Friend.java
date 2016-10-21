import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("b")
   boolean field242;
   @ObfuscatedName("e")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("f")
   @Export("name")
   String name;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 938289387
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("v")
   boolean field246;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2081319899
   )
   @Export("world")
   int world;

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-94"
   )
   static void method188() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(class79.method1725(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[1 + var1];
                  Client.menuTargets[var1] = Client.menuTargets[1 + var1];
                  Client.menuTypes[var1] = Client.menuTypes[1 + var1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[1 + var1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[1 + var1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
