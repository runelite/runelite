import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class53 extends class207 {
   @ObfuscatedName("e")
   public boolean field1156 = false;
   @ObfuscatedName("s")
   public static String[] field1159;
   @ObfuscatedName("w")
   public static class196 field1163 = new class196(64);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "124"
   )
   public void method1113(class122 var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method1114(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "-2047921962"
   )
   void method1114(class122 var1, int var2) {
      if(var2 == 2) {
         this.field1156 = true;
      }

   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1317943049"
   )
   static boolean method1118(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class23.method579(var0, class134.field2117);

         for(int var2 = 0; var2 < client.field543; ++var2) {
            class7 var3 = client.field384[var2];
            if(var1.equalsIgnoreCase(class23.method579(var3.field120, class134.field2117))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class23.method579(var3.field122, class134.field2117))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "-641060655"
   )
   static final String method1123(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class51.method1096(16711680):(var2 < -6?class51.method1096(16723968):(var2 < -3?class51.method1096(16740352):(var2 < 0?class51.method1096(16756736):(var2 > 9?class51.method1096('\uff00'):(var2 > 6?class51.method1096(4259584):(var2 > 3?class51.method1096(8453888):(var2 > 0?class51.method1096(12648192):class51.method1096(16776960))))))));
   }
}
