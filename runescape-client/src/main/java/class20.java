import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class20 implements Runnable {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -681932459
   )
   public static int field205;
   @ObfuscatedName("l")
   Object field206 = new Object();
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1953600507
   )
   int field207 = 0;
   @ObfuscatedName("b")
   boolean field208 = true;
   @ObfuscatedName("k")
   int[] field209 = new int[500];
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 2123951951
   )
   public static int field211;
   @ObfuscatedName("t")
   int[] field212 = new int[500];
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = 511090967
   )
   public static int field216;

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZI)V",
      garbageValue = "-595681338"
   )
   static void method210(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(null != var6 && var6.parentId == var1) {
            class15.method190(var6, var2, var3, var4);
            class94.method1974(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               CombatInfo1.method646(var0, var6, var4);
            }
         }
      }

   }

   public void run() {
      for(; this.field208; class115.method2301(50L)) {
         Object var1 = this.field206;
         synchronized(this.field206) {
            if(this.field207 < 500) {
               this.field212[this.field207] = class115.field1802;
               this.field209[this.field207] = class115.field1801;
               ++this.field207;
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-781833923"
   )
   static void method214(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field677[var5] != var0) {
            var2[var4] = World.field677[var5];
            var3[var4] = World.field678[var5];
            ++var4;
         }
      }

      World.field677 = var2;
      World.field678 = var3;
      class0.method11(World.worldList, 0, World.worldList.length - 1, World.field677, World.field678);
   }
}
