import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   @Export("AttackOption_dependsOnCombatLevels")
   AttackOption_dependsOnCombatLevels(0),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   @Export("AttackOption_alwaysRightClick")
   AttackOption_alwaysRightClick(1),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   @Export("AttackOption_leftClickWhereAvailable")
   AttackOption_leftClickWhereAvailable(2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   @Export("AttackOption_hidden")
   AttackOption_hidden(3);

   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1499999509
   )
   @Export("id")
   final int id;

   AttackOption(int var3) {
      this.id = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2130441585"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;I)V",
      garbageValue = "277000562"
   )
   public static void method1748(IndexDataBase var0) {
      InvType.field3374 = var0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "142924289"
   )
   static String method1749(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class280.field3755[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class280.field3755[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class280.field3755[(var6 & 15) << 2 | var7 >>> 6]).append(class280.field3755[var7 & 63]);
            } else {
               var3.append(class280.field3755[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class280.field3755[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lch;I)V",
      garbageValue = "1650388458"
   )
   static void method1747(World var0) {
      if(var0.method1592() != Client.isMembers) {
         Client.isMembers = var0.method1592();
         boolean var1 = var0.method1592();
         if(var1 != ItemComposition.isMembersWorld) {
            Frames.method2942();
            ItemComposition.isMembersWorld = var1;
         }
      }

      class161.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      Frames.port1 = Client.socketType == 0?43594:var0.id + 40000;
      class150.port2 = Client.socketType == 0?443:var0.id + 50000;
      class179.myWorldPort = Frames.port1;
   }
}
