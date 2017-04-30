import java.applet.Applet;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public class class114 {
   @ObfuscatedName("c")
   static String field1788;
   @ObfuscatedName("nm")
   static class51 field1791;
   @ObfuscatedName("d")
   static Applet field1793;
   @ObfuscatedName("l")
   public static short[] field1794;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-34"
   )
   public static int method2208(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class180.method3276(var0.charAt(var3));
      }

      return var2;
   }

   class114() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "104"
   )
   static final void method2211(boolean var0) {
      GameEngine.method2201();
      ++Client.field331;
      if(Client.field331 >= 50 || var0) {
         Client.field331 = 0;
         if(!Client.field336 && Friend.rssocket != null) {
            Client.secretPacketBuffer1.putOpcode(102);

            try {
               Friend.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
               Client.secretPacketBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.field336 = true;
            }
         }

      }
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1539634550"
   )
   static final int method2212() {
      return Client.menuOptionCount <= 0?-1:(Client.field432 && class105.field1695[81] && Client.field431 != -1?Client.field431:Client.menuOptionCount - 1);
   }

   static {
      field1793 = null;
      field1788 = null;
   }
}
