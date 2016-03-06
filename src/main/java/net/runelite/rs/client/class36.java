package net.runelite.rs.client;
import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("as")
public class class36 {
   @ObfuscatedName("k")
   static class14[] field794 = new class14[50];
   @ObfuscatedName("o")
   static int[] field795 = new int[1000];
   @ObfuscatedName("a")
   static int[] field796;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 2024395599
   )
   @Export("cameraZ")
   static int field797;
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      intValue = -1540388305
   )
   static int field798;
   @ObfuscatedName("h")
   static String[] field800 = new String[1000];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -302352101
   )
   static int field801 = 0;
   @ObfuscatedName("f")
   static int[] field802 = new int[5];
   @ObfuscatedName("q")
   static Calendar field803 = Calendar.getInstance();
   @ObfuscatedName("u")
   static final String[] field804 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 136798177
   )
   static int field805 = 0;
   @ObfuscatedName("m")
   static int[][] field808 = new int[5][5000];

   @ObfuscatedName("j")
   public static class42 method741(int var0) {
      class42 var1 = (class42)class42.field984.method3711((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class42.field989.method3214(12, var0);
         var1 = new class42();
         if(null != var2) {
            var1.method863(new class118(var2));
         }

         var1.method865();
         class42.field984.method3713(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("h")
   public static int method742(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("l")
   static void method747(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != class25.field636[var5]) {
            var2[var4] = class25.field636[var5];
            var3[var4] = class25.field645[var5];
            ++var4;
         }
      }

      class25.field636 = var2;
      class25.field645 = var3;
      class23.method591(class25.field632, 0, class25.field632.length - 1, class25.field636, class25.field645);
   }

   @ObfuscatedName("j")
   public static class129 method748(int var0) {
      class129[] var1 = new class129[]{class129.field2064, class129.field2062, class129.field2061};
      class129[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class129 var4 = var2[var3];
         if(var0 == var4.field2063) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("cw")
   static final void method749(int var0) {
      if(class149.method3102(var0)) {
         class41.method857(class172.field2757[var0], -1);
      }
   }
}
