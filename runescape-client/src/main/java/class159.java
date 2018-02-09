import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public abstract class class159 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2070343570"
   )
   public abstract boolean vmethod3297(int var1) throws IOException;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "479833160"
   )
   public abstract int vmethod3300() throws IOException;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "91"
   )
   public abstract int vmethod3301() throws IOException;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "-14"
   )
   public abstract int vmethod3302(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "16711680"
   )
   public abstract void vmethod3304(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1598662762"
   )
   public abstract void vmethod3299();

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1421639468"
   )
   static final void method3257(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method5026()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1127 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field1027[var4][var5] == Client.field928) {
                     continue;
                  }

                  Client.field1027[var4][var5] = Client.field928;
               }

               if(!var2.composition.field3660) {
                  var3 -= Integer.MIN_VALUE;
               }

               TotalQuantityComparator.region.method2915(class60.plane, var2.x, var2.y, MessageNode.getTileHeight(var2.field1127 * 64 - 64 + var2.x, var2.field1127 * 64 - 64 + var2.y, class60.plane), var2.field1127 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1117);
            }
         }
      }

   }
}
