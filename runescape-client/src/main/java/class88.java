import java.awt.Image;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class88 {
   @ObfuscatedName("d")
   static final BigInteger field1321;
   @ObfuscatedName("z")
   static final BigInteger field1322;
   @ObfuscatedName("ai")
   static Image field1323;

   static {
      field1321 = new BigInteger("10001", 16);
      field1322 = new BigInteger("add0f75085c68da2f4e301856c095b47370bd63793b29b9ecdc8c860551ac8d02915a740062e2289704f7a8f315e278577060b4d5e2558f924642e1c046732302f6588bf5d915ba0fa584339b02606b0c395d7107067fe373ee10f339a6d7da0ce198bafd35694dfc16c2d69af2d0bd01077f39bc16d6b59db43991d9f628309", 16);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-668160755"
   )
   public static boolean method1895(char var0) {
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 != 0) {
            char[] var1 = class314.cp1252AsciiExtension;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
