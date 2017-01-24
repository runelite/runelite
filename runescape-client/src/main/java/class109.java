import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public abstract class class109 {
   @ObfuscatedName("k")
   public static int[] field1742;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1247412707"
   )
   abstract int vmethod1991(int var1, int var2);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-386451580"
   )
   public abstract void vmethod1992();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-758477077"
   )
   public static boolean method1999(int var0) {
      if(class157.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2240.method3185(var0)) {
         return false;
      } else {
         int var1 = Widget.field2240.method3192(var0);
         if(var1 == 0) {
            class157.validInterfaces[var0] = true;
            return true;
         } else {
            if(null == Widget.widgets[var0]) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.field2240.getConfigData(var0, var2);
                  if(null != var3) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3116(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3094(new Buffer(var3));
                     }
                  }
               }
            }

            class157.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(IIS)Ljava/lang/String;",
      garbageValue = "8594"
   )
   static final String method2000(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?Actor.method574(16711680):(var2 < -6?Actor.method574(16723968):(var2 < -3?Actor.method574(16740352):(var2 < 0?Actor.method574(16756736):(var2 > 9?Actor.method574('\uff00'):(var2 > 6?Actor.method574(4259584):(var2 > 3?Actor.method574(8453888):(var2 > 0?Actor.method574(12648192):Actor.method574(16776960))))))));
   }
}
