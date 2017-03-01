import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public abstract class class156 {
   @ObfuscatedName("n")
   static boolean field2111 = false;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "306247809"
   )
   abstract void vmethod3112(byte[] var1);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "89"
   )
   abstract byte[] vmethod3115();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "8"
   )
   public static boolean method3121() {
      try {
         if(class138.field1921 == 2) {
            if(DecorativeObject.field1614 == null) {
               DecorativeObject.field1614 = class144.method2791(class138.field1924, class168.field2193, class138.field1922);
               if(DecorativeObject.field1614 == null) {
                  return false;
               }
            }

            if(class30.field698 == null) {
               class30.field698 = new class60(class138.field1916, class138.field1917);
            }

            if(class138.field1919.method2648(DecorativeObject.field1614, class138.field1918, class30.field698, 22050)) {
               class138.field1919.method2578();
               class138.field1919.method2575(class101.field1661);
               class138.field1919.method2580(DecorativeObject.field1614, class138.field1923);
               class138.field1921 = 0;
               DecorativeObject.field1614 = null;
               class30.field698 = null;
               class138.field1924 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class138.field1919.method2672();
         class138.field1921 = 0;
         DecorativeObject.field1614 = null;
         class30.field698 = null;
         class138.field1924 = null;
      }

      return false;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-3"
   )
   public static int method3126(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-730559286"
   )
   public static String method3128(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = 42;
      }

      String var1 = new String(var3);
      return var1;
   }
}
