import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public abstract class class77 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -474665953
   )
   int field1389;
   @ObfuscatedName("bl")
   static class167 field1391;
   @ObfuscatedName("e")
   public Image field1392;
   @ObfuscatedName("n")
   static class80 field1393;
   @ObfuscatedName("f")
   public int[] field1394;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 628640771
   )
   public int field1395;
   @ObfuscatedName("dt")
   @Export("region")
   static class85 field1396;

   @ObfuscatedName("a")
   abstract void vmethod1893(int var1, int var2, Component var3);

   @ObfuscatedName("r")
   public abstract void vmethod1900(Graphics var1, int var2, int var3);

   @ObfuscatedName("f")
   public abstract void vmethod1895(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("ax")
   public final void method1723() {
      class79.method1822(this.field1394, this.field1395, this.field1389);
   }

   @ObfuscatedName("e")
   static int method1724(int var0) {
      class35 var1 = (class35)class11.field164.method3849((long)var0);
      return var1 == null?-1:(class11.field165.field3095 == var1.field3100?-1:((class35)var1.field3100).field789);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-75"
   )
   static void method1725(byte[] var0) {
      class118 var1 = new class118(var0);
      var1.field1979 = var0.length - 2;
      class76.field1385 = var1.method2514();
      class76.field1386 = new int[class76.field1385];
      class76.field1382 = new int[class76.field1385];
      class102.field1764 = new int[class76.field1385];
      class76.field1383 = new int[class76.field1385];
      class30.field708 = new byte[class76.field1385][];
      var1.field1979 = var0.length - 7 - class76.field1385 * 8;
      class76.field1379 = var1.method2514();
      class76.field1381 = var1.method2514();
      int var2 = (var1.method2579() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class76.field1385; ++var3) {
         class76.field1386[var3] = var1.method2514();
      }

      for(var3 = 0; var3 < class76.field1385; ++var3) {
         class76.field1382[var3] = var1.method2514();
      }

      for(var3 = 0; var3 < class76.field1385; ++var3) {
         class102.field1764[var3] = var1.method2514();
      }

      for(var3 = 0; var3 < class76.field1385; ++var3) {
         class76.field1383[var3] = var1.method2514();
      }

      var1.field1979 = var0.length - 7 - class76.field1385 * 8 - 3 * (var2 - 1);
      class115.field1968 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class115.field1968[var3] = var1.method2516();
         if(0 == class115.field1968[var3]) {
            class115.field1968[var3] = 1;
         }
      }

      var1.field1979 = 0;

      for(var3 = 0; var3 < class76.field1385; ++var3) {
         int var4 = class102.field1764[var3];
         int var5 = class76.field1383[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class30.field708[var3] = var7;
         int var8 = var1.method2579();
         int var9;
         if(0 == var8) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2707();
            }
         } else if(1 == var8) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var4 * var10] = var1.method2707();
               }
            }
         }
      }

   }
}
