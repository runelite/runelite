import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("World")
public class class25 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 550327905
   )
   static int field629 = 0;
   @ObfuscatedName("b")
   @Export("activity")
   String field633;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -18862175
   )
   static int field634 = 0;
   @ObfuscatedName("s")
   static int[] field635 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("z")
   @Export("worldList")
   static class25[] field636;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2108923343
   )
   @Export("id")
   int field637;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2089398517
   )
   @Export("index")
   int field638;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1828245919
   )
   @Export("playerCount")
   int field639;
   @ObfuscatedName("o")
   @Export("address")
   String field640;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1971901061
   )
   @Export("location")
   int field642;
   @ObfuscatedName("d")
   static int[] field643 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 196210463
   )
   @Export("mask")
   int field645;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "19847864"
   )
   boolean method579() {
      return (1 & this.field645) != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "59"
   )
   boolean method580() {
      return (2 & this.field645) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-50"
   )
   boolean method581() {
      return (4 & this.field645) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1204104545"
   )
   boolean method582() {
      return (8 & this.field645) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2142182539"
   )
   boolean method583() {
      return (536870912 & this.field645) != 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-981867147"
   )
   static void method590() {
      class227 var0 = null;

      try {
         var0 = class17.method170("", class214.field3158.field2316, true);
         class119 var1 = class116.field1988.method93();
         var0.method4073(var1.field2001, 0, var1.field2000);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4074();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "185407629"
   )
   boolean method601() {
      return (33554432 & this.field645) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "922889538"
   )
   public static int method613(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var2 * var0;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "-465491387"
   )
   static final int method615(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class91.field1603[var2 * 1024 / var3] >> 1;
      return (var1 * var4 >> 16) + ((65536 - var4) * var0 >> 16);
   }
}
