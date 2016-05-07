import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class14 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 276621469
   )
   int field198 = -1;
   @ObfuscatedName("ak")
   static class168 field199;
   @ObfuscatedName("j")
   class22 field200;
   @ObfuscatedName("p")
   int[] field201;
   @ObfuscatedName("x")
   String[] field202;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "188192429"
   )
   static final void method172() {
      if(null != class167.field2697) {
         class167.field2697.method2960();
         class167.field2697 = null;
      }

      class168.method3328();
      client.field339.method1895();

      for(int var0 = 0; var0 < 4; ++var0) {
         client.field340[var0].method2374();
      }

      System.gc();
      class9.method130(2);
      client.field370 = -1;
      client.field518 = false;

      for(class23 var1 = (class23)class23.field615.method3812(); null != var1; var1 = (class23)class23.field615.method3817()) {
         if(null != var1.field598) {
            class114.field1978.method1117(var1.field598);
            var1.field598 = null;
         }

         if(null != var1.field610) {
            class114.field1978.method1117(var1.field610);
            var1.field610 = null;
         }
      }

      class23.field615.method3806();
      class15.method188(10);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "188478091"
   )
   static void method173() {
      if(class31.field736) {
         class209.field3128 = null;
         class31.field717 = null;
         class28.field681 = null;
         class20.field569 = null;
         class121.field2016 = null;
         class31.field718 = null;
         class151.field2263 = null;
         class27.field678 = null;
         class30.field708 = null;
         class31.field745 = null;
         class77.field1403 = null;
         class158.field2604 = null;
         class31.field746 = null;
         class50.field1104 = null;
         class1.field26 = null;
         class11.field169 = null;
         class31.field741 = null;
         class31.field722 = null;
         class27.field670 = null;
         class178.field2932 = null;
         class27.field665 = null;
         class43.field1018 = null;
         class9.method130(2);
         class115.method2439(true);
         class31.field736 = false;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILclass134;Lclass168;I)V",
      garbageValue = "1490786534"
   )
   static void method174(int var0, class134 var1, class168 var2) {
      class169 var3 = new class169();
      var3.field2712 = 1;
      var3.field3125 = (long)var0;
      var3.field2713 = var1;
      var3.field2716 = var2;
      class199 var4 = class170.field2722;
      synchronized(class170.field2722) {
         class170.field2722.method3807(var3);
      }

      Object var9 = class170.field2723;
      synchronized(class170.field2723) {
         if(0 == class170.field2721) {
            class38.field878.method2862(new class170(), 5);
         }

         class170.field2721 = 600;
      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "2114216442"
   )
   static final void method175(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!client.field418) {
         if(client.field496 < 500) {
            client.field424[client.field496] = var0;
            client.field425[client.field496] = var1;
            client.field422[client.field496] = var2;
            client.field378[client.field496] = var3;
            client.field420[client.field496] = var4;
            client.field421[client.field496] = var5;
            ++client.field496;
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1234934138"
   )
   public static int method176(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ class119.field2010[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
