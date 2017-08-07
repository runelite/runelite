import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class204 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 360154841
   )
   public static int field2487;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   public static class205 field2486;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field2488;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field2484;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -367115641
   )
   public static int field2489;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field2483;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field2492;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 617298791
   )
   public static int field2491;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -304750657
   )
   public static int field2490;

   static {
      field2487 = 0;
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(Lhg;IIZI)V",
      garbageValue = "-707308551"
   )
   static void method3697(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2627 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2627 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2627 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.field2635;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.field2635;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.field2635 >> 14;
      }

      if(var0.field2627 == 4) {
         var0.width = var0.field2640 * var0.height / var0.field2641;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.field2641 * var0.width / var0.field2640;
      }

      if(Client.field1072 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field1169 = var0;
      }

      if(var3 && var0.field2732 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.field849 = var0.field2732;
         Client.field1101.addFront(var6);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;I)V",
      garbageValue = "1625366164"
   )
   public static void method3698(IndexDataBase var0, IndexDataBase var1) {
      KitDefinition.identKit_ref = var0;
      KitDefinition.field3342 = var1;
      KitDefinition.field3350 = KitDefinition.identKit_ref.fileCount(3);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)[Lje;",
      garbageValue = "8"
   )
   public static class284[] method3687() {
      return new class284[]{class284.field3749, class284.field3748, class284.field3751, class284.field3752, class284.field3750};
   }
}
