import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class23 extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1611622857
   )
   int field577;
   @ObfuscatedName("z")
   int[] field578;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2122045587
   )
   int field579;
   @ObfuscatedName("t")
   int[] field580;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 452869933
   )
   int field581;
   @ObfuscatedName("y")
   String[] field582;
   @ObfuscatedName("as")
   static class171 field583;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 912722957
   )
   int field584;
   @ObfuscatedName("s")
   static NodeCache field585 = new NodeCache(128);
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = 959109437
   )
   @Export("baseX")
   static int baseX;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2037352765"
   )
   static void method571() {
      class79.field1419 = null;
      XClanMember.field612 = null;
      class79.field1420 = null;
      class8.field129 = null;
      class117.field2002 = null;
      class220.field3211 = null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "165720142"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field1015.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field1009.method3272(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method925(new Buffer(var2));
         }

         KitDefinition.field1015.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "79"
   )
   static void method576(int var0) {
      Client.field481 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      class118.method2422();
      if(Client.gameState >= 25) {
         Player.method39();
      }

      GameEngine.field2229 = true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-83"
   )
   static void method577() {
      if(Item.loadWorlds()) {
         class33.worldSelectShown = true;
      }

   }
}
