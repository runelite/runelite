import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class18 {
   @ObfuscatedName("ck")
   static class146 field246;
   @ObfuscatedName("by")
   static class168 field247;
   @ObfuscatedName("m")
   DataInputStream field248;
   @ObfuscatedName("z")
   byte[] field249 = new byte[4];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1181205707
   )
   int field250;
   @ObfuscatedName("e")
   byte[] field251;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1076303317
   )
   int field252;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 4421610406763691115L
   )
   long field253;
   @ObfuscatedName("h")
   class146 field254;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 530501111
   )
   int field255;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 1501345421
   )
   static int field256;
   @ObfuscatedName("cj")
   static class143 field257;

   class18(class136 var1, URL var2) {
      this.field254 = var1.method2853(var2);
      this.field255 = 0;
      this.field253 = class77.method1674() + 30000L;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1707732713"
   )
   byte[] method195() throws IOException {
      if(class77.method1674() > this.field253) {
         throw new IOException();
      } else {
         if(0 == this.field255) {
            if(2 == this.field254.field2195) {
               throw new IOException();
            }

            if(1 == this.field254.field2195) {
               this.field248 = (DataInputStream)this.field254.field2194;
               this.field255 = 1;
            }
         }

         int var1;
         if(1 == this.field255) {
            var1 = this.field248.available();
            if(var1 > 0) {
               if(var1 + this.field250 > 4) {
                  var1 = 4 - this.field250;
               }

               this.field250 += this.field248.read(this.field249, this.field250, var1);
               if(this.field250 == 4) {
                  int var2 = (new class119(this.field249)).method2505();
                  this.field251 = new byte[var2];
                  this.field255 = 2;
               }
            }
         }

         if(this.field255 == 2) {
            var1 = this.field248.available();
            if(var1 > 0) {
               if(this.field252 + var1 > this.field251.length) {
                  var1 = this.field251.length - this.field252;
               }

               this.field252 += this.field248.read(this.field251, this.field252, var1);
               if(this.field251.length == this.field252) {
                  return this.field251;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method196() {
      for(class3 var0 = (class3)client.field434.method3745(); null != var0; var0 = (class3)client.field434.method3746()) {
         int var1 = var0.field65;
         if(class107.method2374(var1)) {
            boolean var2 = true;
            class173[] var3 = class173.field2735[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].field2768;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.field3122;
               class173 var5 = class141.method2959(var4);
               if(null != var5) {
                  class2.method28(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2083803252"
   )
   public static void method197(int var0, int var1) {
      class47 var2 = class38.method751(var0);
      int var3 = var2.field1051;
      int var4 = var2.field1049;
      int var5 = var2.field1050;
      int var6 = class176.field2902[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class176.field2900[var3] = class176.field2900[var3] & ~var6 | var1 << var4 & var6;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "262453405"
   )
   static void method198(int var0) {
      class15 var1 = (class15)class15.field210.method3742((long)var0);
      if(null != var1) {
         var1.method3883();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-929939733"
   )
   public static boolean method199() {
      class210 var0 = (class210)class211.field3140.method3826();
      return null != var0;
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1407916553"
   )
   static boolean method200(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class75.method1629(var0, client.field278);

         for(int var2 = 0; var2 < client.field544; ++var2) {
            class7 var3 = client.field545[var2];
            if(var1.equalsIgnoreCase(class75.method1629(var3.field131, client.field278))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class75.method1629(var3.field133, client.field278))) {
               return true;
            }
         }

         return false;
      }
   }
}
