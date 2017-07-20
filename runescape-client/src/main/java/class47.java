import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class47 {
   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   static class262 field602;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   static class47 field598;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -655402443
   )
   public int field606;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   public Coordinates field601;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   public Coordinates field603;

   @ObfuscatedSignature(
      signature = "(ILhs;Lhs;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field606 = var1;
      this.field601 = var2;
      this.field603 = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-749324736"
   )
   public static int method672(String var0) {
      return var0.length() + 2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Leo;IS)V",
      garbageValue = "-14639"
   )
   public static final void method671(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.field1886; ++var2) {
         if(var0.field1892[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.field1931[var3];
            int var7 = Model.field1931[var4];
            int var8 = Model.field1931[var5];
            class204.method3645(Model.field1920[var3], Model.field1920[var4], Model.field1920[var5], var6, var7, var8, var1);
         }
      }

   }
}
