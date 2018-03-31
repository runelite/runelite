import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kk")
public class class289 {
   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(Lbi;I)V",
      garbageValue = "-573699795"
   )
   static final void method5205(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class308.region.getWallObjectHash(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class308.region.method2903(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class308.region.method2904(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class308.region.getGroundObjectHash(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class308.region.getObjectFlags(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1137 = var2;
      var0.field1134 = var3;
      var0.field1138 = var4;
   }
}
