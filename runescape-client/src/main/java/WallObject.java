import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cq")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1125151613
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -887309967
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 491936293
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1817229001
   )
   int field1543;
   @ObfuscatedName("a")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("n")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 716597143
   )
   int field1546 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1610776803
   )
   int field1547;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      intValue = 1068118165
   )
   static int field1548;
   @ObfuscatedName("gt")
   static Widget field1550;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -107271671
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("h")
   static int[] field1552;

   @ObfuscatedName("e")
   public static String method1863(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(0L != var0) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class205.field3082[(int)(var6 - 37L * var0)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }
}
