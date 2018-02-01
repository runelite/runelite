import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class21 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "20"
   )
   public static boolean method168(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-359398572"
   )
   static final void method167() {
      int[] var0 = class92.playerIndices;

      int var1;
      for(var1 = 0; var1 < class92.playerIndexesCount; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(var2 != null && var2.overheadTextCyclesRemaining > 0) {
            --var2.overheadTextCyclesRemaining;
            if(var2.overheadTextCyclesRemaining == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         int var4 = Client.npcIndices[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.overheadTextCyclesRemaining > 0) {
            --var3.overheadTextCyclesRemaining;
            if(var3.overheadTextCyclesRemaining == 0) {
               var3.overhead = null;
            }
         }
      }

   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(Lho;B)Lho;",
      garbageValue = "-29"
   )
   static Widget method169(Widget var0) {
      Widget var1 = BoundingBox3DDrawMode.method73(var0);
      if(var1 == null) {
         var1 = var0.dragParent;
      }

      return var1;
   }
}
