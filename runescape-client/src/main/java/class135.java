import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class135 {
   @ObfuscatedName("x")
   static Hashtable field2083 = new Hashtable(16);
   @ObfuscatedName("u")
   public static File field2085;
   @ObfuscatedName("di")
   static byte[][] field2087;
   @ObfuscatedName("f")
   public static boolean field2088 = false;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1681601593"
   )
   public static boolean method2897(int var0) {
      if(class173.field2744[var0]) {
         return true;
      } else if(!class173.field2802.method3289(var0)) {
         return false;
      } else {
         int var1 = class173.field2802.method3321(var0);
         if(var1 == 0) {
            class173.field2744[var0] = true;
            return true;
         } else {
            if(class173.field2770[var0] == null) {
               class173.field2770[var0] = new class173[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == class173.field2770[var0][var2]) {
                  byte[] var3 = class173.field2802.method3286(var0, var2);
                  if(null != var3) {
                     class173.field2770[var0][var2] = new class173();
                     class173.field2770[var0][var2].field2869 = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class173.field2770[var0][var2].method3428(new class119(var3));
                     } else {
                        class173.field2770[var0][var2].method3435(new class119(var3));
                     }
                  }
               }
            }

            class173.field2744[var0] = true;
            return true;
         }
      }
   }
}
