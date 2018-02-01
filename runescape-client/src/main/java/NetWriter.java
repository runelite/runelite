import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("NetWriter")
public class NetWriter {
   @ObfuscatedName("ar")
   static int[] field1440;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("rssocket")
   class159 rssocket;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   @Export("packetBufferNodes")
   CombatInfoList packetBufferNodes;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 357159945
   )
   int field1437;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("buffer")
   Buffer buffer;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   public ISAACCipher field1439;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("packetBuffer")
   PacketBuffer packetBuffer;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   @Export("serverPacket")
   ServerPacket serverPacket;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1835324509
   )
   @Export("packetLength")
   int packetLength;
   @ObfuscatedName("m")
   boolean field1443;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1958033877
   )
   int field1450;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2076435761
   )
   int field1438;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   ServerPacket field1446;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   ServerPacket field1435;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   ServerPacket field1448;

   NetWriter() {
      this.packetBufferNodes = new CombatInfoList();
      this.field1437 = 0;
      this.buffer = new Buffer(5000);
      this.packetBuffer = new PacketBuffer(40000);
      this.serverPacket = null;
      this.packetLength = 0;
      this.field1443 = true;
      this.field1450 = 0;
      this.field1438 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1587775395"
   )
   final void method2040() {
      this.packetBufferNodes.method3828();
      this.field1437 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1654524803"
   )
   final void method2020() throws IOException {
      if(this.rssocket != null && this.field1437 > 0) {
         this.buffer.offset = 0;

         while(true) {
            PacketNode var1 = (PacketNode)this.packetBufferNodes.last();
            if(var1 == null || var1.field2400 > this.buffer.payload.length - this.buffer.offset) {
               this.rssocket.vmethod3192(this.buffer.payload, 0, this.buffer.offset);
               this.field1438 = 0;
               break;
            }

            this.buffer.putBytes(var1.packetBuffer.payload, 0, var1.field2400);
            this.field1437 -= var1.field2400;
            var1.unlink();
            var1.packetBuffer.method3388();
            var1.method3302();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfa;I)V",
      garbageValue = "-1806579795"
   )
   public final void method2021(PacketNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.field2400 = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.field1437 += var1.field2400;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfn;B)V",
      garbageValue = "47"
   )
   @Export("setSocket")
   void setSocket(class159 var1) {
      this.rssocket = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1710283776"
   )
   @Export("close")
   void close() {
      if(this.rssocket != null) {
         this.rssocket.vmethod3186();
         this.rssocket = null;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2062347974"
   )
   void method2023() {
      this.rssocket = null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lfn;",
      garbageValue = "1169149194"
   )
   @Export("getSocket")
   class159 getSocket() {
      return this.rssocket;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;II)Lhf;",
      garbageValue = "345186623"
   )
   static class218 method2043(IndexDataBase var0, int var1) {
      byte[] var2 = var0.takeRecordFlat(var1);
      return var2 == null?null:new class218(var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2039787633"
   )
   public static boolean method2042(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILcd;ZB)I",
      garbageValue = "53"
   )
   static int method2024(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class35.getWidget(class80.intStack[--class80.intStackSize]);
      } else {
         var3 = var2?class23.field331:GrandExchangeOffer.field297;
      }

      String var4 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = class80.intStack[--class80.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class80.intStack[--class80.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 's') {
            var8[var7] = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class80.intStack[--class80.intStackSize]);
         }
      }

      var7 = class80.intStack[--class80.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2820 = var8;
      } else if(var0 == 1401) {
         var3.field2823 = var8;
      } else if(var0 == 1402) {
         var3.field2760 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2832 = var8;
      } else if(var0 == 1406) {
         var3.field2830 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2838 = var8;
      } else if(var0 == 1410) {
         var3.field2849 = var8;
      } else if(var0 == 1411) {
         var3.field2812 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2780 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2761 = var8;
      } else if(var0 == 1419) {
         var3.field2841 = var8;
      } else if(var0 == 1420) {
         var3.field2842 = var8;
      } else if(var0 == 1421) {
         var3.field2843 = var8;
      } else if(var0 == 1422) {
         var3.field2844 = var8;
      } else if(var0 == 1423) {
         var3.field2821 = var8;
      } else if(var0 == 1424) {
         var3.field2771 = var8;
      } else if(var0 == 1425) {
         var3.field2848 = var8;
      } else if(var0 == 1426) {
         var3.field2834 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2744 = var8;
      }

      var3.field2813 = true;
      return 1;
   }
}
