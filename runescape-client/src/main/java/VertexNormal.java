import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 414861777
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -452402409
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1994923257
   )
   @Export("z")
   int z;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 970067579
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Lev;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgd;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1950367367"
   )
   static String method2702(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }
}
