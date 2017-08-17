import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class163 {
   @ObfuscatedName("f")
   public static int[][] field2307;
   @ObfuscatedName("p")
   public static int[][] field2308;
   @ObfuscatedName("l")
   public static int[] field2310;
   @ObfuscatedName("w")
   public static int[] field2311;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1207365247
   )
   public static int field2309;

   static {
      field2307 = new int[128][128];
      field2308 = new int[128][128];
      field2310 = new int[4096];
      field2311 = new int[4096];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1796090658"
   )
   public static void method3084() {
      try {
         if(class204.field2507 == 1) {
            int var0 = class204.field2501.method3704();
            if(var0 > 0 && class204.field2501.method3696()) {
               var0 -= class204.field2505;
               if(var0 < 0) {
                  var0 = 0;
               }

               class204.field2501.method3689(var0);
               return;
            }

            class204.field2501.method3758();
            class204.field2501.method3693();
            if(class204.field2502 != null) {
               class204.field2507 = 2;
            } else {
               class204.field2507 = 0;
            }

            class204.field2506 = null;
            class204.field2509 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class204.field2501.method3758();
         class204.field2507 = 0;
         class204.field2506 = null;
         class204.field2509 = null;
         class204.field2502 = null;
      }

   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2024037695"
   )
   static final void method3086(int var0) {
      if(Ignore.loadWidget(var0)) {
         Widget[] var1 = class176.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2771 = 0;
               var3.field2747 = 0;
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-491584994"
   )
   public static byte[] method3085() {
      byte[] var0 = new byte[24];

      try {
         class156.field2249.seek(0L);
         class156.field2249.read(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }
}
