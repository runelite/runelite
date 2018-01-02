import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.HashMap;

@ObfuscatedName("fu")
public class class179 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2023707237
   )
   public static int field2463;

   static {
      new HashMap();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "367564648"
   )
   @Export("removeKeyboardFocusListener")
   public static void removeKeyboardFocusListener() {
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var0 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

   }
}
