import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class27 implements class178 {
   @ObfuscatedName("z")
   final byte field407;
   @ObfuscatedName("m")
   static final class27 field408;
   @ObfuscatedName("e")
   static final class27 field409;
   @ObfuscatedName("t")
   static final class27 field410;
   @ObfuscatedName("p")
   static final class27 field411;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 286250369
   )
   static int field414;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = 522438051
   )
   static int field415;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1934559669
   )
   final int field417;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int vmethod4906() {
      return this.field407;
   }

   static {
      field411 = new class27(1, (byte)0);
      field408 = new class27(0, (byte)1);
      field409 = new class27(2, (byte)2);
      field410 = new class27(3, (byte)3);
   }

   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   class27(int var1, byte var2) {
      this.field417 = var1;
      this.field407 = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-74"
   )
   static int method227(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "387"
   )
   static final int method228(int var0, int var1) {
      int var2 = class13.method76(var0 - 1, var1 - 1) + class13.method76(var0 + 1, var1 - 1) + class13.method76(var0 - 1, var1 + 1) + class13.method76(var0 + 1, var1 + 1);
      int var3 = class13.method76(var0 - 1, var1) + class13.method76(var0 + 1, var1) + class13.method76(var0, var1 - 1) + class13.method76(var0, var1 + 1);
      int var4 = class13.method76(var0, var1);
      return var4 / 4 + var3 / 8 + var2 / 16;
   }
}
