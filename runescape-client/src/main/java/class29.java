import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public final class class29 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;
   @ObfuscatedName("a")
   @Export("cacheLocations")
   static String[] cacheLocations;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1785188141
   )
   int field404;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -125212773
   )
   int field400;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 196432341
   )
   int field399;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1416205069
   )
   int field402;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   final class41 this$0;

   @ObfuscatedSignature(
      signature = "(Lao;)V"
   )
   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Les;IIIII)V",
      garbageValue = "1452375046"
   )
   public static final void method235(Model var0, int var1, int var2, int var3, int var4) {
      class7.boundingBoxes.addFirst(new BoundingBox3D(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "45549487"
   )
   public static int method234(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & '?');
         } else {
            var0[var4++] = (byte)(224 | var6 >> '\f');
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & '?');
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)[Liv;",
      garbageValue = "-599641975"
   )
   static class250[] method237() {
      return new class250[]{class250.field3367, class250.field3366, class250.field3365};
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-656203955"
   )
   public static boolean method236(int var0) {
      return (var0 >> 28 & 1) != 0;
   }
}
