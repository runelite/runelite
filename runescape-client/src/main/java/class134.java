import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class134 {
   @ObfuscatedName("a")
   static boolean field1999;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1073131727
   )
   static int field1991;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 98860401
   )
   static int field1996;
   @ObfuscatedName("r")
   static boolean field1990;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -380030627
   )
   public static int field1995;
   @ObfuscatedName("t")
   public static int[] field1988;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -693648645
   )
   static int field1987;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1384557111
   )
   static int field1992;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1180815307
   )
   static int field1993;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -660286685
   )
   static int field1994;

   static {
      field1999 = false;
      field1991 = 0;
      field1996 = 0;
      field1990 = false;
      field1995 = 0;
      field1988 = new int[1000];
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "256"
   )
   static final int method2587() {
      return Client.menuOptionCount <= 0?-1:(Client.field1054 && KeyFocusListener.field626[81] && Client.field940 != -1?Client.field940:Client.menuOptionCount - 1);
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "896769597"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      class46.method712();
      ++Client.audioEffectCount;
      if(Client.audioEffectCount >= 50 || var0) {
         Client.audioEffectCount = 0;
         if(!Client.socketError && Occluder.rssocket != null) {
            Client.secretPacketBuffer1.putOpcode(102);

            try {
               Occluder.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
               Client.secretPacketBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.socketError = true;
            }
         }

      }
   }
}
