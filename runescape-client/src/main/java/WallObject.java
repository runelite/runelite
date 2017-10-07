import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -1399424123
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1032144727
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 906406555
   )
   @Export("config")
   int config;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -347393681
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1536297111
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1590916923
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -947118793
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2120607571
   )
   @Export("orientationB")
   int orientationB;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(Lhj;Lio;IIZI)V",
      garbageValue = "1471837132"
   )
   static final void method2937(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         String var9 = class60.getColTags(16748608) + var1.name;
         int var11 = var1.id;
         int var13 = var0.id;
         if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var7;
            Client.menuTargets[Client.menuOptionCount] = var9;
            Client.menuTypes[Client.menuOptionCount] = var6;
            Client.menuIdentifiers[Client.menuOptionCount] = var11;
            Client.menuActionParams0[Client.menuOptionCount] = var2;
            Client.menuActionParams1[Client.menuOptionCount] = var13;
            Client.field1021[Client.menuOptionCount] = var4;
            ++Client.menuOptionCount;
         }
      }

   }
}
