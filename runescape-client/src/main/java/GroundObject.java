import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1444615495
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1753943927
   )
   @Export("y")
   int y;
   @ObfuscatedName("z")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1697481399
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -958644251
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1158294053
   )
   int field1639;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass23;",
      garbageValue = "2044379842"
   )
   static class23 method2149(int var0) {
      class23 var1 = (class23)class23.field585.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class188.field3046.method3272(var0, 0);
         if(null == var2) {
            return null;
         } else {
            var1 = new class23();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.method2526();
            var1.field581 = var3.method2668();
            var1.field577 = var3.method2668();
            var1.field579 = var3.method2668();
            var1.field584 = var3.method2668();
            var3.offset = 0;
            var3.method2488();
            var1.field578 = new int[var4];
            var1.field580 = new int[var4];
            var1.field582 = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.field578[var5++] = var6) {
               var6 = var3.method2668();
               if(var6 == 3) {
                  var1.field582[var5] = var3.method2503();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field580[var5] = var3.method2526();
               } else {
                  var1.field580[var5] = var3.method2481();
               }
            }

            class23.field585.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IZI)LFrames;",
      garbageValue = "2108989496"
   )
   public static Frames method2150(class170 var0, class170 var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method3282(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method3255(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method3255(var8, 0);
            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }
}
