import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public abstract class class156 {
   @ObfuscatedName("x")
   static boolean field2096 = false;
   @ObfuscatedName("d")
   public static short[] field2098;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "659635151"
   )
   abstract void vmethod2996(byte[] var1);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "-1336245515"
   )
   public static void method2998(String var0, boolean var1, boolean var2) {
      class2.method24(var0, var1, "openjs", var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-1241589171"
   )
   abstract byte[] vmethod3000();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1536888711"
   )
   static void method3005() {
      XItemContainer.itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-905287914"
   )
   public static String method3010(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = XClanMember.method240(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(48 + var6));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(48 + var6));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
