import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1568519555
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -60030067
   )
   @Export("x")
   int x;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -519278479
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1094507869
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 885515339
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2056488293
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -717533729
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 121355007
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1338434239
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("k")
   static final void method3082(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2107841261"
   )
   public static void method3081() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field620 = KeyFocusListener.field623;
         KeyFocusListener.field638 = 0;
         int var1;
         if(KeyFocusListener.field627 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyFocusListener.keyPressed[var1] = false;
            }

            KeyFocusListener.field627 = KeyFocusListener.field626;
         } else {
            while(KeyFocusListener.field627 != KeyFocusListener.field626) {
               var1 = KeyFocusListener.field625[KeyFocusListener.field626];
               KeyFocusListener.field626 = KeyFocusListener.field626 + 1 & 127;
               if(var1 < 0) {
                  KeyFocusListener.keyPressed[~var1] = false;
               } else {
                  if(!KeyFocusListener.keyPressed[var1] && KeyFocusListener.field638 < KeyFocusListener.field630.length - 1) {
                     KeyFocusListener.field630[++KeyFocusListener.field638 - 1] = var1;
                  }

                  KeyFocusListener.keyPressed[var1] = true;
               }
            }
         }

         if(KeyFocusListener.field638 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field623 = KeyFocusListener.field631;
      }
   }
}
