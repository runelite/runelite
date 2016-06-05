import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class50 extends class204 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2122115311
   )
   public int field1104 = 0;
   @ObfuscatedName("i")
   static class193 field1106 = new class193(64);
   @ObfuscatedName("t")
   public static class167 field1109;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "845942579"
   )
   void method985(class119 var1) {
      while(true) {
         int var2 = var1.method2494();
         if(var2 == 0) {
            return;
         }

         this.method990(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1410397501"
   )
   static void method987(String var0, String var1, String var2) {
      class31.field719 = var0;
      class31.field734 = var1;
      class31.field712 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CIB)C",
      garbageValue = "40"
   )
   static char method989(char var0, int var1) {
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

         if(var0 == 221) {
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

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "510931890"
   )
   void method990(class119 var1, int var2) {
      if(var2 == 2) {
         this.field1104 = var1.method2470();
      }

   }
}
