import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class171 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -623901951
   )
   public static int field2711 = 0;
   @ObfuscatedName("h")
   public static class119 field2712;
   @ObfuscatedName("b")
   public static class196 field2713 = new class196(4096);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -232044881
   )
   public static int field2714 = 0;
   @ObfuscatedName("d")
   public static class196 field2715 = new class196(32);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 447573933
   )
   public static int field2716 = 0;
   @ObfuscatedName("m")
   public static class203 field2717 = new class203();
   @ObfuscatedName("g")
   static class196 field2718 = new class196(4096);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1284071767
   )
   public static int field2719 = 0;
   @ObfuscatedName("r")
   public static class196 field2720 = new class196(4096);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 298029757
   )
   public static int field2721 = 0;
   @ObfuscatedName("f")
   public static class143 field2722;
   @ObfuscatedName("p")
   public static class119 field2723 = new class119(8);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 82519379
   )
   public static int field2724 = 0;
   @ObfuscatedName("w")
   public static CRC32 field2726 = new CRC32();
   @ObfuscatedName("v")
   public static class119 field2727;
   @ObfuscatedName("y")
   public static class168[] field2728 = new class168[256];
   @ObfuscatedName("c")
   public static byte field2729 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 17145047
   )
   public static int field2730 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2032690901
   )
   public static int field2731 = 0;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Lclass22;",
      garbageValue = "578756183"
   )
   static class22 method3423(int var0) {
      class22 var1 = (class22)class22.field600.method3797((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class17.field255.method3286(var0, 0);
         if(null == var2) {
            return null;
         } else {
            var1 = new class22();
            class119 var3 = new class119(var2);
            var3.field1998 = var3.field2000.length - 12;
            int var4 = var3.method2696();
            var1.field591 = var3.method2556();
            var1.field596 = var3.method2556();
            var1.field597 = var3.method2556();
            var1.field598 = var3.method2556();
            var3.field1998 = 0;
            var3.method2561();
            var1.field592 = new int[var4];
            var1.field593 = new int[var4];
            var1.field601 = new String[var4];

            int var6;
            for(int var5 = 0; var3.field1998 < var3.field2000.length - 12; var1.field592[var5++] = var6) {
               var6 = var3.method2556();
               if(var6 == 3) {
                  var1.field601[var5] = var3.method2668();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field593[var5] = var3.method2696();
               } else {
                  var1.field593[var5] = var3.method2554();
               }
            }

            class22.field600.method3788(var1, (long)var0);
            return var1;
         }
      }
   }
}
