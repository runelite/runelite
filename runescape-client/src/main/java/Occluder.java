import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1377100417
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1669354965
   )
   @Export("maxTIleX")
   int maxTIleX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1364764655
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1798184553
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -153010939
   )
   @Export("type")
   int type;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -25611653
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -663628629
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 162046975
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1738272033
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -925867423
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1204169261
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 619543051
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 964713391
   )
   int field2047;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1489984035
   )
   int field2044;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1499501973
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -743903315
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 236692935
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1329319429
   )
   @Export("maxNormalY")
   int maxNormalY;

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(Lhz;I)Z",
      garbageValue = "1457404273"
   )
   static boolean method2905(Widget var0) {
      if(Client.field978) {
         if(class36.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-841022133"
   )
   static void method2906(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class179.field2463; ++var4) {
         ItemComposition var5 = KitDefinition.getItemDefinition(var4);
         if((!var1 || var5.isTradable) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class41.field523 = -1;
               Actor.field1182 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      Actor.field1182 = var2;
      WidgetNode.field766 = 0;
      class41.field523 = var3;
      String[] var8 = new String[class41.field523];

      for(int var9 = 0; var9 < class41.field523; ++var9) {
         var8[var9] = KitDefinition.getItemDefinition(var2[var9]).name;
      }

      class213.method3833(var8, Actor.field1182);
   }
}
