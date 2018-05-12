import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "Lft;"
   )
   static class157 field1697;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1111459119
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1093572535
   )
   @Export("y")
   int y;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 557806907
   )
   @Export("z")
   int z;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1099818287
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Ldv;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "762356543"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class98.method2289(var0, var1, var2, var3, var4, var5, false);
   }
}
