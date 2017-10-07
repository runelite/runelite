import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("ab")
public final class class29 {
   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "[Ljz;"
   )
   static IndexedSprite[] field432;
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   static Task field435;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   static IndexedSprite field431;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   final class41 this$0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 534048561
   )
   int field436;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 468929733
   )
   int field434;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2075524231
   )
   int field429;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1450828851
   )
   int field430;

   @ObfuscatedSignature(
      signature = "(Laj;)V"
   )
   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1692120928"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      class28.method234();
      ++Client.audioEffectCount;
      if(Client.audioEffectCount >= 50 || var0) {
         Client.audioEffectCount = 0;
         if(!Client.socketError && class268.rssocket != null) {
            Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_KEEPALIVE);

            try {
               class268.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
               Client.secretPacketBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.socketError = true;
            }
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "1305951217"
   )
   static int method236(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         int var4 = class81.intStack[class81.intStackSize + 1];
         if(!Client.field1160) {
            Client.field921 = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class81.intStack[++class81.intStackSize - 1] = Client.field921;
         return 1;
      } else if(var0 == 5506) {
         class81.intStack[++class81.intStackSize - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class81.intStack[--class81.intStackSize];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field1002 = var3;
         return 1;
      } else if(var0 == 5531) {
         class81.intStack[++class81.intStackSize - 1] = Client.field1002;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILit;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-386121004"
   )
   public static void method235(int var0, IndexDataBase var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.getFile(var2);
      int var7 = var1.getChild(var6, var3);
      class203.field2521 = 1;
      class203.field2522 = var1;
      class203.field2520 = var6;
      Frames.field2138 = var7;
      class148.field2203 = var4;
      BufferProvider.field3778 = var5;
      class288.field3814 = var0;
   }
}
