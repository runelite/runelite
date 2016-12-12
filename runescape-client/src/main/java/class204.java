import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class204 {
   @ObfuscatedName("f")
   static final char[] field3077 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
   @ObfuscatedName("k")
   static final char[] field3078 = new char[]{'[', ']', '#'};
   @ObfuscatedName("ba")
   static class184 field3079;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "263104687"
   )
   static void method3735(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class225.field3214 = var1.readUnsignedShort();
      class225.field3217 = new int[class225.field3214];
      RSCanvas.field1748 = new int[class225.field3214];
      class225.field3218 = new int[class225.field3214];
      Item.field897 = new int[class225.field3214];
      class154.field2106 = new byte[class225.field3214][];
      var1.offset = var0.length - 7 - class225.field3214 * 8;
      class225.field3215 = var1.readUnsignedShort();
      class225.field3216 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class225.field3214; ++var3) {
         class225.field3217[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3214; ++var3) {
         RSCanvas.field1748[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3214; ++var3) {
         class225.field3218[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3214; ++var3) {
         Item.field897[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class225.field3214 * 8 - 3 * (var2 - 1);
      class167.field2191 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class167.field2191[var3] = var1.read24BitInt();
         if(class167.field2191[var3] == 0) {
            class167.field2191[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class225.field3214; ++var3) {
         int var4 = class225.field3218[var3];
         int var5 = Item.field897[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class154.field2106[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var10 * var4 + var9] = var1.readByte();
               }
            }
         }
      }

   }
}
