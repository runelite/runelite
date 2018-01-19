import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
final class class19 implements Comparator {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   public static IndexDataBase field317;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1865320805
   )
   static int field312;
   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("indexCache4")
   static IndexData indexCache4;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lt;Lt;I)I",
      garbageValue = "794914902"
   )
   int method139(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.field274 < var2.field274?-1:(var2.field274 == var1.field274?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method139((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1277660001"
   )
   static final int method149(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & 65280) * var2 + (var0 & 65280) * var3 & 16711680) + (var3 * (var0 & 16711935) + (var1 & 16711935) * var2 & -16711936) >> 8;
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-677897619"
   )
   static final void method144(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
         WorldMapData.method338(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1145 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(Lbp;ZI)V",
      garbageValue = "-1226148880"
   )
   static final void method138(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      int var5;
      if(var1 && var2 != -1 && class254.validInterfaces[var2]) {
         Widget.widgetIndex.method4319(var2);
         if(Widget.widgets[var2] != null) {
            boolean var6 = true;

            for(var5 = 0; var5 < Widget.widgets[var2].length; ++var5) {
               if(Widget.widgets[var2][var5] != null) {
                  if(Widget.widgets[var2][var5].type != 2) {
                     Widget.widgets[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               Widget.widgets[var2] = null;
            }

            class254.validInterfaces[var2] = false;
         }
      }

      for(IntegerNode var4 = (IntegerNode)Client.widgetFlags.first(); var4 != null; var4 = (IntegerNode)Client.widgetFlags.next()) {
         if((long)var2 == (var4.hash >> 48 & 65535L)) {
            var4.unlink();
         }
      }

      Widget var7 = UrlRequester.getWidget(var3);
      if(var7 != null) {
         class28.method220(var7);
      }

      GameCanvas.method779();
      if(Client.widgetRoot != -1) {
         var5 = Client.widgetRoot;
         if(FontName.loadWidget(var5)) {
            SoundTaskDataProvider.method762(Widget.widgets[var5], 1);
         }
      }

   }
}
