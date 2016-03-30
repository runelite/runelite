import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class10 extends class107 {
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 1128732553
   )
   static int field177;
   @ObfuscatedName("v")
   static byte[][] field180;
   @ObfuscatedName("h")
   static class119 field181;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -1743914679
   )
   static int field184;

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-43"
   )
   static final void method123(int var0, int var1) {
      if(2 == client.field313) {
         class1.method9(client.field319 + (client.field316 - class41.field990 << 7), (client.field317 - class2.field37 << 7) + client.field547, client.field502 * 2);
         if(client.field400 > -1 && client.field305 % 20 < 10) {
            class165.field2682[0].method1699(var0 + client.field400 - 12, client.field401 + var1 - 28);
         }

      }
   }

   @ObfuscatedName("w")
   public boolean vmethod2389(int var1, int var2) {
      return super.field1892 == var1 && var2 == super.field1887;
   }

   @ObfuscatedName("x")
   static class80 method125(class167 var0, int var1, int var2) {
      return !class121.method2747(var0, var1, var2)?null:class136.method2901();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "778465404"
   )
   static void method126() {
      for(class23 var0 = (class23)class23.field618.method3836(); var0 != null; var0 = (class23)class23.field618.method3841()) {
         if(null != var0.field617) {
            class72.field1353.method1153(var0.field617);
            var0.field617 = null;
         }

         if(var0.field620 != null) {
            class72.field1353.method1153(var0.field620);
            var0.field620 = null;
         }
      }

      class23.field618.method3833();
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "1283110304"
   )
   static void method127(class173 var0, int var1, int var2) {
      if(0 == var0.field2857) {
         var0.field2780 = var0.field2776;
      } else if(1 == var0.field2857) {
         var0.field2780 = var0.field2776 + (var1 - var0.field2767) / 2;
      } else if(2 == var0.field2857) {
         var0.field2780 = var1 - var0.field2767 - var0.field2776;
      } else if(var0.field2857 == 3) {
         var0.field2780 = var0.field2776 * var1 >> 14;
      } else if(4 == var0.field2857) {
         var0.field2780 = (var0.field2776 * var1 >> 14) + (var1 - var0.field2767) / 2;
      } else {
         var0.field2780 = var1 - var0.field2767 - (var1 * var0.field2776 >> 14);
      }

      if(var0.field2840 == 0) {
         var0.field2892 = var0.field2873;
      } else if(1 == var0.field2840) {
         var0.field2892 = (var2 - var0.field2783) / 2 + var0.field2873;
      } else if(2 == var0.field2840) {
         var0.field2892 = var2 - var0.field2783 - var0.field2873;
      } else if(var0.field2840 == 3) {
         var0.field2892 = var2 * var0.field2873 >> 14;
      } else if(4 == var0.field2840) {
         var0.field2892 = (var2 - var0.field2783) / 2 + (var2 * var0.field2873 >> 14);
      } else {
         var0.field2892 = var2 - var0.field2783 - (var0.field2873 * var2 >> 14);
      }

      if(client.field521 && var0.field2814 == 0) {
         if(var0.field2780 < 0) {
            var0.field2780 = 0;
         } else if(var0.field2767 + var0.field2780 > var1) {
            var0.field2780 = var1 - var0.field2767;
         }

         if(var0.field2892 < 0) {
            var0.field2892 = 0;
         } else if(var0.field2783 + var0.field2892 > var2) {
            var0.field2892 = var2 - var0.field2783;
         }
      }

   }

   @ObfuscatedName("cr")
   static final void method128(class173 var0, int var1, int var2) {
      if(null == client.field353 && !client.field433) {
         if(null != var0 && class119.method2704(var0) != null) {
            client.field353 = var0;
            client.field468 = class119.method2704(var0);
            client.field469 = var1;
            client.field470 = var2;
            class167.field2706 = 0;
            client.field423 = false;
            if(client.field435 > 0) {
               int var3 = client.field435 - 1;
               class76.field1386 = new class30();
               class76.field1386.field713 = client.field436[var3];
               class76.field1386.field706 = client.field437[var3];
               class76.field1386.field710 = client.field448[var3];
               class76.field1386.field708 = client.field439[var3];
               class76.field1386.field709 = client.field440[var3];
            }

         }
      }
   }

   @ObfuscatedName("w")
   static boolean method129() {
      try {
         if(class47.field1080 == null) {
            class47.field1080 = new class18(class123.field2036, new URL(class8.field163));
         } else {
            byte[] var0 = class47.field1080.method191();
            if(null != var0) {
               class119 var1 = new class119(var0);
               class25.field642 = var1.method2508();
               class189.field3062 = new class25[class25.field642];

               class25 var3;
               for(int var2 = 0; var2 < class25.field642; var3.field652 = var2++) {
                  var3 = class189.field3062[var2] = new class25();
                  var3.field650 = var1.method2508();
                  var3.field647 = var1.method2511();
                  var3.field649 = var1.method2683();
                  var3.field639 = var1.method2683();
                  var3.field648 = var1.method2506();
                  var3.field638 = var1.method2509();
               }

               class15.method176(class189.field3062, 0, class189.field3062.length - 1, class25.field645, class25.field644);
               class47.field1080 = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class47.field1080 = null;
      }

      return false;
   }

   @ObfuscatedName("x")
   public static class44 method131(int var0) {
      class44 var1 = (class44)class44.field1033.method3771((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class44.field1048.method3335(3, var0);
         var1 = new class44();
         if(var2 != null) {
            var1.method953(new class119(var2));
         }

         class44.field1033.method3773(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   public static int method132(String var0) {
      return var0.length() + 2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass42;IIII)V",
      garbageValue = "1181941340"
   )
   static void method133(class42 var0, int var1, int var2, int var3) {
      if(client.field536 < 50 && 0 != client.field535) {
         if(var0.field998 != null && var1 < var0.field998.length) {
            int var4 = var0.field998[var1];
            if(0 != var4) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               client.field350[client.field536] = var5;
               client.field538[client.field536] = var6;
               client.field543[client.field536] = 0;
               client.field552[client.field536] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               client.field540[client.field536] = var7 + (var9 << 8) + (var8 << 16);
               ++client.field536;
            }
         }
      }
   }

   @ObfuscatedName("dl")
   static String method134(class173 var0) {
      return class3.method46(class169.method3395(var0)) == 0?null:(null != var0.field2846 && var0.field2846.trim().length() != 0?var0.field2846:null);
   }
}
