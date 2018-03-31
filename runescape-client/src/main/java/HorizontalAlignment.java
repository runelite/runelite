import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements Enumerated {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   field3691(2, 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   field3690(1, 1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   field3694(0, 2);

   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1217113899
   )
   @Export("value")
   public final int value;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -150359805
   )
   final int field3692;

   HorizontalAlignment(int var3, int var4) {
      this.value = var3;
      this.field3692 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1780726447"
   )
   public int rsOrdinal() {
      return this.field3692;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Liv;",
      garbageValue = "4"
   )
   public static BuildType method5117(int var0) {
      BuildType[] var1 = new BuildType[]{BuildType.RC, BuildType.LIVE, BuildType.BUILD_LIVE, BuildType.WIP};
      BuildType[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         BuildType var4 = var2[var3];
         if(var0 == var4.field3344) {
            return var4;
         }
      }

      return null;
   }
}
