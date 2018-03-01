import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class157 extends class297 {
   @ObfuscatedName("d")
   final boolean field2138;

   public class157(boolean var1) {
      this.field2138 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkz;Lkz;S)I",
      garbageValue = "-18534"
   )
   int method3240(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field2138?var1.method5385().method5536(var2.method5385()):var2.method5385().method5536(var1.method5385())):this.method5387(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3240((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "34"
   )
   public static void method3245() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field640 = KeyFocusListener.field642;
         KeyFocusListener.field639 = 0;
         int var1;
         if(KeyFocusListener.field637 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyFocusListener.keyPressed[var1] = false;
            }

            KeyFocusListener.field637 = KeyFocusListener.field634;
         } else {
            while(KeyFocusListener.field634 != KeyFocusListener.field637) {
               var1 = KeyFocusListener.field632[KeyFocusListener.field634];
               KeyFocusListener.field634 = KeyFocusListener.field634 + 1 & 127;
               if(var1 < 0) {
                  KeyFocusListener.keyPressed[~var1] = false;
               } else {
                  if(!KeyFocusListener.keyPressed[var1] && KeyFocusListener.field639 < KeyFocusListener.field638.length - 1) {
                     KeyFocusListener.field638[++KeyFocusListener.field639 - 1] = var1;
                  }

                  KeyFocusListener.keyPressed[var1] = true;
               }
            }
         }

         if(KeyFocusListener.field639 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field642 = KeyFocusListener.field641;
      }
   }
}
