import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public final class class23 extends class207 {
   @ObfuscatedName("a")
   static class198 field606 = new class198();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -507365053
   )
   int field607;
   @ObfuscatedName("z")
   class64 field608;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -682991821
   )
   int field609;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1103851549
   )
   int field610;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1670201109
   )
   int field611;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 722257113
   )
   int field612;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1538023175
   )
   int field613;
   @ObfuscatedName("l")
   class64 field614;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1894331107
   )
   int field615;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1229011361
   )
   int field616;
   @ObfuscatedName("i")
   int[] field617;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1867716419
   )
   int field618;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2065484237
   )
   int field619;
   @ObfuscatedName("r")
   class40 field620;

   @ObfuscatedName("f")
   void method582() {
      int var1 = this.field613;
      class40 var2 = this.field620.method848();
      if(null != var2) {
         this.field613 = var2.field967;
         this.field612 = var2.field968 * 128;
         this.field615 = var2.field969;
         this.field616 = var2.field970;
         this.field617 = var2.field928;
      } else {
         this.field613 = -1;
         this.field612 = 0;
         this.field615 = 0;
         this.field616 = 0;
         this.field617 = null;
      }

      if(this.field613 != var1 && null != this.field614) {
         class40.field973.method1153(this.field614);
         this.field614 = null;
      }

   }

   @ObfuscatedName("r")
   public static void method583(int var0) {
      if(class182.field2947 != 0) {
         class134.field2077 = var0;
      } else {
         class182.field2942.method3622(var0);
      }

   }

   @ObfuscatedName("s")
   static int method589(class121 var0) {
      int var1 = var0.method2750(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(1 == var1) {
         var2 = var0.method2750(5);
      } else if(var1 == 2) {
         var2 = var0.method2750(8);
      } else {
         var2 = var0.method2750(11);
      }

      return var2;
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(Lclass172;III)V",
      garbageValue = "1954099621"
   )
   static final void method592(class172 var0, int var1, int var2) {
      if(client.field466 == null && !client.field470) {
         if(null != var0 && class9.method133(var0) != null) {
            client.field466 = var0;
            client.field566 = class9.method133(var0);
            client.field468 = var1;
            client.field469 = var2;
            client.field407 = 0;
            client.field565 = false;
            if(client.field435 > 0) {
               int var3 = client.field435 - 1;
               class136.field2120 = new class30();
               class136.field2120.field703 = client.field436[var3];
               class136.field2120.field704 = client.field437[var3];
               class136.field2120.field705 = client.field302[var3];
               class136.field2120.field706 = client.field439[var3];
               class136.field2120.field707 = client.field440[var3];
            }

         }
      }
   }

   @ObfuscatedName("r")
   public static class39 method593(int var0) {
      class39 var1 = (class39)class39.field883.method3792((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class39.field908.method3263(9, var0);
         var1 = new class39();
         var1.field911 = var0;
         if(var2 != null) {
            var1.method796(new class118(var2));
         }

         var1.method789();
         class39.field883.method3794(var1, (long)var0);
         return var1;
      }
   }
}
