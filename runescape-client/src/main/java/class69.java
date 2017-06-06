import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class69 extends Node {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -441774841
   )
   int field848;
   @ObfuscatedName("i")
   Object[] field849;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1817210459
   )
   int field850;
   @ObfuscatedName("n")
   String field851;
   @ObfuscatedName("e")
   Widget field852;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1757515947
   )
   int field853;
   @ObfuscatedName("h")
   Widget field854;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -195526277
   )
   int field855;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1667432245
   )
   int field856;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2060581561
   )
   int field857;
   @ObfuscatedName("c")
   boolean field858;
   @ObfuscatedName("o")
   class219 field859;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = 768574655
   )
   static int field860;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-1390143490"
   )
   public static int method1086(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "-2102694712"
   )
   public void method1087(Object[] var1) {
      this.field849 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass219;B)V",
      garbageValue = "-4"
   )
   public void method1090(class219 var1) {
      this.field859 = var1;
   }

   public class69() {
      this.field859 = class219.field2793;
   }
}
