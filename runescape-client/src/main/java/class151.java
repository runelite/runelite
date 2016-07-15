import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class151 extends RuntimeException {
   @ObfuscatedName("e")
   static Applet field2270;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -347296393
   )
   static int field2271;
   @ObfuscatedName("db")
   @Export("xteaKeys")
   static int[][] field2272;
   @ObfuscatedName("r")
   Throwable field2273;
   @ObfuscatedName("h")
   String field2274;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass44;IIII)V",
      garbageValue = "-120184747"
   )
   static void method3216(class44 var0, int var1, int var2, int var3) {
      if(client.field535 < 50 && client.field536 != 0) {
         if(var0.field1024 != null && var1 < var0.field1024.length) {
            int var4 = var0.field1024[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               client.field370[client.field535] = var5;
               client.field539[client.field535] = var6;
               client.field449[client.field535] = 0;
               client.field494[client.field535] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               client.field291[client.field535] = (var8 << 16) + (var9 << 8) + var7;
               ++client.field535;
            }
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IS)Lclass45;",
      garbageValue = "339"
   )
   public static class45 method3217(int var0) {
      class45 var1 = (class45)class45.field1043.method3834((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class45.field1056.method3340(13, var0);
         var1 = new class45();
         var1.field1045 = var0;
         if(null != var2) {
            var1.method962(new class122(var2));
         }

         class45.field1043.method3836(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass27;B)V",
      garbageValue = "112"
   )
   @Export("selectWorld")
   static void method3219(class27 var0) {
      if(var0.method604() != client.field388) {
         client.field388 = var0.method604();
         boolean var1 = var0.method604();
         if(class30.field721 != var1) {
            class49.method1071();
            class30.field721 = var1;
         }
      }

      client.field330 = var0.field685;
      client.field468 = var0.field674;
      client.field292 = var0.field676;
      class62.field1280 = client.field399 == 0?'ꩊ':'鱀' + var0.field674;
      class40.field911 = client.field399 == 0?443:'썐' + var0.field674;
      class101.field1745 = class62.field1280;
   }
}
