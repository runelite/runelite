import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
@Implements("Buddy")
public class Buddy extends User {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 429472919
   )
   @Export("world0")
   public int world0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 120689297
   )
   @Export("int2")
   public int int2;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -304954565
   )
   @Export("rank")
   public int rank;

   Buddy() {
      this.world0 = -1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "867"
   )
   @Export("set")
   void set(int var1, int var2) {
      this.world0 = var1;
      this.int2 = var2;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   @Export("world")
   public int world() {
      return this.world0;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1888702836"
   )
   @Export("hasWorld")
   public boolean hasWorld() {
      return this.world0 > 0;
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1868787018"
   )
   static final void method5554() {
      int[] var0 = Players.Players_indices;

      int var1;
      for(var1 = 0; var1 < Players.Players_count; ++var1) {
         Player var2 = Client.players[var0[var1]];
         if(var2 != null && var2.overheadTextCyclesRemaining > 0) {
            --var2.overheadTextCyclesRemaining;
            if(var2.overheadTextCyclesRemaining == 0) {
               var2.overheadText = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.npcCount; ++var1) {
         int var4 = Client.npcIndices[var1];
         NPC var3 = Client.npcs[var4];
         if(var3 != null && var3.overheadTextCyclesRemaining > 0) {
            --var3.overheadTextCyclesRemaining;
            if(var3.overheadTextCyclesRemaining == 0) {
               var3.overheadText = null;
            }
         }
      }

   }
}
