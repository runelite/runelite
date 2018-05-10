import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
public class class262 {
   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "[Llc;"
   )
   @Export("headIconsHint")
   static SpritePixels[] headIconsHint;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2069142999"
   )
   static void method4940() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.KeyHandler_keyCodes[186] = 57;
         KeyFocusListener.KeyHandler_keyCodes[187] = 27;
         KeyFocusListener.KeyHandler_keyCodes[188] = 71;
         KeyFocusListener.KeyHandler_keyCodes[189] = 26;
         KeyFocusListener.KeyHandler_keyCodes[190] = 72;
         KeyFocusListener.KeyHandler_keyCodes[191] = 73;
         KeyFocusListener.KeyHandler_keyCodes[192] = 58;
         KeyFocusListener.KeyHandler_keyCodes[219] = 42;
         KeyFocusListener.KeyHandler_keyCodes[220] = 74;
         KeyFocusListener.KeyHandler_keyCodes[221] = 43;
         KeyFocusListener.KeyHandler_keyCodes[222] = 59;
         KeyFocusListener.KeyHandler_keyCodes[223] = 28;
      } else {
         KeyFocusListener.KeyHandler_keyCodes[44] = 71;
         KeyFocusListener.KeyHandler_keyCodes[45] = 26;
         KeyFocusListener.KeyHandler_keyCodes[46] = 72;
         KeyFocusListener.KeyHandler_keyCodes[47] = 73;
         KeyFocusListener.KeyHandler_keyCodes[59] = 57;
         KeyFocusListener.KeyHandler_keyCodes[61] = 27;
         KeyFocusListener.KeyHandler_keyCodes[91] = 42;
         KeyFocusListener.KeyHandler_keyCodes[92] = 74;
         KeyFocusListener.KeyHandler_keyCodes[93] = 43;
         KeyFocusListener.KeyHandler_keyCodes[192] = 28;
         KeyFocusListener.KeyHandler_keyCodes[222] = 58;
         KeyFocusListener.KeyHandler_keyCodes[520] = 59;
      }

   }
}
