import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public final class class16 extends class208 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1765354609
   )
   int field219;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -255007767
   )
   int field220;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1472809235
   )
   int field221;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1635695023
   )
   int field222;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1509786197
   )
   int field223;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1171826615
   )
   int field224;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2000345537
   )
   int field225;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1531484259
   )
   int field227;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1576255283
   )
   int field228 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 247148077
   )
   int field229;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1551351791
   )
   int field230 = -1;
   @ObfuscatedName("ia")
   static class30 field231;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -553318945
   )
   int field232;

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method195() {
      client.field322.method2737(255);
      class122 var0 = client.field322;
      int var1 = client.field336?2:1;
      var0.method2477(var1);
      client.field322.method2661(class15.field214);
      client.field322.method2661(class15.field215);
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-241448374"
   )
   static boolean method196(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class32.method690(var0, class1.field24);

         for(int var2 = 0; var2 < client.field550; ++var2) {
            class7 var3 = client.field344[var2];
            if(var1.equalsIgnoreCase(class32.method690(var3.field133, class1.field24))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class32.method690(var3.field135, class1.field24))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass0;I)V",
      garbageValue = "1477633102"
   )
   static void method197(class0 var0) {
      class17.method201(var0, 200000);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2063798969"
   )
   static void method198(int var0) {
      if(-1 != var0) {
         if(class188.method3731(var0)) {
            class173[] var1 = class217.field3171[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               class173 var3 = var1[var2];
               if(null != var3.field2846) {
                  class0 var4 = new class0();
                  var4.field8 = var3;
                  var4.field12 = var3.field2846;
                  class17.method201(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILclass134;Lclass168;I)V",
      garbageValue = "-911886817"
   )
   static void method199(int var0, class134 var1, class168 var2) {
      byte[] var3 = null;
      class199 var4 = class170.field2722;
      synchronized(class170.field2722) {
         for(class169 var5 = (class169)class170.field2722.method3812(); null != var5; var5 = (class169)class170.field2722.method3817()) {
            if(var5.field3125 == (long)var0 && var1 == var5.field2713 && var5.field2712 == 0) {
               var3 = var5.field2714;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3333(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2854(var0);
         var2.method3333(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIII[Lclass108;I)V",
      garbageValue = "-987668850"
   )
   static final void method200(byte[] var0, int var1, int var2, int var3, int var4, class108[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var1 + var7 > 0 && var1 + var7 < 103 && var8 + var2 > 0 && var2 + var8 < 103) {
                  var5[var6].field1911[var7 + var1][var2 + var8] &= -16777217;
               }
            }
         }
      }

      class119 var10 = new class119(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class43.method890(var10, var7, var8 + var1, var2 + var9, var3, var4, 0);
            }
         }
      }

   }
}
