import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = -789768693
   )
   static int field2000;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 437625143
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1333043881
   )
   @Export("x")
   int x;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1121187441
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1482414659
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -676519619
   )
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1894630301
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 610890031
   )
   @Export("config")
   int config;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "1733939807"
   )
   static void method3002(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = class89.worldList[var6];
         class89.worldList[var6] = class89.worldList[var1];
         class89.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = class89.worldList[var9];
            int var12 = UnitPriceComparator.method134(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = UnitPriceComparator.method134(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = class89.worldList[var9];
               class89.worldList[var9] = class89.worldList[var7];
               class89.worldList[var7++] = var14;
            }
         }

         class89.worldList[var1] = class89.worldList[var7];
         class89.worldList[var7] = var8;
         method3002(var0, var7 - 1, var2, var3, var4, var5);
         method3002(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
