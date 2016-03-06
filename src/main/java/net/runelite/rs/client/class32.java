package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ax")
public class class32 {
   @ObfuscatedName("f")
   static class118[] field745 = new class118[2048];
   @ObfuscatedName("a")
   static byte[] field746 = new byte[2048];
   @ObfuscatedName("i")
   static byte[] field747 = new byte[2048];
   @ObfuscatedName("u")
   static int[] field748 = new int[2048];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2074712793
   )
   static int field749 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 244604221
   )
   static int field750 = 0;
   @ObfuscatedName("n")
   static int[] field751 = new int[2048];
   @ObfuscatedName("k")
   static int[] field752 = new int[2048];
   @ObfuscatedName("b")
   static int[] field753 = new int[2048];
   @ObfuscatedName("r")
   static int[] field754 = new int[2048];
   @ObfuscatedName("o")
   static int[] field755 = new int[2048];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -843403601
   )
   static int field756 = 0;
   @ObfuscatedName("bq")
   static class167 field757;
   @ObfuscatedName("g")
   static class118 field758 = new class118(new byte[5000]);
   @ObfuscatedName("pc")
   static class220 field760;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = 860154547
   )
   static int field761;

   @ObfuscatedName("j")
   public static class41 method721(int var0) {
      class41 var1 = (class41)class41.field979.method3711((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class41.field970.method3214(1, var0);
         var1 = new class41();
         if(null != var2) {
            var1.method841(new class118(var2));
         }

         var1.method840();
         class41.field979.method3713(var1, (long)var0);
         return var1;
      }
   }
}
