import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("World")
public class class25 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 147396481
   )
   @Export("index")
   int field638;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 396510349
   )
   static int field642 = 0;
   @ObfuscatedName("p")
   static int[] field643 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("m")
   static class18 field645;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1730745083
   )
   @Export("id")
   int field646;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1179087797
   )
   @Export("mask")
   int field647;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 904336797
   )
   @Export("playerCount")
   int field648;
   @ObfuscatedName("t")
   @Export("activity")
   String field649;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1103942747
   )
   static int field650 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 385753599
   )
   @Export("location")
   int field651;
   @ObfuscatedName("q")
   static int[] field652 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("aj")
   static String field653;
   @ObfuscatedName("i")
   @Export("address")
   String field655;
   @ObfuscatedName("ph")
   static class221 field656;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2133054018"
   )
   boolean method679() {
      return (1 & this.field647) != 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1313530960"
   )
   boolean method680() {
      return 0 != (2 & this.field647);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2141267155"
   )
   boolean method681() {
      return (4 & this.field647) != 0;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "0"
   )
   static final void method682(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = 6 + var2;
      int var5 = class135.field2084.method4113(var0, 250);
      int var6 = class135.field2084.method4114(var0, 250) * 13;
      class79.method1929(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      class79.method1941(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      class135.field2084.method4119(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class31.method756(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      class153.method3250(var3, var4, var5, var6);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1712486158"
   )
   boolean method684() {
      return (33554432 & this.field647) != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Lclass43;",
      garbageValue = "4"
   )
   public static class43 method693(int var0) {
      class43 var1 = (class43)class43.field1014.method3840((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class178.field2918.method3403(13, var0);
         var1 = new class43();
         var1.field1030 = var0;
         if(null != var2) {
            var1.method993(new class119(var2));
         }

         class43.field1014.method3842(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1582373360"
   )
   boolean method700() {
      return 0 != (8 & this.field647);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "16"
   )
   boolean method706() {
      return 0 != (536870912 & this.field647);
   }
}
