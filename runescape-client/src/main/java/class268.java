import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
public final class class268 {
   @ObfuscatedName("p")
   static final char[] field3673;

   static {
      field3673 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1921098359"
   )
   static void method4754(Buffer var0) {
      if(Client.field943 != null) {
         var0.putBytes(Client.field943, 0, Client.field943.length);
      } else {
         byte[] var1 = class25.method201();
         var0.putBytes(var1, 0, var1.length);
      }
   }
}
