import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fj")
public class class171 {
   @ObfuscatedName("a")
   public static class119 field2733 = new class119(8);
   @ObfuscatedName("z")
   public static class196 field2734 = new class196(4096);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1023506767
   )
   public static int field2735 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 14197957
   )
   public static int field2736 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -255306739
   )
   public static int field2737 = 0;
   @ObfuscatedName("v")
   public static class196 field2738 = new class196(4096);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 847765747
   )
   public static int field2739 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2136736525
   )
   public static int field2740 = 0;
   @ObfuscatedName("c")
   public static class203 field2741 = new class203();
   @ObfuscatedName("w")
   public static class143 field2742;
   @ObfuscatedName("j")
   static boolean field2743;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2034269315
   )
   public static int field2745 = 0;
   @ObfuscatedName("o")
   static CRC32 field2746 = new CRC32();
   @ObfuscatedName("k")
   static class168[] field2747 = new class168[256];
   @ObfuscatedName("f")
   public static byte field2748 = 0;
   @ObfuscatedName("y")
   public static class196 field2749 = new class196(32);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1369305477
   )
   public static int field2750 = 0;
   @ObfuscatedName("p")
   public static class196 field2752 = new class196(4096);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 448340633
   )
   public static int field2753 = 0;

   @ObfuscatedName("cs")
   static String method3414(String var0, class173 var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         String var4;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var4 = var0.substring(0, var3);
               int var6 = class15.method179(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(2 + var3);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(-1 == var2) {
               break;
            }

            String var7 = "";
            if(null != class104.field1805) {
               int var8 = class104.field1805.field2237;
               var4 = (var8 >> 24 & 255) + "." + (var8 >> 16 & 255) + "." + (var8 >> 8 & 255) + "." + (var8 & 255);
               var7 = var4;
               if(class104.field1805.field2234 != null) {
                  var7 = (String)class104.field1805.field2234;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(4 + var2);
         }
      }

      return var0;
   }
}
