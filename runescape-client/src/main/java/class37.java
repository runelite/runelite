import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class37 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   static final class37 field509;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   static final class37 field505;
   @ObfuscatedName("m")
   public static boolean field506;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1433244755
   )
   static int field512;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 682502291
   )
   final int field507;

   static {
      field509 = new class37(0);
      field505 = new class37(1);
   }

   class37(int var1) {
      this.field507 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;S)Ljava/lang/String;",
      garbageValue = "17347"
   )
   public static String method507(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if(var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = Client.charToByteCp1252(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1792957764"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[Liq;",
      garbageValue = "-2023228195"
   )
   public static JagexGame[] method505() {
      return new JagexGame[]{JagexGame.field3351, JagexGame.field3352, JagexGame.field3357, JagexGame.field3350, JagexGame.field3355, JagexGame.field3354};
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "-65"
   )
   static char method504(char var0) {
      return (char)(var0 == 198?69:(var0 == 230?101:(var0 == 223?115:(var0 == 338?69:(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1641663795"
   )
   static void method503() {
      if(GrandExchangeEvents.loadWorlds()) {
         class90.worldSelectShown = true;
      }

   }
}
