package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ci")
public class class95 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1798925405
   )
   int field1634;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1243583709
   )
   int field1635;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -609680839
   )
   int field1636;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 553451021
   )
   int field1638;
   @ObfuscatedName("u")
   static String field1639;
   @ObfuscatedName("bk")
   static class167 field1640;
   @ObfuscatedName("y")
   static String[] field1642;

   class95(class95 var1) {
      this.field1636 = var1.field1636;
      this.field1634 = var1.field1634;
      this.field1635 = var1.field1635;
      this.field1638 = var1.field1638;
   }

   @ObfuscatedName("qa")
   protected static final void method2163() {
      class38.field872 = null;
      class31.field708 = null;
      class132.field2070 = null;
   }

   @ObfuscatedName("n")
   static void method2164() {
      class32.field749 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class32.field745[var0] = null;
         class32.field747[var0] = 1;
      }

   }

   @ObfuscatedName("l")
   static char method2165(char var0) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(221 == var0) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || 255 == var0) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(376 == var0) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("ce")
   static final void method2166(int var0, int var1, int var2, boolean var3) {
      if(class149.method3102(var0)) {
         class125.method2744(class172.field2757[var0], -1, var1, var2, var3);
      }
   }

   class95() {
   }
}
