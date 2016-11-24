import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("qi")
   static class109 field1414;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1927254061
   )
   int field1415;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -998944889
   )
   int field1416;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -794929269
   )
   int field1417;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -529426927
   )
   int field1418;

   VertexNormal(VertexNormal var1) {
      this.field1417 = var1.field1417;
      this.field1415 = var1.field1415;
      this.field1418 = var1.field1418;
      this.field1416 = var1.field1416;
   }

   VertexNormal() {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "0"
   )
   public static String method1664(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class203.field3067[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }
}
