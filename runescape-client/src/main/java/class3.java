import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
final class class3 implements class0 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lib;",
      garbageValue = "2109679698"
   )
   @Export("getWidget")
   public static Widget getWidget(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(class189.widgets[var1] == null || class189.widgets[var1][var2] == null) {
         boolean var3 = Name.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return class189.widgets[var1][var2];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(S)[Lis;",
      garbageValue = "25698"
   )
   public static Permission[] method6() {
      return new Permission[]{Permission.field3331, Permission.field3336, Permission.field3337, Permission.field3332, Permission.field3328, Permission.field3330};
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1880206451"
   )
   static void method3() {
      class93.playerIndexesCount = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class93.field1413[var0] = null;
         class93.field1409[var0] = 1;
      }

   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1787948330"
   )
   static final void method5() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            class289.method5205(var0);
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "63610416"
   )
   static void method4() {
      if(Client.spellSelected) {
         Widget var0 = ClientPacket.getWidgetChild(SoundTaskDataProvider.field623, Client.field1012);
         if(var0 != null && var0.onTargetLeaveListener != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.objs = var0.onTargetLeaveListener;
            AbstractByteBuffer.method3757(var1);
         }

         Client.spellSelected = false;
         WorldMapType1.method274(var0);
      }
   }
}
