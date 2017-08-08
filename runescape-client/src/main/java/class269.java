import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
public final class class269 {
   @ObfuscatedName("e")
   public static final char[] field3660;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static Widget field3661;

   static {
      field3660 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1759236293"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class239.field3237 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class239.field3237.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class239.field3237.close();
            } catch (Exception var3) {
               ;
            }

            ++class239.field3253;
            class239.field3237 = null;
         }

      }
   }
}
