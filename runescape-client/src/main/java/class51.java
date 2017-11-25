import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class51 implements class102 {
   @ObfuscatedName("qx")
   static short[] field626;
   @ObfuscatedName("z")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -1914160081
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field622;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ldo;",
      garbageValue = "814951557"
   )
   public AbstractSoundSystem vmethod1996() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lid;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "1272031749"
   )
   public static void method777(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.getFile(var1);
      int var6 = var0.getChild(var5, var2);
      Buffer.method3318(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(Lhx;Ljb;IIZI)V",
      garbageValue = "340534033"
   )
   static final void method780(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         String var9 = ISAACCipher.getColTags(16748608) + var1.name;
         int var11 = var1.id;
         int var13 = var0.id;
         if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var7;
            Client.menuTargets[Client.menuOptionCount] = var9;
            Client.menuTypes[Client.menuOptionCount] = var6;
            Client.menuIdentifiers[Client.menuOptionCount] = var11;
            Client.menuActionParams0[Client.menuOptionCount] = var2;
            Client.menuActionParams1[Client.menuOptionCount] = var13;
            Client.field889[Client.menuOptionCount] = var4;
            ++Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(Lhx;B)Lhx;",
      garbageValue = "10"
   )
   static Widget method781(Widget var0) {
      Widget var2 = var0;
      int var3 = class17.method146(ClanMember.getWidgetConfig(var0));
      Widget var1;
      if(var3 == 0) {
         var1 = null;
      } else {
         int var4 = 0;

         while(true) {
            if(var4 >= var3) {
               var1 = var2;
               break;
            }

            var2 = class87.method1762(var2.parentId);
            if(var2 == null) {
               var1 = null;
               break;
            }

            ++var4;
         }
      }

      Widget var5 = var1;
      if(var1 == null) {
         var5 = var0.dragParent;
      }

      return var5;
   }
}
