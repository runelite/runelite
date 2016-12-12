import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class15 {
   @ObfuscatedName("i")
   static final class15 field158 = new class15();
   @ObfuscatedName("e")
   static final class15 field159 = new class15();
   @ObfuscatedName("f")
   static final class15 field160 = new class15();
   @ObfuscatedName("k")
   static final class15 field161 = new class15();
   @ObfuscatedName("ek")
   static SpritePixels[] field162;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = 495743981
   )
   @Export("baseX")
   static int baseX;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lclass112;",
      garbageValue = "-1784277954"
   )
   public static class112 method170() {
      try {
         return new class106();
      } catch (Throwable var1) {
         return null;
      }
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(LWidget;I)LWidget;",
      garbageValue = "1085374527"
   )
   static Widget method171(Widget var0) {
      Widget var2 = var0;
      int var3 = class3.method34(class143.method2647(var0));
      Widget var1;
      if(var3 == 0) {
         var1 = null;
      } else {
         int var4 = 0;

         while(true) {
            if(var4 >= var3) {
               var1 = var2;
               break;
            }

            var2 = class191.method3433(var2.parentId);
            if(null == var2) {
               var1 = null;
               break;
            }

            ++var4;
         }
      }

      Widget var5 = var1;
      if(var1 == null) {
         var5 = var0.parent;
      }

      return var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   public static void method172() {
      ObjectComposition.field2894.reset();
      ObjectComposition.field2895.reset();
      ObjectComposition.field2896.reset();
      ObjectComposition.field2897.reset();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "39"
   )
   static int method173(int var0, int var1, int var2) {
      return (class10.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class10.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)[B",
      garbageValue = "-58"
   )
   public static byte[] method174(CharSequence var0) {
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "-1643581879"
   )
   public static ModIcon[] method175(class182 var0, String var1, String var2) {
      int var3 = var0.method3225(var1);
      int var4 = var0.method3226(var3, var2);
      return class183.method3303(var0, var3, var4);
   }
}
