import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("dw")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1444657443
   )
   int field1687;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1294320375
   )
   int field1688;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -508663377
   )
   int field1689;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -129527397
   )
   int field1690;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "2027044735"
   )
   static char method2230(char var0) {
      return var0 != 181 && var0 != 402?Character.toTitleCase(var0):var0;
   }

   VertexNormal(VertexNormal var1) {
      this.field1690 = var1.field1690;
      this.field1687 = var1.field1687;
      this.field1688 = var1.field1688;
      this.field1689 = var1.field1689;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "-2002716920"
   )
   static int method2231(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method619()?(var1.method619()?0:1):(var1.method619()?-1:0)):(var2 == 5?(var0.method617()?(var1.method617()?0:1):(var1.method617()?-1:0)):(var2 == 6?(var0.method618()?(var1.method618()?0:1):(var1.method618()?-1:0)):(var2 == 7?(var0.method636()?(var1.method636()?0:1):(var1.method636()?-1:0)):var0.id - var1.id)))));
      }
   }

   VertexNormal() {
   }
}
