import java.util.Calendar;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class36 {
   @ObfuscatedName("a")
   static String[] field769 = new String[1000];
   @ObfuscatedName("f")
   static int[] field771;
   @ObfuscatedName("s")
   static String[] field772;
   @ObfuscatedName("p")
   static int[] field773 = new int[5];
   @ObfuscatedName("i")
   static final String[] field774 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("g")
   static int[] field775 = new int[1000];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2070534951
   )
   static int field777 = 0;
   @ObfuscatedName("k")
   static class14[] field778 = new class14[50];
   @ObfuscatedName("n")
   static class173 field779;
   @ObfuscatedName("h")
   static int[][] field780 = new int[5][5000];
   @ObfuscatedName("y")
   static Calendar field781 = Calendar.getInstance();
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 692316401
   )
   static int field782 = 0;
   @ObfuscatedName("an")
   static class146 field783;
   @ObfuscatedName("pb")
   static class160 field784;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "0"
   )
   public static Object method734(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class125.field2029) {
            try {
               class118 var1 = new class118();
               var1.vmethod2795(var0);
               return var1;
            } catch (Throwable var2) {
               class125.field2029 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("f")
   public static void method736() {
      if(class140.field2142 != null) {
         class140 var0 = class140.field2142;
         synchronized(class140.field2142) {
            class140.field2142 = null;
         }
      }

   }

   @ObfuscatedName("e")
   public static int method740(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIZIZB)V",
      garbageValue = "-123"
   )
   static void method741(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         class25 var8 = class25.field615[var6];
         class25.field615[var6] = class25.field615[var1];
         class25.field615[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class20.method567(class25.field615[var9], var8, var2, var3, var4, var5) <= 0) {
               class25 var10 = class25.field615[var9];
               class25.field615[var9] = class25.field615[var7];
               class25.field615[var7++] = var10;
            }
         }

         class25.field615[var1] = class25.field615[var7];
         class25.field615[var7] = var8;
         method741(var0, var7 - 1, var2, var3, var4, var5);
         method741(1 + var7, var1, var2, var3, var4, var5);
      }

   }
}
