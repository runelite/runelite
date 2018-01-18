import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("Permission")
public enum Permission implements Enumerated {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3275(0, -1, true, false, true),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3273(1, 0, true, true, true),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3278(2, 1, true, true, false),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3272(3, 2, false, false, true),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3276(4, 3, false, false, true),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   field3282(5, 10, false, false, true);

   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -738693793
   )
   final int field3277;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1280221939
   )
   public final int field3279;
   @ObfuscatedName("e")
   public final boolean field3280;
   @ObfuscatedName("f")
   public final boolean field3281;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3277 = var3;
      this.field3279 = var4;
      this.field3280 = var6;
      this.field3281 = var7;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2130441585"
   )
   public int rsOrdinal() {
      return this.field3277;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lix;",
      garbageValue = "696147550"
   )
   public static class254 method4285(int var0) {
      class254 var1 = (class254)class254.field3405.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class254.field3408.getConfigData(19, var0);
         var1 = new class254();
         if(var2 != null) {
            var1.method4511(new Buffer(var2));
         }

         class254.field3405.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "25"
   )
   static int method4283(int var0, int var1) {
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
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
