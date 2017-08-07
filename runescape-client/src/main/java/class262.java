import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
public class class262 {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final class262 field3615;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final class262 field3623;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final class262 field3621;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final class262 field3616;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final class262 field3613;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final class262 field3614;
   @ObfuscatedName("a")
   static String[] field3617;
   @ObfuscatedName("v")
   final String field3612;
   @ObfuscatedName("z")
   String field3619;

   static {
      field3623 = new class262("PLAIN11", "p11_full");
      field3613 = new class262("PLAIN12", "p12_full");
      field3614 = new class262("BOLD12", "b12_full");
      field3615 = new class262("VERDANA11", "verdana_11pt_regular");
      field3621 = new class262("VERDANA13", "verdana_13pt_regular");
      field3616 = new class262("VERDANA15", "verdana_15pt_regular");
   }

   class262(String var1, String var2) {
      this.field3612 = var1;
      this.field3619 = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1162718103"
   )
   static void method4747() {
      class287.field3779 = null;
      class277.offsetsY = null;
      class287.field3778 = null;
      class277.field3719 = null;
      class287.field3777 = null;
      class287.spritePixels = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[Ljn;",
      garbageValue = "2000137003"
   )
   public static class262[] method4751() {
      return new class262[]{field3615, field3614, field3623, field3621, field3613, field3616};
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfy;ZI)V",
      garbageValue = "1385202237"
   )
   public static void method4746(RSSocket var0, boolean var1) {
      if(class239.field3237 != null) {
         try {
            class239.field3237.close();
         } catch (Exception var6) {
            ;
         }

         class239.field3237 = null;
      }

      class239.field3237 = var0;
      class269.sendConInfo(var1);
      class239.field3247.offset = 0;
      class89.currentRequest = null;
      class266.field3650 = null;
      class239.field3248 = 0;

      while(true) {
         FileRequest var2 = (FileRequest)class239.field3236.method3549();
         if(var2 == null) {
            while(true) {
               var2 = (FileRequest)class239.field3240.method3549();
               if(var2 == null) {
                  if(class239.field3243 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.putByte(4);
                        var7.putByte(class239.field3243);
                        var7.putShort(0);
                        class239.field3237.queueForWrite(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class239.field3237.close();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class239.field3253;
                        class239.field3237 = null;
                     }
                  }

                  class239.field3251 = 0;
                  class239.field3239 = class170.currentTimeMs();
                  return;
               }

               class239.field3242.setHead(var2);
               class239.field3245.put(var2, var2.hash);
               ++class239.field3235;
               --class239.field3246;
            }
         }

         class239.field3238.put(var2, var2.hash);
         ++class239.field3249;
         --class239.field3241;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)[Lcx;",
      garbageValue = "-1980549982"
   )
   static class92[] method4753() {
      return new class92[]{class92.field1407, class92.field1408, class92.field1410, class92.field1417};
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1196320709"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
