import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("cx")
public class class89 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -801683657
   )
   int field1381;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -842736513
   )
   int field1382;
   @ObfuscatedName("gl")
   static SpritePixels[] field1383;
   @ObfuscatedName("g")
   String field1384;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1409750449
   )
   static int field1385;
   @ObfuscatedName("a")
   static int[] field1387;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 876697505
   )
   int field1391;
   @ObfuscatedName("l")
   static ModIcon[] field1392;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 993832499
   )
   int field1394;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "731002858"
   )
   public static boolean method1744() {
      try {
         if(class203.field2498 == 2) {
            if(class203.field2497 == null) {
               class203.field2497 = Track1.method3977(Varbit.field3380, class169.field2325, class203.field2499);
               if(class203.field2497 == null) {
                  return false;
               }
            }

            if(Varbit.field3377 == null) {
               Varbit.field3377 = new class112(class203.field2502, class203.field2503);
            }

            if(class36.field501.method3849(class203.field2497, class203.field2496, Varbit.field3377, 22050)) {
               class36.field501.method3820();
               class36.field501.method3754(class203.field2500);
               class36.field501.method3759(class203.field2497, class203.field2495);
               class203.field2498 = 0;
               class203.field2497 = null;
               Varbit.field3377 = null;
               Varbit.field3380 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class36.field501.method3801();
         class203.field2498 = 0;
         class203.field2497 = null;
         Varbit.field3377 = null;
         Varbit.field3380 = null;
      }

      return false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "20619996"
   )
   static Class method1745(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }
}
