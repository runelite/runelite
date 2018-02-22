import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1365854585
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 679370021
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1413699169
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 38103929
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1218489225
   )
   @Export("height")
   int height;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1673944033"
   )
   static void method2599() {
      for(class79 var0 = (class79)class79.field1210.getFront(); var0 != null; var0 = (class79)class79.field1210.getNext()) {
         if(var0.field1214 != null) {
            var0.method1750();
         }
      }

   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-30179"
   )
   static void method2598() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
                  Client.menuBooleanArray[var3] = Client.menuBooleanArray[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1564652228"
   )
   static final void method2600() {
      for(int var0 = 0; var0 < class92.playerIndexesCount; ++var0) {
         Player var1 = Client.cachedPlayers[class92.playerIndices[var0]];
         var1.method1214();
      }

      Iterator var2 = class94.messages.iterator();

      while(var2.hasNext()) {
         MessageNode var3 = (MessageNode)var2.next();
         var3.method1149();
      }

      if(class2.clanMemberManager != null) {
         class2.clanMemberManager.method5407();
      }

   }
}
