import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class90 {
   @ObfuscatedName("c")
   @Export("rsaKeyExponent")
   static final BigInteger rsaKeyExponent;
   @ObfuscatedName("o")
   @Export("rsaKeyModulus")
   static final BigInteger rsaKeyModulus;

   static {
      rsaKeyExponent = new BigInteger("10001", 16);
      rsaKeyModulus = new BigInteger("c7d9d5828a3b77fdc2bc041255d6b51547a4542349f13fdffd15dcb4b5494609d70b9cf9d7d3f620548d9da1221c90e647ac05b84c877ef2e7c7264db426f1ec128d12c706c0e19206d3465483f55d98021ddade4c819909586437969f61407a5846a2fc88d960056a6891cbb710af797b69defe0e9a006b6297027d0d92478b", 16);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "26492"
   )
   public static void method1659() {
      KitDefinition.identKits.reset();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Lcw;",
      garbageValue = "1298415414"
   )
   static World method1658() {
      return World.field1283 < World.worldCount?class64.worldList[++World.field1283 - 1]:null;
   }
}
