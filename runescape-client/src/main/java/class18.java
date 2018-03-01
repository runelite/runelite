import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
final class class18 implements Comparator {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -683208795
   )
   static int field325;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;I)I",
      garbageValue = "2086369918"
   )
   int method128(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.method85().compareTo(var2.method85());
   }

   public int compare(Object var1, Object var2) {
      return this.method128((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1554055840"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!class3.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = class3.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = class3.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Lbq;",
      garbageValue = "86"
   )
   static World method132() {
      World.field1210 = 0;
      return ServerPacket.method3479();
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1151073734"
   )
   static void method137() {
      if(Client.field927 == 1) {
         Client.field933 = true;
      }

   }
}
