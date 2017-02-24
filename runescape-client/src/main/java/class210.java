import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class210 {
   @ObfuscatedName("h")
   static class182 field3124;
   @ObfuscatedName("a")
   static String field3125;
   @ObfuscatedName("q")
   static class145 field3126;

   class210() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-459556046"
   )
   static void method3984(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class225.field3232 = var1.readUnsignedShort();
      Ignore.field223 = new int[class225.field3232];
      class225.field3233 = new int[class225.field3232];
      class225.field3234 = new int[class225.field3232];
      class41.field862 = new int[class225.field3232];
      class11.field129 = new byte[class225.field3232][];
      var1.offset = var0.length - 7 - class225.field3232 * 8;
      class202.field3074 = var1.readUnsignedShort();
      class225.field3231 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class225.field3232; ++var3) {
         Ignore.field223[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3232; ++var3) {
         class225.field3233[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3232; ++var3) {
         class225.field3234[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3232; ++var3) {
         class41.field862[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class225.field3232 * 8 - 3 * (var2 - 1);
      class160.field2146 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class160.field2146[var3] = var1.read24BitInt();
         if(class160.field2146[var3] == 0) {
            class160.field2146[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class225.field3232; ++var3) {
         int var4 = class225.field3234[var3];
         int var5 = class41.field862[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class11.field129[var3] = var7;
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
