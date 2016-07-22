import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class75 implements Runnable {
   @ObfuscatedName("g")
   static class83[] field1421;
   @ObfuscatedName("w")
   volatile class59[] field1422 = new class59[2];
   @ObfuscatedName("e")
   volatile boolean field1423 = false;
   @ObfuscatedName("m")
   class139 field1425;
   @ObfuscatedName("u")
   public static boolean field1427;
   @ObfuscatedName("ed")
   static class81 field1428;
   @ObfuscatedName("o")
   volatile boolean field1429 = false;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "-51"
   )
   public static char method1660(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }

   public void run() {
      this.field1429 = true;

      try {
         while(!this.field1423) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class59 var2 = this.field1422[var1];
               if(null != var2) {
                  var2.method1250();
               }
            }

            class141.method2993(10L);
            class113.method2488(this.field1425, (Object)null);
         }
      } catch (Exception var7) {
         class54.method1130((String)null, var7);
      } finally {
         this.field1429 = false;
      }

   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "1"
   )
   static final String method1663(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class51.method1096('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class51.method1096(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class51.method1096(16776960) + var1 + "</col>");
   }
}
