import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public enum class27 implements RSEnum {
   @ObfuscatedName("p")
   field411(1, (byte)0),
   @ObfuscatedName("m")
   field408(0, (byte)1),
   @ObfuscatedName("e")
   field409(2, (byte)2),
   @ObfuscatedName("t")
   field410(3, (byte)3);

   @ObfuscatedName("z")
   final byte field407;
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
   public int rsOrdinal() {
      return this.field407;
   }

   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   class27(int var3, byte var4) {
      this.field417 = var3;
      this.field407 = var4;
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
