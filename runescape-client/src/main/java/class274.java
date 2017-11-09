import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
public class class274 {
   @ObfuscatedName("i")
   static final char[] field3722;
   @ObfuscatedName("j")
   static final char[] field3724;

   static {
      field3722 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
      field3724 = new char[]{'[', ']', '#'};
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1262547714"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      class90.method1801();
      ++Client.field952.field1466;
      if(Client.field952.field1466 >= 50 || var0) {
         Client.field952.field1466 = 0;
         if(!Client.socketError && Client.field952.method1954() != null) {
            class170 var1 = Actor.method1628(ClientPacket.field2307, Client.field952.field1478);
            Client.field952.method1951(var1);

            try {
               Client.field952.method1958();
            } catch (IOException var3) {
               Client.socketError = true;
            }
         }

      }
   }
}
