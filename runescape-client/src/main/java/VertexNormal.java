import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1493288071
   )
   @Export("x")
   int x;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 768970437
   )
   @Export("y")
   int y;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 484112089
   )
   @Export("z")
   int z;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 64441025
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Leq;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "572386918"
   )
   @Export("drawWidget")
   static final void drawWidget(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class33.loadWidget(var0)) {
         class203.field2508 = null;
         Frames.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class203.field2508 != null) {
            Frames.gameDraw(class203.field2508, -1412584499, var1, var2, var3, var4, Ignore.field846, class45.field579, var7);
            class203.field2508 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1111[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1111[var8] = true;
            }
         }

      }
   }
}
