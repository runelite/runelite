import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class132 {
   @ObfuscatedName("d")
   public static boolean field1982;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1460890291
   )
   public static int field1985;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1739335901
   )
   public static int field1984;
   @ObfuscatedName("p")
   public static boolean field1983;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -363550811
   )
   public static int field1989;
   @ObfuscatedName("b")
   public static int[] field1990;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1581698959
   )
   static int field1986;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1665964513
   )
   static int field1988;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -173433473
   )
   static int field1987;

   static {
      field1982 = false;
      field1985 = 0;
      field1984 = 0;
      field1983 = false;
      field1989 = 0;
      field1990 = new int[1000];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)[Lhf;",
      garbageValue = "29"
   )
   public static class228[] method2675() {
      return new class228[]{class228.field3160, class228.field3162, class228.field3158, class228.field3159, class228.field3155, class228.field3154, class228.field3157, class228.field3156};
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfg;II)Ljava/lang/String;",
      garbageValue = "-1169569317"
   )
   static String method2666(Buffer var0, int var1) {
      try {
         int var2 = var0.getUSmart();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class265.field3664.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class12.getString(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(Lbz;I)V",
      garbageValue = "1799767975"
   )
   static final void method2677(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = class8.region.method2848(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = class8.region.method2784(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = class8.region.method2907(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = class8.region.method2841(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = class8.region.method2801(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1198 = var2;
      var0.field1200 = var3;
      var0.field1199 = var4;
   }
}
