import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 150586693
   )
   int field3795;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -600011571
   )
   @Export("count")
   int count;
   @ObfuscatedName("k")
   @Export("type")
   int[] type;
   @ObfuscatedName("z")
   @Export("errorIdentifiers")
   int[] errorIdentifiers;
   @ObfuscatedName("v")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("m")
   @Export("args")
   byte[][][] args;
   @ObfuscatedName("b")
   int[] field3798;
   @ObfuscatedName("t")
   @Export("methods")
   Method[] methods;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lid;IIB)Lky;",
      garbageValue = "120"
   )
   public static SpritePixels method5123(IndexDataBase var0, int var1, int var2) {
      if(!GroundObject.method2603(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class295.field3846;
         var4.maxHeight = class295.field3847;
         var4.offsetX = class295.field3848[0];
         var4.offsetY = class295.offsetsY[0];
         var4.width = class295.field3845[0];
         var4.height = class285.field3788[0];
         int var5 = var4.width * var4.height;
         byte[] var6 = TotalQuantityComparator.spritePixels[0];
         var4.pixels = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.pixels[var7] = class115.field1599[var6[var7] & 255];
         }

         class295.field3848 = null;
         class295.offsetsY = null;
         class295.field3845 = null;
         class285.field3788 = null;
         class115.field1599 = null;
         TotalQuantityComparator.spritePixels = null;
         return var4;
      }
   }
}
