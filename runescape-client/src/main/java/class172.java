import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class172 {
   @ObfuscatedName("u")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("j")
   public static final boolean[] field2332 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("c")
   public static int[] field2333 = new int[99];
   @ObfuscatedName("eq")
   static SpritePixels[] field2335;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 1076916927
   )
   static int field2337;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 179870289
   )
   protected static int field2340;

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2333[var1] = var0 / 4;
      }

   }

   class172() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "257691296"
   )
   static final void method3268(class68 var0) {
      var0.field1149 = false;
      if(null != var0.field1147) {
         var0.field1147.field1181 = 0;
      }

      for(class68 var1 = var0.vmethod2723(); var1 != null; var1 = var0.vmethod2724()) {
         method3268(var1);
      }

   }
}
