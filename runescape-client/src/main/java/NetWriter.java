import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("NetWriter")
public class NetWriter {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("rssocket")
   class159 rssocket;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("packetBufferNodes")
   CombatInfoList packetBufferNodes;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2122835097
   )
   int field1445;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("buffer")
   Buffer buffer;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   public ISAACCipher field1454;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("packetBuffer")
   PacketBuffer packetBuffer;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("serverPacket")
   ServerPacket serverPacket;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 962318401
   )
   @Export("packetLength")
   int packetLength;
   @ObfuscatedName("z")
   boolean field1452;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1416729479
   )
   int field1456;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1658129769
   )
   int field1449;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   ServerPacket field1455;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   ServerPacket field1446;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   ServerPacket field1457;

   NetWriter() {
      this.packetBufferNodes = new CombatInfoList();
      this.field1445 = 0;
      this.buffer = new Buffer(5000);
      this.packetBuffer = new PacketBuffer(40000);
      this.serverPacket = null;
      this.packetLength = 0;
      this.field1452 = true;
      this.field1456 = 0;
      this.field1449 = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-6"
   )
   final void method2041() {
      this.packetBufferNodes.method3985();
      this.field1445 = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-297426778"
   )
   final void method2043() throws IOException {
      if(this.rssocket != null && this.field1445 > 0) {
         this.buffer.offset = 0;

         while(true) {
            PacketNode var1 = (PacketNode)this.packetBufferNodes.last();
            if(var1 == null || var1.field2437 > this.buffer.payload.length - this.buffer.offset) {
               this.rssocket.vmethod3304(this.buffer.payload, 0, this.buffer.offset);
               this.field1449 = 0;
               break;
            }

            this.buffer.putBytes(var1.packetBuffer.payload, 0, var1.field2437);
            this.field1445 -= var1.field2437;
            var1.unlink();
            var1.packetBuffer.method3574();
            var1.method3413();
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfv;B)V",
      garbageValue = "0"
   )
   public final void method2044(PacketNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.field2437 = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.field1445 += var1.field2437;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lff;I)V",
      garbageValue = "50096353"
   )
   @Export("setSocket")
   void setSocket(class159 var1) {
      this.rssocket = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1994137115"
   )
   @Export("close")
   void close() {
      if(this.rssocket != null) {
         this.rssocket.vmethod3299();
         this.rssocket = null;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-71"
   )
   void method2047() {
      this.rssocket = null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lff;",
      garbageValue = "2122463196"
   )
   @Export("getSocket")
   class159 getSocket() {
      return this.rssocket;
   }

   @ObfuscatedName("g")
   public static String method2045(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class291.field3791[(int)(var6 - 37L * var0)];
               if(var8 == '_') {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Lib;",
      garbageValue = "1167457763"
   )
   public static class239[] method2042() {
      return new class239[]{class239.field3250, class239.field3251, class239.field3255, class239.field3245, class239.field3247, class239.field3246, class239.field3244, class239.field3249};
   }
}
