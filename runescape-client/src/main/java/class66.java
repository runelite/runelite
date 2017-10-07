import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class66 extends class196 {
   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   static class147 field832;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = 1161932649
   )
   static int field830;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -961179935
   )
   int field833;
   @ObfuscatedName("k")
   String field829;
   @ObfuscatedName("e")
   short field828;

   class66(String var1, int var2) {
      this.field833 = (int)(class147.currentTimeMs() / 1000L);
      this.field829 = var1;
      this.field828 = (short)var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;I)V",
      garbageValue = "1557803585"
   )
   public static void method1138(IndexDataBase var0) {
      class251.field3388 = var0;
   }
}
