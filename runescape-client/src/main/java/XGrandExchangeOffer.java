import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("ka")
   static Widget field308;
   @ObfuscatedName("a")
   @Export("progress")
   byte progress;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1770728449
   )
   @Export("price")
   public int price;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1966590447
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1495023969
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 637688835
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 267246811
   )
   @Export("spent")
   public int spent;

   public XGrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1933794168"
   )
   void method114(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1395540811"
   )
   void method111(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2116910357"
   )
   public int method98() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-790025627"
   )
   public int method95() {
      return this.progress & 7;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-70364969"
   )
   static int method99(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-593689911"
   )
   public static String method116(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 131) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "31556"
   )
   static final void method117(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class61.tileHeights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var1][var3 + var2] = class61.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var3 + var1][var2] = class61.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class61.tileHeights[var0][var1 - 1][var2] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class61.tileHeights[var0][var1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class61.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }
}
