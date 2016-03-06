package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("aw")
public final class class29 extends class84 {
   @ObfuscatedName("dh")
   static int[] field678;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2039651091
   )
   int field681;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1787362789
   )
   int field682;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2023956891
   )
   int field683;
   @ObfuscatedName("o")
   class42 field684;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1516326763
   )
   int field685;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1232014265
   )
   int field686 = 0;
   @ObfuscatedName("k")
   boolean field687 = false;
   @ObfuscatedName("ah")
   static class78[] field688;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1963963841
   )
   int field689 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 390542829
   )
   int field690;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1083530475
   )
   int field691;
   @ObfuscatedName("ck")
   static class223 field692;

   @ObfuscatedName("a")
   protected final class104 vmethod1870() {
      class43 var1 = class26.method635(this.field681);
      class104 var2;
      if(!this.field687) {
         var2 = var1.method899(this.field689);
      } else {
         var2 = var1.method899(-1);
      }

      return null == var2?null:var2;
   }

   @ObfuscatedName("j")
   final void method658(int var1) {
      if(!this.field687) {
         this.field686 += var1;

         while(this.field686 > this.field684.field988[this.field689]) {
            this.field686 -= this.field684.field988[this.field689];
            ++this.field689;
            if(this.field689 >= this.field684.field986.length) {
               this.field687 = true;
               break;
            }
         }

      }
   }

   class29(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field681 = var1;
      this.field691 = var2;
      this.field685 = var3;
      this.field682 = var4;
      this.field683 = var5;
      this.field690 = var7 + var6;
      int var8 = class26.method635(this.field681).field1012;
      if(-1 != var8) {
         this.field687 = false;
         this.field684 = class36.method741(var8);
      } else {
         this.field687 = true;
      }

   }

   @ObfuscatedName("a")
   static char method661(char var0) {
      return 181 != var0 && 402 != var0?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("a")
   public static int method662(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(1 == var2?7 - var0 - (var3 - 1):(2 == var2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("j")
   public static byte method663(char var0) {
      byte var1;
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(8364 == var0) {
            var1 = -128;
         } else if(8218 == var0) {
            var1 = -126;
         } else if(var0 == 402) {
            var1 = -125;
         } else if(var0 == 8222) {
            var1 = -124;
         } else if(var0 == 8230) {
            var1 = -123;
         } else if(var0 == 8224) {
            var1 = -122;
         } else if(var0 == 8225) {
            var1 = -121;
         } else if(710 == var0) {
            var1 = -120;
         } else if(8240 == var0) {
            var1 = -119;
         } else if(var0 == 352) {
            var1 = -118;
         } else if(var0 == 8249) {
            var1 = -117;
         } else if(338 == var0) {
            var1 = -116;
         } else if(var0 == 381) {
            var1 = -114;
         } else if(8216 == var0) {
            var1 = -111;
         } else if(var0 == 8217) {
            var1 = -110;
         } else if(8220 == var0) {
            var1 = -109;
         } else if(var0 == 8221) {
            var1 = -108;
         } else if(8226 == var0) {
            var1 = -107;
         } else if(8211 == var0) {
            var1 = -106;
         } else if(8212 == var0) {
            var1 = -105;
         } else if(732 == var0) {
            var1 = -104;
         } else if(var0 == 8482) {
            var1 = -103;
         } else if(353 == var0) {
            var1 = -102;
         } else if(var0 == 8250) {
            var1 = -101;
         } else if(var0 == 339) {
            var1 = -100;
         } else if(var0 == 382) {
            var1 = -98;
         } else if(376 == var0) {
            var1 = -97;
         } else {
            var1 = 63;
         }
      } else {
         var1 = (byte)var0;
      }

      return var1;
   }
}
