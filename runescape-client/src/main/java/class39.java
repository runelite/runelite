import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class39 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1346251409
   )
   int field521;
   @ObfuscatedName("v")
   final class33 field522;
   @ObfuscatedName("u")
   public final class212 field523;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 960156815
   )
   final int field525;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -543112109
   )
   public final int field526;
   @ObfuscatedName("h")
   public final class212 field527;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 831690275
   )
   int field528;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1561084021
   )
   final int field529;

   class39(int var1, class212 var2, class212 var3, class33 var4) {
      this.field526 = var1;
      this.field523 = var2;
      this.field527 = var3;
      this.field522 = var4;
      class242 var5 = class242.field3276[this.field526];
      SpritePixels var6 = var5.method4370(false);
      if(var6 != null) {
         this.field529 = var6.width;
         this.field525 = var6.height;
      } else {
         this.field529 = 0;
         this.field525 = 0;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "5"
   )
   boolean method543(int var1, int var2) {
      class242 var3 = class242.field3276[this.field526];
      switch(var3.field3292.field3539) {
      case 0:
         if(var1 >= this.field521 && var1 < this.field529 + this.field521) {
            break;
         }

         return false;
      case 1:
         if(var1 <= this.field521 - this.field529 || var1 > this.field521) {
            return false;
         }
         break;
      case 2:
         if(var1 < this.field521 - this.field529 / 2 || var1 > this.field529 / 2 + this.field521) {
            return false;
         }
      }

      switch(var3.field3287.field3263) {
      case 0:
         if(var2 <= this.field528 - this.field525 || var2 > this.field528) {
            return false;
         }
         break;
      case 1:
         if(var2 >= this.field528 - this.field525 / 2 && var2 <= this.field528 + this.field525 / 2) {
            break;
         }

         return false;
      case 2:
         if(var2 < this.field528 || var2 >= this.field525 + this.field528) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2076461606"
   )
   boolean method550(int var1, int var2) {
      return this.method543(var1, var2)?true:this.method551(var1, var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-5"
   )
   boolean method551(int var1, int var2) {
      return this.field522 == null?false:(var1 >= this.field521 - this.field522.field465 / 2 && var1 <= this.field522.field465 / 2 + this.field521?var2 >= this.field528 && var2 <= this.field522.field464 + this.field528:false);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LPreferences;",
      garbageValue = "4"
   )
   static Preferences method552() {
      FileOnDisk var0 = null;
      Preferences var1 = new Preferences();

      try {
         var0 = XGrandExchangeOffer.getPreferencesFile("", class4.field25.name, false);
         byte[] var2 = new byte[(int)var0.method2386()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.method2387(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new Preferences(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method2385();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-50"
   )
   public static int method553(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }
}
