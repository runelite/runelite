import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class187 extends class208 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 468534095
   )
   int field3007;
   @ObfuscatedName("u")
   class181 field3008;
   @ObfuscatedName("x")
   class62 field3009;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -459579911
   )
   int field3010;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -995155319
   )
   int field3011;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2048127969
   )
   int field3012;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1416347731
   )
   int field3013;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -568726849
   )
   int field3014;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1985261343
   )
   int field3015;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1775195419
   )
   int field3016;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 359531079
   )
   int field3017;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 95912807
   )
   int field3018;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1914029633
   )
   int field3019;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -532757725
   )
   int field3020;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -175939555
   )
   int field3021;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1916939191
   )
   int field3022;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1410402689
   )
   int field3023;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 657379843
   )
   int field3024;
   @ObfuscatedName("w")
   class64 field3025;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 943108775
   )
   int field3026;
   @ObfuscatedName("b")
   class185 field3027;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1678482859"
   )
   void method3777() {
      this.field3008 = null;
      this.field3009 = null;
      this.field3027 = null;
      this.field3025 = null;
   }

   @ObfuscatedName("f")
   public static String method3778(long var0) {
      class111.field1964.setTime(new Date(var0));
      int var2 = class111.field1964.get(7);
      int var3 = class111.field1964.get(5);
      int var4 = class111.field1964.get(2);
      int var5 = class111.field1964.get(1);
      int var6 = class111.field1964.get(11);
      int var7 = class111.field1964.get(12);
      int var8 = class111.field1964.get(13);
      return class111.field1960[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class111.field1967[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }
}
