import java.util.Calendar;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class36 {
   @ObfuscatedName("n")
   static class14[] field797 = new class14[50];
   @ObfuscatedName("f")
   static int[] field798;
   @ObfuscatedName("s")
   static String[] field799;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1773111771
   )
   static int field800;
   @ObfuscatedName("e")
   static int[][] field801 = new int[5][5000];
   @ObfuscatedName("g")
   static int[] field802 = new int[1000];
   @ObfuscatedName("m")
   static String[] field803 = new String[1000];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 181234013
   )
   static int field804 = 0;
   @ObfuscatedName("y")
   static int[] field805 = new int[5];
   @ObfuscatedName("h")
   static class172 field806;
   @ObfuscatedName("i")
   static Calendar field807 = Calendar.getInstance();
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1312028153
   )
   static int field808 = 0;
   @ObfuscatedName("v")
   static final String[] field809 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

   @ObfuscatedName("y")
   public static boolean method742(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("ch")
   static void method745(class172 var0) {
      if(client.field322 == var0.field2873 * -1) {
         client.field499[var0.field2872] = true;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-675626182"
   )
   static void method750() {
      client.field304 = 1L;
      client.field307 = -1;
      class93.field1600.field189 = 0;
      class46.field1057 = true;
      client.field308 = true;
      client.field563 = -1L;
      class0.method2();
      client.field301.field1979 = 0;
      client.field472.field1979 = 0;
      client.field488 = -1;
      client.field342 = 1;
      client.field343 = -1;
      client.field344 = -1;
      client.field340 = 0;
      client.field310 = 0;
      client.field345 = 0;
      client.field311 = 0;
      client.field435 = 0;
      client.field470 = false;
      class139.field2139 = 0;
      class11.field169.clear();
      class11.field164.method3844();
      class11.field165.method3883();
      class11.field166 = 0;
      client.field446 = 0;
      client.field448 = false;
      client.field536 = 0;
      client.field356 = (int)(Math.random() * 100.0D) - 50;
      client.field379 = (int)(Math.random() * 110.0D) - 55;
      client.field360 = (int)(Math.random() * 80.0D) - 40;
      client.field546 = (int)(Math.random() * 120.0D) - 60;
      client.field365 = (int)(Math.random() * 30.0D) - 20;
      client.field495 = (int)(Math.random() * 20.0D) - 10 & 2047;
      client.field530 = 0;
      client.field523 = 1;
      client.field528 = 0;
      client.field529 = 0;
      client.field319 = class20.field589;
      client.field332 = class20.field589;
      client.field331 = 0;
      class130.method2851();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         client.field415[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         client.field358[var0] = null;
      }

      client.field521 = -1;
      client.field385.method3854();
      client.field429.method3854();

      int var1;
      for(var0 = 0; var0 < 4; ++var0) {
         for(var1 = 0; var1 < 104; ++var1) {
            for(int var2 = 0; var2 < 104; ++var2) {
               client.field419[var0][var1][var2] = null;
            }
         }
      }

      client.field427 = new class198();
      client.field369 = 0;
      client.field562 = 0;
      client.field509 = 0;

      for(var0 = 0; var0 < class52.field1157; ++var0) {
         class52 var3 = class5.method101(var0);
         if(null != var3) {
            class175.field2891[var0] = 0;
            class175.field2890[var0] = 0;
         }
      }

      class112.field1958.method220();
      client.field461 = -1;
      if(-1 != client.field453) {
         class95.method2213(client.field453);
      }

      for(class3 var4 = (class3)client.field454.method3836(); null != var4; var4 = (class3)client.field454.method3827()) {
         class112.method2446(var4, true);
      }

      client.field453 = -1;
      client.field454 = new class195(8);
      client.field431 = null;
      client.field470 = false;
      client.field435 = 0;
      client.field378.method3496((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         client.field432[var0] = null;
         client.field520[var0] = false;
      }

      class15.field225 = new class195(32);
      client.field426 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         client.field499[var0] = true;
      }

      client.field301.method2753(78);
      class121 var5 = client.field301;
      var1 = client.field508?2:1;
      var5.method2497(var1);
      client.field301.method2498(class6.field107);
      client.field301.method2498(class31.field749);
      client.field438 = null;
      class9.field151 = 0;
      class42.field1003 = null;

      for(var0 = 0; var0 < 8; ++var0) {
         client.field572[var0] = new class219();
      }

      class165.field2653 = null;
   }
}
