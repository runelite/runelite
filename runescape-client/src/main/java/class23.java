import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public final class class23 extends class208 {
   @ObfuscatedName("r")
   class40 field599;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -504239739
   )
   int field600;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -553580083
   )
   int field601;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1578575723
   )
   int field602;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -394910271
   )
   int field603;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1866635831
   )
   int field604;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1233385227
   )
   int field605;
   @ObfuscatedName("b")
   static class199 field606 = new class199();
   @ObfuscatedName("u")
   class64 field607;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1274286549
   )
   int field608;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -864806919
   )
   int field609;
   @ObfuscatedName("k")
   class64 field610;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1443072833
   )
   int field611;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1889881213
   )
   int field612;
   @ObfuscatedName("w")
   int[] field613;
   @ObfuscatedName("bs")
   static class80 field614;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1625739969"
   )
   void method573() {
      int var1 = this.field602;
      class40 var2 = this.field599.method805();
      if(var2 != null) {
         this.field602 = var2.field944;
         this.field603 = var2.field906 * 128;
         this.field612 = var2.field931;
         this.field609 = var2.field947;
         this.field613 = var2.field948;
      } else {
         this.field602 = -1;
         this.field603 = 0;
         this.field612 = 0;
         this.field609 = 0;
         this.field613 = null;
      }

      if(var1 != this.field602 && this.field607 != null) {
         class52.field1134.method1132(this.field607);
         this.field607 = null;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-176634463"
   )
   static final boolean method589(int var0, int var1) {
      class40 var2 = class172.method3399(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method803(var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1433708"
   )
   static int method590(int var0) {
      class35 var1 = (class35)class11.field169.method3808((long)var0);
      return null == var1?-1:(class11.field164.field3099 == var1.field3103?-1:((class35)var1.field3103).field769);
   }
}
