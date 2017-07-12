import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public final class class29 {
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -1127299349
   )
   static int field428;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1784050805
   )
   int field429;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1875234629
   )
   int field430;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 755200143
   )
   int field431;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 114895345
   )
   int field432;
   final class41 this$0;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIIZI)V",
      garbageValue = "-1726431391"
   )
   public static void method232(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class203.field2508 = 1;
      class61.field785 = var0;
      class203.field2511 = var1;
      class203.field2512 = var2;
      class203.field2513 = var3;
      class203.field2515 = var4;
      class203.field2517 = 10000;
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(IIIB)LWidgetNode;",
      garbageValue = "-47"
   )
   static final WidgetNode method233(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      class222.method4070(var1);
      Widget var4 = PacketBuffer.method3403(var0);
      class88.method1714(var4);
      if(Client.field1091 != null) {
         class88.method1714(Client.field1091);
         Client.field1091 = null;
      }

      class20.method142();
      WorldMapType2.method546(class46.widgets[var0 >> 16], var4, false);
      Ignore.method1136(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class66.loadWidget(var5)) {
            class5.method22(class46.widgets[var5], 1);
         }
      }

      return var3;
   }

   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   static final void method234() {
      int var0 = class96.field1521;
      int[] var1 = class96.field1531;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            RSCanvas.method809(var3, 1);
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-111"
   )
   public static boolean method235(int var0) {
      return (var0 >> 29 & 1) != 0;
   }
}
