import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("NetWriter")
public class NetWriter {
   @ObfuscatedName("qs")
   static short[] field1432;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   @Export("rssocket")
   class168 rssocket;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   @Export("packetBufferNodes")
   CombatInfoList packetBufferNodes;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1718806989
   )
   int field1430;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("buffer")
   Buffer buffer;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   public ISAACCipher field1434;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("packetBuffer")
   PacketBuffer packetBuffer;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   @Export("serverPacket")
   ServerPacket serverPacket;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1151940223
   )
   @Export("packetLength")
   int packetLength;
   @ObfuscatedName("g")
   boolean field1444;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 641572529
   )
   int field1439;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2039230831
   )
   int field1440;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   ServerPacket field1441;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   ServerPacket field1442;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   ServerPacket field1443;

   NetWriter() {
      this.packetBufferNodes = new CombatInfoList();
      this.field1430 = 0;
      this.buffer = new Buffer(5000);
      this.packetBuffer = new PacketBuffer(40000);
      this.serverPacket = null;
      this.packetLength = 0;
      this.field1444 = true;
      this.field1439 = 0;
      this.field1440 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1077611787"
   )
   final void method2031() {
      this.packetBufferNodes.method4003();
      this.field1430 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1188683806"
   )
   final void method2057() throws IOException {
      if(this.rssocket != null && this.field1430 > 0) {
         this.buffer.offset = 0;

         while(true) {
            PacketNode var1 = (PacketNode)this.packetBufferNodes.last();
            if(var1 == null || var1.field2460 > this.buffer.payload.length - this.buffer.offset) {
               this.rssocket.vmethod3323(this.buffer.payload, 0, this.buffer.offset);
               this.field1440 = 0;
               break;
            }

            this.buffer.putBytes(var1.packetBuffer.payload, 0, var1.field2460);
            this.field1430 -= var1.field2460;
            var1.unlink();
            var1.packetBuffer.method3531();
            var1.method3447();
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgc;S)V",
      garbageValue = "-419"
   )
   public final void method2039(PacketNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.field2460 = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.field1430 += var1.field2460;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfi;I)V",
      garbageValue = "-2128391715"
   )
   @Export("setSocket")
   void setSocket(class168 var1) {
      this.rssocket = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-54001453"
   )
   @Export("close")
   void close() {
      if(this.rssocket != null) {
         this.rssocket.vmethod3317();
         this.rssocket = null;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1113085271"
   )
   void method2035() {
      this.rssocket = null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lfi;",
      garbageValue = "1846731600"
   )
   @Export("getSocket")
   class168 getSocket() {
      return this.rssocket;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lie;S)V",
      garbageValue = "128"
   )
   public static void method2062(IndexDataBase var0) {
      Enum.EnumDefinition_indexCache = var0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Lim;",
      garbageValue = "-49"
   )
   @Export("getWidget")
   public static Widget getWidget(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = class2.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-313623451"
   )
   public static String method2061(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = '*';
      }

      String var1 = new String(var3);
      return var1;
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "12"
   )
   static void method2041() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.first(); var0 != null; var0 = (WidgetNode)Client.componentTable.next()) {
         int var1 = var0.id;
         if(class2.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = getWidget(var4);
               if(var5 != null) {
                  ScriptEvent.method1132(var5);
               }
            }
         }
      }

   }
}
