import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public final class class230 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "92"
   )
   public static void method4094() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field659 = KeyFocusListener.field652;
         KeyFocusListener.field649 = 0;
         int var1;
         if(KeyFocusListener.field645 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyFocusListener.field642[var1] = false;
            }

            KeyFocusListener.field645 = KeyFocusListener.field650;
         } else {
            while(KeyFocusListener.field645 != KeyFocusListener.field650) {
               var1 = KeyFocusListener.field635[KeyFocusListener.field650];
               KeyFocusListener.field650 = KeyFocusListener.field650 + 1 & 127;
               if(var1 < 0) {
                  KeyFocusListener.field642[~var1] = false;
               } else {
                  if(!KeyFocusListener.field642[var1] && KeyFocusListener.field649 < KeyFocusListener.field637.length - 1) {
                     KeyFocusListener.field637[++KeyFocusListener.field649 - 1] = var1;
                  }

                  KeyFocusListener.field642[var1] = true;
               }
            }
         }

         if(KeyFocusListener.field649 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field652 = KeyFocusListener.field651;
      }
   }
}
