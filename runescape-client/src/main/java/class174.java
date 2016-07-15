import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class174 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -735245995
   )
   public static int field2756 = 0;
   @ObfuscatedName("m")
   public static class171[] field2757 = new class171[256];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -621146512077535375L
   )
   public static long field2758;
   @ObfuscatedName("h")
   public static class199 field2759 = new class199(4096);
   @ObfuscatedName("e")
   public static class146 field2760;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 677483925
   )
   public static int field2761 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1540236179
   )
   public static int field2762 = 0;
   @ObfuscatedName("w")
   public static class122 field2763 = new class122(8);
   @ObfuscatedName("u")
   public static class206 field2764 = new class206();
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1687648627
   )
   public static int field2765 = 0;
   @ObfuscatedName("i")
   public static class199 field2766 = new class199(4096);
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -80230797
   )
   public static int field2767 = 0;
   @ObfuscatedName("a")
   public static class199 field2768 = new class199(32);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -673136587
   )
   public static int field2769 = 0;
   @ObfuscatedName("z")
   public static CRC32 field2771 = new CRC32();
   @ObfuscatedName("o")
   public static class199 field2772 = new class199(4096);
   @ObfuscatedName("v")
   public static byte field2773 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 305400739
   )
   public static int field2774 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 863796693
   )
   public static int field2775 = 0;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-35"
   )
   public static int method3475(int var0) {
      class50 var2 = (class50)class50.field1110.method3834((long)var0);
      class50 var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var3 = class50.field1115.method3340(14, var0);
         var2 = new class50();
         if(var3 != null) {
            var2.method1080(new class122(var3));
         }

         class50.field1110.method3836(var2, (long)var0);
         var1 = var2;
      }

      int var7 = var1.field1112;
      int var4 = var1.field1113;
      int var5 = var1.field1114;
      int var6 = class179.field2945[var5 - var4];
      return class179.field2944[var7] >> var4 & var6;
   }
}
