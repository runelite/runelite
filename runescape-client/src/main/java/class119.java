import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public abstract class class119 {
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = 552888647
   )
   static int field1855;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1088583455
   )
   public int field1856;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2055945037
   )
   public int field1857;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -584570065
   )
   public int field1858;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = 578203007
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2041675689
   )
   public int field1861;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "1832344439"
   )
   public abstract boolean vmethod2386(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1228676047"
   )
   public static int method2389(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }
}
