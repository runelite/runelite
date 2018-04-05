import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class160 implements class159 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-266869876"
   )
   public static final boolean method3183() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field623 == KeyFocusListener.field620) {
            return false;
         } else {
            Item.currentPressedKey = KeyFocusListener.field629[KeyFocusListener.field620];
            class38.currentTypedKey = KeyFocusListener.field632[KeyFocusListener.field620];
            KeyFocusListener.field620 = KeyFocusListener.field620 + 1 & 127;
            return true;
         }
      }
   }
}
