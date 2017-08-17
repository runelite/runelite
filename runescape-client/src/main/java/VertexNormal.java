import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   static Font field2006;
   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1665567319
   )
   @Export("x")
   int x;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 402248325
   )
   @Export("y")
   int y;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1324794307
   )
   @Export("z")
   int z;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -817014657
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Len;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }
}
