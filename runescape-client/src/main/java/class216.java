import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class216 extends Node {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1735803979
   )
   int field2666;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   class218 field2679;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   class106 field2669;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   class213 field2668;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1750790419
   )
   int field2665;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 617351827
   )
   int field2670;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2425003
   )
   int field2684;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1956158693
   )
   int field2672;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -342055613
   )
   int field2671;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1935672103
   )
   int field2674;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -313641679
   )
   int field2683;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1967811393
   )
   int field2676;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1729918911
   )
   int field2677;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 11690563
   )
   int field2680;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1083778911
   )
   int field2667;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1765270467
   )
   int field2675;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -779101233
   )
   int field2681;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1088291109
   )
   int field2682;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   class116 field2673;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 717225061
   )
   int field2678;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1930196335
   )
   int field2685;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1411608588"
   )
   void method4027() {
      this.field2679 = null;
      this.field2669 = null;
      this.field2668 = null;
      this.field2673 = null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CS)Z",
      garbageValue = "-31088"
   )
   static final boolean method4029(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else if(class230.method4256(var0)) {
         return true;
      } else {
         char[] var1 = class278.field3748;

         int var2;
         char var3;
         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         var1 = class278.field3747;

         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BB)Ljava/lang/String;",
      garbageValue = "18"
   )
   public static String method4026(byte[] var0) {
      return AttackOption.method1749(var0, 0, var0.length);
   }
}
