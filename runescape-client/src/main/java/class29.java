import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public final class class29 {
   @ObfuscatedName("ol")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   static class100 field431;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static IndexDataBase field428;
   @ObfuscatedName("t")
   static int[] field430;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 361414627
   )
   int field432;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1251520857
   )
   int field427;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 656939217
   )
   int field429;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 975977773
   )
   int field426;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Lag;"
   )
   final WorldMapManager this$0;

   @ObfuscatedSignature(
      signature = "(Lag;)V"
   )
   class29(WorldMapManager var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-1"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "76676029"
   )
   static int method249() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1372938560"
   )
   static final void method252() {
      Client.myPlayerIndex = 0;
      int var0 = (TotalQuantityComparator.localPlayer.x >> 7) + WorldMapType1.baseX;
      int var1 = (TotalQuantityComparator.localPlayer.y >> 7) + Enum.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.myPlayerIndex = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.myPlayerIndex = 1;
      }

      if(Client.myPlayerIndex == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.myPlayerIndex = 0;
      }

   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1387955860"
   )
   static final void method253(int var0) {
      if(class18.loadWidget(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2947 = 0;
               var3.field2948 = 0;
            }
         }

      }
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-55"
   )
   static final void method250() {
      PacketNode var0 = class31.method285(ClientPacket.field2431, Client.field899.field1470);
      Client.field899.method2082(var0);

      for(WidgetNode var1 = (WidgetNode)Client.componentTable.first(); var1 != null; var1 = (WidgetNode)Client.componentTable.next()) {
         if(var1.owner == 0 || var1.owner == 3) {
            class254.method4639(var1, true);
         }
      }

      if(Client.field1014 != null) {
         class171.method3363(Client.field1014);
         Client.field1014 = null;
      }

   }
}
