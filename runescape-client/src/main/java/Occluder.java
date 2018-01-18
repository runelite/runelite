import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("aj")
   protected static String field2048;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1174365471
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 295152925
   )
   @Export("maxTIleX")
   int maxTIleX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 180896165
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2127870165
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -980863161
   )
   @Export("type")
   int type;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -101138541
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -555560423
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2146142723
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1658877971
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -869990365
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1537764779
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 207502883
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1943418397
   )
   int field2053;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 62467425
   )
   int field2059;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1199725755
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2003736157
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1266217975
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 70756975
   )
   @Export("maxNormalY")
   int maxNormalY;

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(Lhq;IIS)V",
      garbageValue = "-4009"
   )
   static final void method2959(Widget var0, int var1, int var2) {
      if(Client.field1028 == null && !Client.isMenuOpen) {
         if(var0 != null && class239.method4280(var0) != null) {
            Client.field1028 = var0;
            Client.field1029 = class239.method4280(var0);
            Client.field925 = var1;
            Client.field1001 = var2;
            class44.field555 = 0;
            Client.field1039 = false;
            int var3 = class240.method4281();
            if(var3 != -1) {
               ChatLineBuffer.topContextMenuRow = new ContextMenuRow();
               ChatLineBuffer.topContextMenuRow.param0 = Client.menuActionParams0[var3];
               ChatLineBuffer.topContextMenuRow.param1 = Client.menuActionParams1[var3];
               ChatLineBuffer.topContextMenuRow.type = Client.menuTypes[var3];
               ChatLineBuffer.topContextMenuRow.identifier = Client.menuIdentifiers[var3];
               ChatLineBuffer.topContextMenuRow.option = Client.menuOptions[var3];
            }

         }
      }
   }
}
