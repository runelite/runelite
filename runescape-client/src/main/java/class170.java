import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class170 {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field2341;
   @ObfuscatedName("ko")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   static class87 field2344;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   public static final boolean method3195() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field639 == KeyFocusListener.field667) {
            return false;
         } else {
            class261.field3630 = KeyFocusListener.field664[KeyFocusListener.field667];
            class47.field618 = KeyFocusListener.field646[KeyFocusListener.field667];
            KeyFocusListener.field667 = KeyFocusListener.field667 + 1 & 127;
            return true;
         }
      }
   }
}
