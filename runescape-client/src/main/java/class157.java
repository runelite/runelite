import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class157 {
   @ObfuscatedName("u")
   static String[] field2123;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)LSpritePixels;",
      garbageValue = "252172223"
   )
   public static SpritePixels method2970(class182 var0, String var1, String var2) {
      int var3 = var0.method3225(var1);
      int var4 = var0.method3226(var3, var2);
      return Player.method218(var0, var3, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass48;",
      garbageValue = "-1227697320"
   )
   static class48 method2971(int var0) {
      class48 var1 = (class48)class48.field953.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class65.field1111.method3211(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new class48();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.method2844();
            var1.field952 = var3.readUnsignedShort();
            var1.field955 = var3.readUnsignedShort();
            var1.field954 = var3.readUnsignedShort();
            var1.field949 = var3.readUnsignedShort();
            var3.offset = 0;
            var3.method2766();
            var1.field950 = new int[var4];
            var1.field948 = new int[var4];
            var1.field951 = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.field950[var5++] = var6) {
               var6 = var3.readUnsignedShort();
               if(var6 == 3) {
                  var1.field951[var5] = var3.method2767();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field948[var5] = var3.method2844();
               } else {
                  var1.field948[var5] = var3.readUnsignedByte();
               }
            }

            class48.field953.put(var1, (long)var0);
            return var1;
         }
      }
   }
}
