import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public abstract class class176 {
   @ObfuscatedName("w")
   static boolean field2420;
   @ObfuscatedName("bb")
   static ModIcon[] field2422;

   static {
      field2420 = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1013128189"
   )
   abstract void vmethod3351(byte[] var1);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-1763811982"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field3497.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class229.field3172.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method4576();
         if(var1.notedTemplate != -1) {
            var1.method4579(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.field3537 != -1) {
            var1.method4609(getItemDefinition(var1.field3537), getItemDefinition(var1.field3515));
         }

         if(var1.field3501 != -1) {
            var1.method4612(getItemDefinition(var1.field3501), getItemDefinition(var1.field3508));
         }

         if(!XItemContainer.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3502 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field3542 = 0;
            if(var1.field3543 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3543.method3481(); var4 != null; var4 = var1.field3543.method3477()) {
                  class251 var5 = FaceNormal.method2869((int)var4.hash);
                  if(var5.field3395) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3543 = null;
               }
            }
         }

         ItemComposition.field3497.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "104"
   )
   abstract byte[] vmethod3363();

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIII)V",
      garbageValue = "694372285"
   )
   static final void method3364(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field1007) {
         Client.field1008 = 32;
      } else {
         Client.field1008 = 0;
      }

      Client.field1007 = false;
      int var7;
      if(class59.field754 == 1 || !class34.field499 && class59.field754 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            class88.method1714(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            class88.method1714(var0);
         } else if(var5 >= var1 - Client.field1008 && var5 < 16 + var1 + Client.field1008 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            class88.method1714(var0);
            Client.field1007 = true;
         }
      }

      if(Client.field1125 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.field1125 * 45;
            class88.method1714(var0);
         }
      }

   }
}
