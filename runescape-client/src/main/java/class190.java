import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class190 extends class211 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -418825959
   )
   int field3062;
   @ObfuscatedName("g")
   class184 field3063;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 101574115
   )
   int field3064;
   @ObfuscatedName("e")
   class188 field3065;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2024089207
   )
   int field3066;
   @ObfuscatedName("r")
   class65 field3067;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 425754991
   )
   int field3068;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 422921807
   )
   int field3069;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 438707401
   )
   int field3070;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -581010665
   )
   int field3071;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1119121639
   )
   int field3072;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 884178935
   )
   int field3073;
   @ObfuscatedName("i")
   class67 field3074;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -250434127
   )
   int field3075;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1102744647
   )
   int field3077;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2133104429
   )
   int field3078;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1757646105
   )
   int field3079;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 569815329
   )
   int field3080;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 774190687
   )
   int field3081;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 790248875
   )
   int field3082;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -829638657
   )
   int field3083;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-66"
   )
   void method3895() {
      this.field3063 = null;
      this.field3067 = null;
      this.field3065 = null;
      this.field3074 = null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "357857320"
   )
   static Class method3898(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }
}
