import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -957189935
   )
   int field1674;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1846326309
   )
   int field1675;
   @ObfuscatedName("n")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -721165147
   )
   int field1677;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -331467943
   )
   int field1678;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -74869437
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -210082945
   )
   @Export("x")
   int x;
   @ObfuscatedName("u")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -998956615
   )
   @Export("y")
   int y;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -178524487
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1543314197
   )
   int field1684 = 0;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = 304603217
   )
   static int field1687;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -1237554565
   )
   static int field1688;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IZI)LFrames;",
      garbageValue = "1352353564"
   )
   public static Frames method2255(class170 var0, class170 var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method3395(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method3401(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method3401(var8, 0);
            if(null == var9) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var10) {
            return null;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1185823554"
   )
   static final void method2256(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class5.tileHeights[var0][var3 + var1][var2 + var4] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.tileHeights[var0][var1][var3 + var2] = class5.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.tileHeights[var0][var1 + var3][var2] = class5.tileHeights[var0][var1 + var3][var2 - 1];
         }
      }

      if(var1 > 0 && class5.tileHeights[var0][var1 - 1][var2] != 0) {
         class5.tileHeights[var0][var1][var2] = class5.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class5.tileHeights[var0][var1][var2 - 1] != 0) {
         class5.tileHeights[var0][var1][var2] = class5.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class5.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class5.tileHeights[var0][var1][var2] = class5.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }
}
