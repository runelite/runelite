import java.awt.Font;
import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("World")
public class class25 {
   @ObfuscatedName("p")
   @Export("activity")
   String field631;
   @ObfuscatedName("l")
   @Export("worldList")
   static class25[] field635;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 768774735
   )
   static int field636 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 266116075
   )
   static int field637 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1957078021
   )
   @Export("playerCount")
   int field638;
   @ObfuscatedName("g")
   static int[] field639 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 417892673
   )
   @Export("id")
   int field640;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 417351541
   )
   @Export("mask")
   int field641;
   @ObfuscatedName("ax")
   static int[] field642;
   @ObfuscatedName("q")
   @Export("address")
   String field643;
   @ObfuscatedName("y")
   static int[] field644;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1131073285
   )
   @Export("index")
   int field646;
   @ObfuscatedName("qi")
   static Font field647;
   @ObfuscatedName("m")
   static int[] field649 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1961919145
   )
   @Export("location")
   int field650;
   @ObfuscatedName("bf")
   static FontMetrics field652;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-115"
   )
   boolean method635() {
      return (4 & this.field641) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   boolean method636() {
      return (2 & this.field641) != 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2089405216"
   )
   boolean method639() {
      return (8 & this.field641) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1745055291"
   )
   boolean method643() {
      return (536870912 & this.field641) != 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-101965699"
   )
   boolean method646() {
      return (1 & this.field641) != 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass212;I)I",
      garbageValue = "-913656415"
   )
   static final int method649(class212 var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3142) {
         case 3:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass80;I)V",
      garbageValue = "-1600234541"
   )
   static final void method666(class80 var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class114.field1974.length; ++var2) {
         class114.field1974[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class114.field1974[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class130.field2064[var5] = (class114.field1974[var5 - 1] + class114.field1974[var5 + 1] + class114.field1974[var5 - 128] + class114.field1974[var5 + 128]) / 4;
            }
         }

         int[] var8 = class114.field1974;
         class114.field1974 = class130.field2064;
         class130.field2064 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.field1429; ++var3) {
            for(var4 = 0; var4 < var0.field1428; ++var4) {
               if(var0.field1430[var2++] != 0) {
                  var5 = var0.field1433 + 16 + var4;
                  int var6 = var0.field1431 + 16 + var3;
                  int var7 = (var6 << 7) + var5;
                  class114.field1974[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   boolean method670() {
      return (33554432 & this.field641) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "726896453"
   )
   public static boolean method671(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
