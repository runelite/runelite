import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("a")
   static class228 field1561;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2022334511
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -538913947
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -752536613
   )
   @Export("z")
   int z;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1345744345"
   )
   static String method1893() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class47.field928.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }
}
