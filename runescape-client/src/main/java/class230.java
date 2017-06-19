import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public enum class230 implements RSEnum {
   @ObfuscatedName("p")
   field3187(0, -1, true, false, true),
   @ObfuscatedName("m")
   field3178(1, 0, true, true, true),
   @ObfuscatedName("e")
   field3180(2, 1, true, true, false),
   @ObfuscatedName("t")
   field3179(3, 2, false, false, true),
   @ObfuscatedName("w")
   field3181(4, 3, false, false, true),
   @ObfuscatedName("z")
   field3182(5, 10, false, false, true);

   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1332333519
   )
   final int field3183;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -503342411
   )
   public final int field3184;
   @ObfuscatedName("f")
   public final boolean field3185;
   @ObfuscatedName("c")
   public final boolean field3186;
   @ObfuscatedName("ad")
   static SpritePixels[] field3188;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int rsOrdinal() {
      return this.field3183;
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1665377772"
   )
   static final int method3976() {
      return Client.menuOptionCount <= 0?-1:(Client.field989 && class50.field660[81] && Client.field1053 != -1?Client.field1053:Client.menuOptionCount - 1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Lclass251;",
      garbageValue = "-23"
   )
   public static class251 method3978(int var0) {
      class251 var1 = (class251)class251.field3394.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class251.field3395.getConfigData(11, var0);
         var1 = new class251();
         if(var2 != null) {
            var1.method4301(new Buffer(var2));
         }

         var1.method4308();
         class251.field3394.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   private class230(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3183 = var3;
      this.field3184 = var4;
      this.field3185 = var6;
      this.field3186 = var7;
   }
}
