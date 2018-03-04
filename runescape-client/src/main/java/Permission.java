import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("Permission")
public enum Permission implements Enumerated {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   field3340(0, -1, true, false, true),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   field3332(1, 0, true, true, true),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   field3337(2, 1, true, true, false),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   field3334(3, 2, false, false, true),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   field3335(4, 3, false, false, true),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   field3336(5, 10, false, false, true);

   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1484320701
   )
   final int field3331;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1211799217
   )
   public final int field3338;
   @ObfuscatedName("p")
   public final boolean field3339;
   @ObfuscatedName("x")
   public final boolean field3333;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3331 = var3;
      this.field3338 = var4;
      this.field3339 = var6;
      this.field3333 = var7;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "846888120"
   )
   public int rsOrdinal() {
      return this.field3331;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Ljb;",
      garbageValue = "481915819"
   )
   public static class281 method4651(int var0) {
      class281 var1 = (class281)class281.field3565.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class281.field3577.getConfigData(32, var0);
         var1 = new class281();
         if(var2 != null) {
            var1.method5080(new Buffer(var2));
         }

         class281.field3565.put(var1, (long)var0);
         return var1;
      }
   }
}
