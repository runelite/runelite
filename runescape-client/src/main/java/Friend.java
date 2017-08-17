import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 779938039
   )
   static int field821;
   @ObfuscatedName("j")
   @Export("name")
   String name;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 162229489
   )
   @Export("world")
   int world;
   @ObfuscatedName("x")
   boolean field818;
   @ObfuscatedName("g")
   boolean field819;
   @ObfuscatedName("h")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1763307289
   )
   @Export("rank")
   int rank;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-38"
   )
   public static void method1138() {
      Overlay.overlays.reset();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "602778050"
   )
   static int method1139(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1931517590"
   )
   static final void method1140(int var0, int var1) {
      if(Ignore.loadWidget(var0)) {
         class66.method1142(class176.widgets[var0], var1);
      }
   }
}
