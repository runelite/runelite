package net.runelite.rs.client;
import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("co")
public final class class88 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1594173459
   )
   int field1548;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -927489615
   )
   int field1549;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1067708009
   )
   int field1550;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1420833989
   )
   int field1551;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -742775071
   )
   int field1553;
   @ObfuscatedName("m")
   boolean field1554 = true;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1734906607
   )
   int field1555;

   @ObfuscatedName("am")
   static final void method2052() {
      for(int var0 = 0; var0 < client.field561; ++var0) {
         int var1 = client.field326[var0];
         class34 var2 = client.field324[var1];
         if(var2 != null) {
            class162.method3179(var2);
         }
      }

   }

   @ObfuscatedName("m")
   static int method2053(class25 var0, class25 var1, int var2, boolean var3) {
      if(1 == var2) {
         int var4 = var0.field639;
         int var5 = var1.field639;
         if(!var3) {
            if(-1 == var4) {
               var4 = 2001;
            }

            if(-1 == var5) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return 2 == var2?var0.field635 - var1.field635:(var2 == 3?(var0.field641.equals("-")?(var1.field641.equals("-")?0:(var3?-1:1)):(var1.field641.equals("-")?(var3?1:-1):var0.field641.compareTo(var1.field641))):(4 == var2?(var0.method631()?(var1.method631()?0:1):(var1.method631()?-1:0)):(5 == var2?(var0.method598()?(var1.method598()?0:1):(var1.method598()?-1:0)):(6 == var2?(var0.method602()?(var1.method602()?0:1):(var1.method602()?-1:0)):(7 == var2?(var0.method612()?(var1.method612()?0:1):(var1.method612()?-1:0)):var0.field637 - var1.field637)))));
      }
   }

   @ObfuscatedName("ax")
   public static class77 method2054(int var0, int var1, Component var2) {
      try {
         class81 var3 = new class81();
         var3.vmethod1841(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         class75 var4 = new class75();
         var4.vmethod1841(var0, var1, var2);
         return var4;
      }
   }

   class88(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1550 = var1;
      this.field1548 = var2;
      this.field1549 = var3;
      this.field1555 = var4;
      this.field1551 = var5;
      this.field1553 = var6;
      this.field1554 = var7;
   }
}
