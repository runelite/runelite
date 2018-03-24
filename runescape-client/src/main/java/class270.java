import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
public class class270 extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   public static IndexDataBase field3480;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3478;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ldc;"
   )
   static class110 field3481;
   @ObfuscatedName("i")
   public boolean field3477;

   static {
      field3478 = new NodeCache(64);
   }

   public class270() {
      this.field3477 = false;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "-1727418854"
   )
   public void method4790(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4791(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "-551559342"
   )
   void method4791(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3477 = true;
      }

   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1824769960"
   )
   static void method4793(int var0, int var1) {
      PacketNode var2 = class33.method382(ClientPacket.field2442, Client.field1072.field1456);
      var2.packetBuffer.method3573(var1);
      var2.packetBuffer.method3584(var0);
      Client.field1072.method2073(var2);
   }
}
