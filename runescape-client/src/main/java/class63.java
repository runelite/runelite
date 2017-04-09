import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class63 implements Runnable {
   @ObfuscatedName("u")
   volatile boolean field1113 = false;
   @ObfuscatedName("i")
   volatile class57[] field1114 = new class57[2];
   @ObfuscatedName("f")
   class103 field1115;
   @ObfuscatedName("h")
   volatile boolean field1116 = false;
   @ObfuscatedName("cd")
   static Font field1119;
   @ObfuscatedName("x")
   static int[] field1122;

   public void run() {
      this.field1116 = true;

      try {
         while(!this.field1113) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class57 var2 = this.field1114[var1];
               if(var2 != null) {
                  var2.method1082();
               }
            }

            class115.method2300(10L);
            class183.method3415(this.field1115, (Object)null);
         }
      } catch (Exception var6) {
         GameObject.method1958((String)null, var6);
      } finally {
         this.field1116 = false;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "36"
   )
   static final int method1187(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
