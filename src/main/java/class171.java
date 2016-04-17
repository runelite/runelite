import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class171 {
   @ObfuscatedName("e")
   static class196 field2713 = new class196(4096);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -549968065
   )
   static int field2715 = 0;
   @ObfuscatedName("n")
   static class119 field2716;
   @ObfuscatedName("a")
   public static class143 field2717;
   @ObfuscatedName("k")
   static class196 field2718 = new class196(32);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2046647963
   )
   public static int field2719 = 0;
   @ObfuscatedName("p")
   static class203 field2720 = new class203();
   @ObfuscatedName("q")
   static class196 field2721 = new class196(4096);
   @ObfuscatedName("s")
   static class168[] field2722 = new class168[256];
   @ObfuscatedName("kz")
   static class19 field2723;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1218525539
   )
   public static int field2724 = 0;
   @ObfuscatedName("z")
   static boolean field2725;
   @ObfuscatedName("t")
   static class119 field2726 = new class119(8);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 594009687
   )
   public static int field2727 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1569091135
   )
   static int field2728 = 0;
   @ObfuscatedName("j")
   static CRC32 field2729 = new CRC32();
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -5325030497991080703L
   )
   static long field2730;
   @ObfuscatedName("f")
   static byte field2731 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -522385859
   )
   public static int field2733 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -849747517
   )
   public static int field2734 = 0;
   @ObfuscatedName("cp")
   static class143 field2735;
   @ObfuscatedName("c")
   static class196 field2738 = new class196(4096);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 318917637
   )
   public static int field2739 = 0;

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "-324247359"
   )
   static final void method3469(class37 var0) {
      var0.field820 = false;
      class42 var1;
      if(-1 != var0.field845) {
         var1 = class96.method2279(var0.field845);
         if(var1 != null && null != var1.field989) {
            ++var0.field847;
            if(var0.field846 < var1.field989.length && var0.field847 > var1.field995[var0.field846]) {
               var0.field847 = 1;
               ++var0.field846;
               class2.method46(var1, var0.field846, var0.field844, var0.field819);
            }

            if(var0.field846 >= var1.field989.length) {
               var0.field847 = 0;
               var0.field846 = 0;
               class2.method46(var1, var0.field846, var0.field844, var0.field819);
            }
         } else {
            var0.field845 = -1;
         }
      }

      if(-1 != var0.field865 && client.field306 >= var0.field850) {
         if(var0.field854 < 0) {
            var0.field854 = 0;
         }

         int var3 = class25.method693(var0.field865).field1021;
         if(var3 != -1) {
            class42 var2 = class96.method2279(var3);
            if(var2 != null && null != var2.field989) {
               ++var0.field855;
               if(var0.field854 < var2.field989.length && var0.field855 > var2.field995[var0.field854]) {
                  var0.field855 = 1;
                  ++var0.field854;
                  class2.method46(var2, var0.field854, var0.field844, var0.field819);
               }

               if(var0.field854 >= var2.field989.length && (var0.field854 < 0 || var0.field854 >= var2.field989.length)) {
                  var0.field865 = -1;
               }
            } else {
               var0.field865 = -1;
            }
         } else {
            var0.field865 = -1;
         }
      }

      if(-1 != var0.field848 && var0.field851 <= 1) {
         var1 = class96.method2279(var0.field848);
         if(1 == var1.field1003 && var0.field875 > 0 && var0.field862 <= client.field306 && var0.field866 < client.field306) {
            var0.field851 = 1;
            return;
         }
      }

      if(-1 != var0.field848 && 0 == var0.field851) {
         var1 = class96.method2279(var0.field848);
         if(null != var1 && var1.field989 != null) {
            ++var0.field872;
            if(var0.field849 < var1.field989.length && var0.field872 > var1.field995[var0.field849]) {
               var0.field872 = 1;
               ++var0.field849;
               class2.method46(var1, var0.field849, var0.field844, var0.field819);
            }

            if(var0.field849 >= var1.field989.length) {
               var0.field849 -= var1.field998;
               ++var0.field852;
               if(var0.field852 >= var1.field1011) {
                  var0.field848 = -1;
               } else if(var0.field849 >= 0 && var0.field849 < var1.field989.length) {
                  class2.method46(var1, var0.field849, var0.field844, var0.field819);
               } else {
                  var0.field848 = -1;
               }
            }

            var0.field820 = var1.field1012;
         } else {
            var0.field848 = -1;
         }
      }

      if(var0.field851 > 0) {
         --var0.field851;
      }

   }
}
