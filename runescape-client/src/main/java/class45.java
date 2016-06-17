import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class45 extends class204 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 277296749
   )
   public static int field1023;
   @ObfuscatedName("j")
   public boolean field1024 = false;
   @ObfuscatedName("g")
   public static class193 field1025 = new class193(64);
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = 1930894763
   )
   public static int field1026;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-1382585013"
   )
   public void method949(class119 var1) {
      while(true) {
         int var2 = var1.method2514();
         if(var2 == 0) {
            return;
         }

         this.method950(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "1894471228"
   )
   void method950(class119 var1, int var2) {
      if(var2 == 2) {
         this.field1024 = true;
      }

   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "0"
   )
   static boolean method953(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class39.method796(var0, client.field289);

         for(int var2 = 0; var2 < client.field513; ++var2) {
            class7 var3 = client.field559[var2];
            if(var1.equalsIgnoreCase(class39.method796(var3.field124, client.field289))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class39.method796(var3.field122, client.field289))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)[B",
      garbageValue = "-1880442724"
   )
   public static byte[] method954(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 > 0 && var4 < 128 || var4 >= 160 && var4 <= 255) {
            var2[var3] = (byte)var4;
         } else if(var4 == 8364) {
            var2[var3] = -128;
         } else if(var4 == 8218) {
            var2[var3] = -126;
         } else if(var4 == 402) {
            var2[var3] = -125;
         } else if(var4 == 8222) {
            var2[var3] = -124;
         } else if(var4 == 8230) {
            var2[var3] = -123;
         } else if(var4 == 8224) {
            var2[var3] = -122;
         } else if(var4 == 8225) {
            var2[var3] = -121;
         } else if(var4 == 710) {
            var2[var3] = -120;
         } else if(var4 == 8240) {
            var2[var3] = -119;
         } else if(var4 == 352) {
            var2[var3] = -118;
         } else if(var4 == 8249) {
            var2[var3] = -117;
         } else if(var4 == 338) {
            var2[var3] = -116;
         } else if(var4 == 381) {
            var2[var3] = -114;
         } else if(var4 == 8216) {
            var2[var3] = -111;
         } else if(var4 == 8217) {
            var2[var3] = -110;
         } else if(var4 == 8220) {
            var2[var3] = -109;
         } else if(var4 == 8221) {
            var2[var3] = -108;
         } else if(var4 == 8226) {
            var2[var3] = -107;
         } else if(var4 == 8211) {
            var2[var3] = -106;
         } else if(var4 == 8212) {
            var2[var3] = -105;
         } else if(var4 == 732) {
            var2[var3] = -104;
         } else if(var4 == 8482) {
            var2[var3] = -103;
         } else if(var4 == 353) {
            var2[var3] = -102;
         } else if(var4 == 8250) {
            var2[var3] = -101;
         } else if(var4 == 339) {
            var2[var3] = -100;
         } else if(var4 == 382) {
            var2[var3] = -98;
         } else if(var4 == 376) {
            var2[var3] = -97;
         } else {
            var2[var3] = 63;
         }
      }

      return var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "2074621370"
   )
   @Export("sendGameMessage")
   static void method955(int var0, String var1, String var2) {
      class22.method571(var0, var1, var2, (String)null);
   }
}
