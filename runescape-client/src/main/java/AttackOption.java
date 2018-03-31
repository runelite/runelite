import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   @Export("AttackOption_dependsOnCombatLevels")
   AttackOption_dependsOnCombatLevels(0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   @Export("AttackOption_alwaysRightClick")
   AttackOption_alwaysRightClick(1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   @Export("AttackOption_leftClickWhereAvailable")
   AttackOption_leftClickWhereAvailable(2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   @Export("AttackOption_hidden")
   AttackOption_hidden(3);

   @ObfuscatedName("r")
   @Export("floorHues")
   static int[] floorHues;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1538586325
   )
   @Export("id")
   final int id;

   AttackOption(int var3) {
      this.id = var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1780726447"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgf;I)V",
      garbageValue = "1184301367"
   )
   static final void method1860(PacketBuffer var0) {
      for(int var1 = 0; var1 < class93.field1421; ++var1) {
         int var2 = class93.field1422[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 32) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         InvType.method4730(var0, var2, var3, var4);
      }

   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "999965596"
   )
   static void method1859(int var0) {
      Client.field1068 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      int var1 = Client.isResized?2:1;
      if(var1 == 1) {
         BoundingBox.clientInstance.method899(765, 503);
      } else {
         BoundingBox.clientInstance.method899(7680, 2160);
      }

      if(Client.gameState >= 25) {
         Permission.method4535();
      }

   }
}
