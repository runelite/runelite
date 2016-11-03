import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2130975287
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -681283371
   )
   @Export("x")
   int x;
   @ObfuscatedName("es")
   static ModIcon[] field1666;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1320300485
   )
   int field1667;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1498850821
   )
   int field1668;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1696239527
   )
   int field1669;
   @ObfuscatedName("u")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("y")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -747456301
   )
   int field1672;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2136423971
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2066153689
   )
   @Export("y")
   int y;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -273482401
   )
   int field1675 = 0;
   @ObfuscatedName("mn")
   static SpritePixels field1677;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "2"
   )
   public static boolean method2237(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1715474457"
   )
   static final void method2238() {
      for(class16 var0 = (class16)Client.field413.method3864(); var0 != null; var0 = (class16)Client.field413.method3851()) {
         if(var0.field234 > 0) {
            --var0.field234;
         }

         boolean var1;
         int var2;
         int var3;
         ObjectComposition var4;
         if(var0.field234 == 0) {
            if(var0.field227 >= 0) {
               var2 = var0.field227;
               var3 = var0.field229;
               var4 = Projectile.getObjectDefinition(var2);
               if(var3 == 11) {
                  var3 = 10;
               }

               if(var3 >= 5 && var3 <= 8) {
                  var3 = 4;
               }

               var1 = var4.method838(var3);
               if(!var1) {
                  continue;
               }
            }

            class8.method101(var0.field226, var0.field231, var0.field228, var0.field225, var0.field227, var0.field236, var0.field229);
            var0.unlink();
         } else {
            if(var0.field233 > 0) {
               --var0.field233;
            }

            if(var0.field233 == 0 && var0.field228 >= 1 && var0.field225 >= 1 && var0.field228 <= 102 && var0.field225 <= 102) {
               if(var0.field230 >= 0) {
                  var2 = var0.field230;
                  var3 = var0.field232;
                  var4 = Projectile.getObjectDefinition(var2);
                  if(var3 == 11) {
                     var3 = 10;
                  }

                  if(var3 >= 5 && var3 <= 8) {
                     var3 = 4;
                  }

                  var1 = var4.method838(var3);
                  if(!var1) {
                     continue;
                  }
               }

               class8.method101(var0.field226, var0.field231, var0.field228, var0.field225, var0.field230, var0.field224, var0.field232);
               var0.field233 = -1;
               if(var0.field227 == var0.field230 && var0.field227 == -1) {
                  var0.unlink();
               } else if(var0.field230 == var0.field227 && var0.field224 == var0.field236 && var0.field229 == var0.field232) {
                  var0.unlink();
               }
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1578293290"
   )
   static final byte[] method2239(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.method2571();
      int var3 = var1.method2576();
      if(var3 >= 0 && (class170.field2732 == 0 || var3 <= class170.field2732)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2582(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2576();
            if(var4 < 0 || class170.field2732 != 0 && var4 > class170.field2732) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class120.method2526(var5, var4, var0, var3, 9);
               } else {
                  class170.field2728.method2518(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }
}
