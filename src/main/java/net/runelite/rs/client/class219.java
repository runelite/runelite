package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hs")
@Implements("XGrandExchangeOffer")
public class class219 {
   @ObfuscatedName("j")
   @Export("progress")
   byte field3149;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1518557493
   )
   @Export("itemId")
   public int field3150;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1405506295
   )
   @Export("price")
   public int field3151;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1708138833
   )
   @Export("totalQuantity")
   public int field3152;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2046919749
   )
   @Export("quantitySold")
   public int field3153;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1723392219
   )
   @Export("spent")
   public int field3154;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 165905719
   )
   static int field3155;
   @ObfuscatedName("e")
   static int[] field3156;

   @ObfuscatedName("u")
   void method4041(int var1) {
      this.field3149 &= -9;
      if(1 == var1) {
         this.field3149 = (byte)(this.field3149 | 8);
      }

   }

   @ObfuscatedName("m")
   public int method4043() {
      return this.field3149 & 7;
   }

   @ObfuscatedName("f")
   public int method4044() {
      return (this.field3149 & 8) == 8?1:0;
   }

   @ObfuscatedName("l")
   void method4045(int var1) {
      this.field3149 &= -8;
      this.field3149 = (byte)(this.field3149 | var1 & 7);
   }

   public class219(class118 var1, boolean var2) {
      this.field3149 = var1.method2537();
      this.field3150 = var1.method2538();
      this.field3151 = var1.method2541();
      this.field3152 = var1.method2541();
      this.field3153 = var1.method2541();
      this.field3154 = var1.method2541();
   }

   public class219() {
   }
}
