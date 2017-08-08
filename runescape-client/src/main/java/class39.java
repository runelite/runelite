import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class39 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   final class33 field531;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1248573855
   )
   public final int field534;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -674001303
   )
   int field532;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   public final Coordinates field528;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   public final Coordinates field530;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1346970521
   )
   final int field529;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -153605547
   )
   int field533;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1175405413
   )
   final int field526;

   @ObfuscatedSignature(
      signature = "(ILhq;Lhq;Lax;)V"
   )
   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field534 = var1;
      this.field528 = var2;
      this.field530 = var3;
      this.field531 = var4;
      Area var5 = Area.field3276[this.field534];
      SpritePixels var6 = var5.method4294(false);
      if(var6 != null) {
         this.field529 = var6.width;
         this.field526 = var6.height;
      } else {
         this.field529 = 0;
         this.field526 = 0;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-257040454"
   )
   boolean method530(int var1, int var2) {
      Area var3 = Area.field3276[this.field534];
      switch(var3.field3291.field3538) {
      case 0:
         if(var1 >= this.field532 && var1 < this.field529 + this.field532) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.field532 - this.field529 / 2 && var1 <= this.field529 / 2 + this.field532) {
            break;
         }

         return false;
      case 2:
         if(var1 <= this.field532 - this.field529 || var1 > this.field532) {
            return false;
         }
      }

      switch(var3.field3293.field3257) {
      case 0:
         if(var2 >= this.field533 && var2 < this.field533 + this.field526) {
            break;
         }

         return false;
      case 1:
         if(var2 <= this.field533 - this.field526 || var2 > this.field533) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field533 - this.field526 / 2 || var2 > this.field526 / 2 + this.field533) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2065205375"
   )
   boolean method528(int var1, int var2) {
      return this.field531 == null?false:(var1 >= this.field532 - this.field531.field470 / 2 && var1 <= this.field531.field470 / 2 + this.field532?var2 >= this.field533 && var2 <= this.field531.field478 + this.field533:false);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-515904445"
   )
   boolean method529(int var1, int var2) {
      return this.method530(var1, var2)?true:this.method528(var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1637665201"
   )
   public static int method538(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "1021598437"
   )
   static char method539(char var0, int var1) {
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

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }
}
