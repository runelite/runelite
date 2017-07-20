import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public enum class91 implements RSEnum {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   field1386(0),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   field1387(1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   field1388(2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   field1393(3);

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2118507031
   )
   final int field1389;
   @ObfuscatedName("e")
   @Export("cacheLocations")
   static String[] cacheLocations;

   class91(int var3) {
      this.field1389 = var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1443879177"
   )
   public int rsOrdinal() {
      return this.field1389;
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2119863672"
   )
   static final void method1663() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var4;
               boolean var5 = Client.field984[var1];
               Client.field984[var1] = Client.field984[var1 + 1];
               Client.field984[var1 + 1] = var5;
               var0 = false;
            }
         }
      }

   }
}
