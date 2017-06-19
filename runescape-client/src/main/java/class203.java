import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class203 {
   @ObfuscatedName("p")
   public static IndexDataBase field2513;
   @ObfuscatedName("m")
   public static IndexDataBase field2514;
   @ObfuscatedName("e")
   public static IndexDataBase field2515;
   @ObfuscatedName("t")
   public static class204 field2516;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1202646483
   )
   public static int field2517;
   @ObfuscatedName("z")
   public static IndexDataBase field2518;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1840374475
   )
   public static int field2519;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -470040297
   )
   @Export("cameraPitch")
   static int cameraPitch;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
      garbageValue = "1933448217"
   )
   public static String method3571(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var8 = var0[var1];
         return var8 == null?"null":var8.toString();
      } else {
         int var3 = var2 + var1;
         int var4 = 0;

         for(int var5 = var1; var5 < var3; ++var5) {
            CharSequence var6 = var0[var5];
            if(var6 == null) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var9 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var3; ++var10) {
            CharSequence var7 = var0[var10];
            if(var7 == null) {
               var9.append("null");
            } else {
               var9.append(var7);
            }
         }

         return var9.toString();
      }
   }

   static {
      field2517 = 0;
   }
}
