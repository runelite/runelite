import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1401315215
   )
   int field660;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -935074681
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -518481051
   )
   int field662;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 14416959
   )
   int field663;
   @ObfuscatedName("z")
   public static short[][] field665;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-91"
   )
   public static void method617() {
      if(class103.field1661.toLowerCase().indexOf("microsoft") != -1) {
         class105.field1708[186] = 57;
         class105.field1708[187] = 27;
         class105.field1708[188] = 71;
         class105.field1708[189] = 26;
         class105.field1708[190] = 72;
         class105.field1708[191] = 73;
         class105.field1708[192] = 58;
         class105.field1708[219] = 42;
         class105.field1708[220] = 74;
         class105.field1708[221] = 43;
         class105.field1708[222] = 59;
         class105.field1708[223] = 28;
      } else {
         class105.field1708[44] = 71;
         class105.field1708[45] = 26;
         class105.field1708[46] = 72;
         class105.field1708[47] = 73;
         class105.field1708[59] = 57;
         class105.field1708[61] = 27;
         class105.field1708[91] = 42;
         class105.field1708[92] = 74;
         class105.field1708[93] = 43;
         class105.field1708[192] = 28;
         class105.field1708[222] = 58;
         class105.field1708[520] = 59;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-512692434"
   )
   void method618(int var1, int var2, int var3, int var4) {
      this.field662 = var1;
      this.healthRatio = var2;
      this.field660 = var3;
      this.field663 = var4;
   }

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field662 = var1;
      this.healthRatio = var2;
      this.field660 = var3;
      this.field663 = var4;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-2035125907"
   )
   static final void method622(Actor var0, int var1) {
      class16.method179(var0.x, var0.y, var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "-742697597"
   )
   public static void method623(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || null != var0[var8] && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method623(var0, var1, var2, var5 - 1);
         method623(var0, var1, var5 + 1, var3);
      }

   }
}
