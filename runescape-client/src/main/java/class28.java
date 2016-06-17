import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("Item")
public final class class28 extends class85 {
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -715262325
   )
   @Export("cameraX")
   static int field670;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 677624143
   )
   @Export("quantity")
   int field671;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1539423151
   )
   @Export("id")
   int field672;
   @ObfuscatedName("i")
   static int[] field673;
   @ObfuscatedName("r")
   public static int[] field674;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "853773613"
   )
   protected final class105 vmethod1913() {
      return class35.method741(this.field672).method1024(this.field671);
   }
}
