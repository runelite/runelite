import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class231 extends Node {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1057810265
   )
   int field2726;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   class233 field2727;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   RawAudioNode field2713;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   class228 field2714;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -87976117
   )
   int field2715;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1718307031
   )
   int field2716;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1049364983
   )
   int field2717;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 245633695
   )
   int field2718;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1330286871
   )
   int field2712;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1741517933
   )
   int field2720;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1435443303
   )
   int field2721;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -432039263
   )
   int field2722;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1394928909
   )
   int field2719;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -731777075
   )
   int field2730;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1699483843
   )
   int field2711;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 20847529
   )
   int field2729;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1994946973
   )
   int field2724;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 904762329
   )
   int field2728;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   class115 field2723;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1036505937
   )
   int field2725;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -786331147
   )
   int field2731;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-656771161"
   )
   void method4292() {
      this.field2727 = null;
      this.field2713 = null;
      this.field2714 = null;
      this.field2723 = null;
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-118"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      MapIcon.method588();
      ++Client.field1072.field1462;
      if(Client.field1072.field1462 >= 50 || var0) {
         Client.field1072.field1462 = 0;
         if(!Client.socketError && Client.field1072.getSocket() != null) {
            PacketNode var1 = class33.method382(ClientPacket.field2431, Client.field1072.field1456);
            Client.field1072.method2073(var1);

            try {
               Client.field1072.method2077();
            } catch (IOException var3) {
               Client.socketError = true;
            }
         }

      }
   }
}
