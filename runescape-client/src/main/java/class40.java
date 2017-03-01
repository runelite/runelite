import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class40 implements class158 {
   @ObfuscatedName("n")
   static final class40 field812 = new class40(1);
   @ObfuscatedName("g")
   static final class40 field813 = new class40(2);
   @ObfuscatedName("v")
   static final class40 field814 = new class40(3);
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 1828640293
   )
   static int field815;
   @ObfuscatedName("x")
   static final class40 field816 = new class40(0);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 519226335
   )
   final int field817;
   @ObfuscatedName("by")
   static class184 field818;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class40(int var1) {
      this.field817 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-112"
   )
   public int vmethod4107() {
      return this.field817;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "41"
   )
   static boolean method827(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass18;B)V",
      garbageValue = "85"
   )
   static void method828(class18 var0) {
      class203.method3853(var0, 200000);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lclass216;",
      garbageValue = "30482817"
   )
   public static class216 method829(int var0) {
      class216[] var1 = new class216[]{class216.field3183, class216.field3185, class216.field3184};
      class216[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class216 var4 = var2[var3];
         if(var4.field3186 == var0) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1804842486"
   )
   static final int method830(int var0, int var1) {
      int var2 = class2.method34(var0 + '넵', var1 + 91923, 4) - 128 + (class2.method34(10294 + var0, var1 + '鎽', 2) - 128 >> 1) + (class2.method34(var0, var1, 1) - 128 >> 2);
      var2 = (int)(0.3D * (double)var2) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-27"
   )
   public static void method831() {
      CombatInfo2.field2836.reset();
      CombatInfo2.field2837.reset();
   }
}
