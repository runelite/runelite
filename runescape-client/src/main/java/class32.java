import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class32 {
   @ObfuscatedName("z")
   static class119[] field736 = new class119[2048];
   @ObfuscatedName("g")
   static byte[] field738 = new byte[2048];
   @ObfuscatedName("h")
   static byte[] field739 = new byte[2048];
   @ObfuscatedName("p")
   static int[] field740 = new int[2048];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1904686727
   )
   static int field741 = 0;
   @ObfuscatedName("f")
   static int[] field742 = new int[2048];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1777752573
   )
   static int field743 = 0;
   @ObfuscatedName("d")
   static int[] field744 = new int[2048];
   @ObfuscatedName("ps")
   @ObfuscatedGetter(
      intValue = 107748233
   )
   static int field745;
   @ObfuscatedName("dc")
   @Export("xteaKeys")
   static int[][] field746;
   @ObfuscatedName("y")
   static int[] field747 = new int[2048];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 988303337
   )
   static int field748 = 0;
   @ObfuscatedName("o")
   static int[] field749 = new int[2048];
   @ObfuscatedName("b")
   static class119 field750 = new class119(new byte[5000]);
   @ObfuscatedName("ad")
   static int[] field752;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -666946623
   )
   @Export("plane")
   static int field754;
   @ObfuscatedName("l")
   static int[] field756 = new int[2048];

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Lclass41;",
      garbageValue = "-20"
   )
   public static class41 method685(int var0) {
      class41 var1 = (class41)class41.field977.method3716((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class218.field3169.method3221(1, var0);
         var1 = new class41();
         if(null != var2) {
            var1.method836(new class119(var2), var0);
         }

         var1.method846();
         class41.field977.method3724(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;S)Lclass80;",
      garbageValue = "11154"
   )
   public static class80 method691(class167 var0, String var1, String var2) {
      int var3 = var0.method3236(var1);
      int var4 = var0.method3237(var3, var2);
      return class113.method2404(var0, var3, var4);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-1900932413"
   )
   static final void method700(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)client.field542.method3797(); null != var10; var10 = (class16)client.field542.method3779()) {
         if(var0 == var10.field229 && var10.field226 == var1 && var10.field227 == var2 && var10.field230 == var3) {
            var9 = var10;
            break;
         }
      }

      if(null == var9) {
         var9 = new class16();
         var9.field229 = var0;
         var9.field230 = var3;
         var9.field226 = var1;
         var9.field227 = var2;
         class183.method3545(var9);
         client.field542.method3771(var9);
      }

      var9.field231 = var4;
      var9.field225 = var5;
      var9.field232 = var6;
      var9.field234 = var7;
      var9.field235 = var8;
   }
}
