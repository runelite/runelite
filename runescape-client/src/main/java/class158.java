import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public enum class158 implements Enumerated {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   field2140(0, 0),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   field2141(1, 1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   field2145(2, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   field2143(3, 3);

   @ObfuscatedName("fy")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -192099525
   )
   public final int field2144;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 654810181
   )
   final int field2142;

   class158(int var3, int var4) {
      this.field2144 = var3;
      this.field2142 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "846888120"
   )
   public int rsOrdinal() {
      return this.field2142;
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1217627096"
   )
   static final void method3248(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         CombatInfoListHolder.method1860(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1125 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }
}
