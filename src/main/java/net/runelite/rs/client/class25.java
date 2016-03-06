package net.runelite.rs.client;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("v")
@Implements("World")
public class class25 {
   @ObfuscatedName("f")
   @Export("worldList")
   static class25[] field632;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -918668135
   )
   static int field633 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2141441355
   )
   static int field634 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 606681477
   )
   @Export("location")
   int field635;
   @ObfuscatedName("n")
   static int[] field636 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2144203281
   )
   @Export("id")
   int field637;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1353840845
   )
   @Export("mask")
   int field638;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -943097539
   )
   @Export("playerCount")
   int field639;
   @ObfuscatedName("u")
   @Export("address")
   String field640;
   @ObfuscatedName("g")
   @Export("activity")
   String field641;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -310972441
   )
   @Export("index")
   int field642;
   @ObfuscatedName("h")
   static int[] field645 = new int[]{1, 1, 1, 1};

   @ObfuscatedName("u")
   boolean method597() {
      return (33554432 & this.field638) != 0;
   }

   @ObfuscatedName("k")
   boolean method598() {
      return (2 & this.field638) != 0;
   }

   @ObfuscatedName("q")
   boolean method601() {
      return 0 != (536870912 & this.field638);
   }

   @ObfuscatedName("r")
   boolean method602() {
      return 0 != (4 & this.field638);
   }

   @ObfuscatedName("n")
   boolean method612() {
      return (1 & this.field638) != 0;
   }

   @ObfuscatedName("b")
   boolean method631() {
      return (8 & this.field638) != 0;
   }

   @ObfuscatedName("ab")
   static final void method634() {
      int[] var0 = class32.field755;

      int var1;
      for(var1 = 0; var1 < class32.field749; ++var1) {
         class2 var2 = client.field410[var0[var1]];
         if(null != var2 && var2.field826 > 0) {
            --var2.field826;
            if(0 == var2.field826) {
               var2.field823 = null;
            }
         }
      }

      for(var1 = 0; var1 < client.field561; ++var1) {
         int var4 = client.field326[var1];
         class34 var3 = client.field324[var4];
         if(var3 != null && var3.field826 > 0) {
            --var3.field826;
            if(0 == var3.field826) {
               var3.field823 = null;
            }
         }
      }

   }
}
