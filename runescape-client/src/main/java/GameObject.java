import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = -1897588441
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1598726543
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1208124807
   )
   @Export("height")
   int height;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 5448397
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1739711847
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1873257555
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1909062177
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -356856951
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2099769969
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 130844357
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1256245897
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 18264501
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1098471211
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1923712533
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "-1363565571"
   )
   public static long method3072(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 'A' && var5 <= 'Z') {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 'a' && var5 <= 'z') {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= '0' && var5 <= '9') {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }
}
