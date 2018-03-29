import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class190 {
   @ObfuscatedName("u")
   @Export("osName")
   public static String osName;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 1680759683
   )
   static int field2522;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "82"
   )
   public static void method3486() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field615 = KeyFocusListener.field617;
         KeyFocusListener.field593 = 0;
         int var1;
         if(KeyFocusListener.field610 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyFocusListener.keyPressed[var1] = false;
            }

            KeyFocusListener.field610 = KeyFocusListener.field609;
         } else {
            while(KeyFocusListener.field609 != KeyFocusListener.field610) {
               var1 = KeyFocusListener.field616[KeyFocusListener.field609];
               KeyFocusListener.field609 = KeyFocusListener.field609 + 1 & 127;
               if(var1 < 0) {
                  KeyFocusListener.keyPressed[~var1] = false;
               } else {
                  if(!KeyFocusListener.keyPressed[var1] && KeyFocusListener.field593 < KeyFocusListener.field613.length - 1) {
                     KeyFocusListener.field613[++KeyFocusListener.field593 - 1] = var1;
                  }

                  KeyFocusListener.keyPressed[var1] = true;
               }
            }
         }

         if(KeyFocusListener.field593 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field617 = KeyFocusListener.field606;
      }
   }

   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-77523360"
   )
   static final void method3487() {
      for(int var0 = 0; var0 < class93.playerIndexesCount; ++var0) {
         Player var1 = Client.cachedPlayers[class93.playerIndices[var0]];
         var1.method1166();
      }

      GameCanvas.method824();
      if(class33.clanMemberManager != null) {
         class33.clanMemberManager.method5468();
      }

   }
}
