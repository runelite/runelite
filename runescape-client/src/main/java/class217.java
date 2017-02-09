import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
public final class class217 {
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 1166704265
   )
   @Export("menuY")
   static int menuY;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass182;IB)LModIcon;",
      garbageValue = "-121"
   )
   public static ModIcon method3958(class182 var0, int var1) {
      if(!class171.method3247(var0, var1)) {
         return null;
      } else {
         ModIcon var3 = new ModIcon();
         var3.width = class225.field3212;
         var3.originalHeight = class225.field3213;
         var3.offsetX = class163.field2287[0];
         var3.offsetY = class225.field3214[0];
         var3.originalWidth = class47.field932[0];
         var3.height = class225.field3211[0];
         var3.palette = class225.field3215;
         var3.pixels = class225.field3218[0];
         class221.method4056();
         return var3;
      }
   }

   class217() throws Throwable {
      throw new Error();
   }
}
