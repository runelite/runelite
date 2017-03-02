import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class168 {
   @ObfuscatedName("s")
   public static class181 field2181;

   class168() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)LItemComposition;",
      garbageValue = "4"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field2956.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field2954.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method3724();
         if(var1.notedTemplate != -1) {
            var1.method3789(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.field2995 != -1) {
            var1.method3801(getItemDefinition(var1.field2995), getItemDefinition(var1.field2974));
         }

         if(var1.field3000 != -1) {
            var1.method3729(getItemDefinition(var1.field3000), getItemDefinition(var1.field3003));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field2950 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field2976 = 0;
         }

         ItemComposition.field2956.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "2081576974"
   )
   public static int method3259(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-24"
   )
   static final void method3260(int var0, int var1) {
      int var2 = class16.field170.method3969("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         var4 = class16.field170.method3969(class57.method1161(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = 22 + Client.menuOptionCount * 15;
      var4 = var0 - var2 / 2;
      if(var2 + var4 > class2.field21) {
         var4 = class2.field21 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var3 + var1 > class20.field216) {
         var5 = class20.field216 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      Varbit.region.method1792(class156.plane, var0, var1, false);
      Client.isMenuOpen = true;
      MessageNode.menuX = var4;
      class137.menuY = var5;
      class36.menuWidth = var2;
      class212.menuHeight = 22 + Client.menuOptionCount * 15;
   }
}
