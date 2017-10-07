import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
public class class277 {
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("socket")
   static Task socket;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final class277 field3752;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   public static final class277 field3751;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   static final class277 field3748;
   @ObfuscatedName("s")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 205433069
   )
   public final int field3749;

   static {
      field3752 = new class277(0);
      field3751 = new class277(1);
      field3748 = new class277(2);
   }

   class277(int var1) {
      this.field3749 = var1;
   }
}
