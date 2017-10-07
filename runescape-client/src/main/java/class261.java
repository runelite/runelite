import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
public class class261 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final class261 field3626;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final class261 field3628;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final class261 field3627;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final class261 field3634;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final class261 field3624;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final class261 field3625;
   @ObfuscatedName("r")
   final String field3629;
   @ObfuscatedName("g")
   String field3630;

   static {
      field3628 = new class261("PLAIN11", "p11_full");
      field3624 = new class261("PLAIN12", "p12_full");
      field3625 = new class261("BOLD12", "b12_full");
      field3626 = new class261("VERDANA11", "verdana_11pt_regular");
      field3627 = new class261("VERDANA13", "verdana_13pt_regular");
      field3634 = new class261("VERDANA15", "verdana_15pt_regular");
   }

   class261(String var1, String var2) {
      this.field3629 = var1;
      this.field3630 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Leb;IB)V",
      garbageValue = "60"
   )
   public static final void method4817(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.field1961; ++var2) {
         if(var0.field1935[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.field1953[var3];
            int var7 = Model.field1953[var4];
            int var8 = Model.field1953[var5];
            Overlay.method4778(Model.field1954[var3], Model.field1954[var4], Model.field1954[var5], var6, var7, var8, var1);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Ljk;",
      garbageValue = "-151979743"
   )
   public static class261[] method4816() {
      return new class261[]{field3627, field3626, field3624, field3625, field3634, field3628};
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;III)Ljz;",
      garbageValue = "422382079"
   )
   static IndexedSprite method4814(IndexDataBase var0, int var1, int var2) {
      return !class249.method4517(var0, var1, var2)?null:class60.method1071();
   }
}
