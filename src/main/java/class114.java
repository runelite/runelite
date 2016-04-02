import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
public class class114 {
   @ObfuscatedName("k")
   static final int method2463(int var0, int var1) {
      int var2 = class124.method2793('넵' + var0, var1 + 91923, 4) - 128 + (class124.method2793(10294 + var0, var1 + '鎽', 2) - 128 >> 1) + (class124.method2793(var0, var1, 1) - 128 >> 2);
      var2 = (int)(0.3D * (double)var2) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }
}
