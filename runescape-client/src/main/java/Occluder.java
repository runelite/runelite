import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("ax")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 782422459
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1484610523
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -76521329
   )
   @Export("type")
   int type;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 139696185
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1023829937
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 667754897
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1753328701
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -531341369
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1817049325
   )
   int field2116;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -240311403
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 721832507
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1964684551
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2142662919
   )
   int field2104;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1629126893
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -405098539
   )
   @Export("maxNormalY")
   int maxNormalY;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1525497335
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1913799435
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1924973569
   )
   @Export("maxTIleX")
   int maxTIleX;

   @ObfuscatedName("c")
   public static final void method2829(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            class3.method9(var0 - 1L);
            class3.method9(1L);
         } else {
            class3.method9(var0);
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lip;Ljava/lang/String;Ljava/lang/String;I)Ljx;",
      garbageValue = "-1832478642"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite var5;
      if(!ISAACCipher.method3381(var0, var3, var4)) {
         var5 = null;
      } else {
         IndexedSprite var7 = new IndexedSprite();
         var7.width = class286.field3780;
         var7.originalHeight = class286.field3781;
         var7.offsetX = class286.field3782[0];
         var7.offsetY = class286.offsetsY[0];
         var7.originalWidth = class286.field3779[0];
         var7.height = class286.field3787[0];
         var7.palette = class286.field3786;
         var7.pixels = class286.spritePixels[0];
         class286.field3782 = null;
         class286.offsetsY = null;
         class286.field3779 = null;
         class286.field3787 = null;
         class286.field3786 = null;
         class286.spritePixels = null;
         var5 = var7;
      }

      return var5;
   }
}
