import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class206 extends Node {
   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   static RSSocket field2565;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   class203 field2545;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1665405835
   )
   int field2552;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   class208 field2543;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   class106 field2550;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   class116 field2561;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1588931529
   )
   int field2546;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -181414931
   )
   int field2563;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1567910417
   )
   int field2559;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -57624177
   )
   int field2560;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 907793287
   )
   int field2542;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1706772695
   )
   int field2549;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 613777117
   )
   int field2556;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -157196009
   )
   int field2548;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1685431997
   )
   int field2544;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1371616245
   )
   int field2547;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1962818671
   )
   int field2553;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1966067279
   )
   int field2558;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -929741597
   )
   int field2551;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1509815095
   )
   int field2554;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1586878209
   )
   int field2555;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 579143227
   )
   int field2557;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2142142372"
   )
   void method3877() {
      this.field2543 = null;
      this.field2550 = null;
      this.field2545 = null;
      this.field2561 = null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1761335236"
   )
   static final void method3876() {
      if(!class133.field2004) {
         int var0 = Region.pitchSin;
         int var1 = Region.pitchCos;
         int var2 = Region.yawSin;
         int var3 = Region.yawCos;
         byte var4 = 50;
         short var5 = 3500;
         int var6 = (class133.field2002 - Graphics3D.centerX) * var4 / Graphics3D.field2030;
         int var7 = (class133.field2001 - Graphics3D.centerY) * var4 / Graphics3D.field2030;
         int var8 = (class133.field2002 - Graphics3D.centerX) * var5 / Graphics3D.field2030;
         int var9 = (class133.field2001 - Graphics3D.centerY) * var5 / Graphics3D.field2030;
         int var10 = Graphics3D.method2646(var7, var4, var1, var0);
         int var11 = Graphics3D.method2639(var7, var4, var1, var0);
         var7 = var10;
         var10 = Graphics3D.method2646(var9, var5, var1, var0);
         int var12 = Graphics3D.method2639(var9, var5, var1, var0);
         var9 = var10;
         var10 = Graphics3D.method2641(var6, var11, var3, var2);
         var11 = Graphics3D.method2637(var6, var11, var3, var2);
         var6 = var10;
         var10 = Graphics3D.method2641(var8, var12, var3, var2);
         var12 = Graphics3D.method2637(var8, var12, var3, var2);
         class133.field2005 = (var10 + var6) / 2;
         ItemContainer.field793 = (var9 + var7) / 2;
         class133.field2006 = (var11 + var12) / 2;
         class133.field2007 = (var10 - var6) / 2;
         class170.field2345 = (var9 - var7) / 2;
         class39.field553 = (var12 - var11) / 2;
         ItemContainer.field792 = Math.abs(class133.field2007);
         Varbit.field3386 = Math.abs(class170.field2345);
         class133.field2008 = Math.abs(class39.field553);
      }
   }
}
