import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
final class class12 implements Comparator {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("__n_n")
   static Widget __n_n;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;B)I",
      garbageValue = "-86"
   )
   int method149(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.__f < var2.__f?-1:(var1.__f == var2.__f?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method149((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1759858381"
   )
   public static boolean method162(int var0) {
      return var0 == 10 || var0 == 11 || var0 == 12 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16 || var0 == 17;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "1632289577"
   )
   static char method155(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "13"
   )
   static int method161(int var0) {
      Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
      return var1 == null?-1:(var1.previousDual == Messages.Messages_queue.sentinel?-1:((Message)var1.previousDual).count);
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1731524026"
   )
   static void method159() {
      for(WidgetGroupParent var0 = (WidgetGroupParent)Client.widgetGroupParents.first(); var0 != null; var0 = (WidgetGroupParent)Client.widgetGroupParents.next()) {
         int var1 = var0.group;
         if(GroundItemPile.loadWidgetGroup(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].isIf3;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.key;
               Widget var5 = Huffman.getWidget(var4);
               if(var5 != null) {
                  class22.method295(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("kg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-7"
   )
   static final void method158() {
      PacketBufferNode var0 = Interpreter.method1915(ClientPacket.__gs_cr, Client.packetWriter.isaacCipher);
      var0.packetBuffer.writeByte(0);
      Client.packetWriter.__q_167(var0);
   }
}
