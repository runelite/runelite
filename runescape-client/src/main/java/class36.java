import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class36 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   static final class36 field499;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   static final class36 field500;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 123171009
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 156324593
   )
   final int field501;

   static {
      field499 = new class36(0);
      field500 = new class36(1);
   }

   class36(int var1) {
      this.field501 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-809045324"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class264.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class264.NetCache_socket.vmethod3387(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class264.NetCache_socket.vmethod3379();
            } catch (Exception var3) {
               ;
            }

            ++class264.field3421;
            class264.NetCache_socket = null;
         }

      }
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1971554114"
   )
   static final void method502() {
      class85.method1886();
      if(WidgetNode.clanMemberManager != null) {
         WidgetNode.clanMemberManager.method5568();
      }

   }
}
