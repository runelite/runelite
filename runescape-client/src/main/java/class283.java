import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
public class class283 extends class207 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1711132097
   )
   public int field3745;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   public Name field3746;
   @ObfuscatedName("i")
   public short field3744;

   @ObfuscatedSignature(
      signature = "(Lja;I)V"
   )
   class283(Name var1, int var2) {
      this.field3745 = (int)(SceneTilePaint.currentTimeMs() / 1000L);
      this.field3746 = var1;
      this.field3744 = (short)var2;
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1393876306"
   )
   static void method5349(int var0) {
      Client.field1037 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      if(BoundingBox.method40() == 1) {
         class175.clientInstance.method806(765, 503);
      } else {
         class175.clientInstance.method806(7680, 2160);
      }

      if(Client.gameState >= 25) {
         ScriptState.method985();
      }

   }
}
