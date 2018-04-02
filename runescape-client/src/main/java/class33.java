import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public final class class33 {
   @ObfuscatedName("oh")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("clanMemberManager")
   static ClanMemberManager clanMemberManager;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   static IndexDataBase field441;
   @ObfuscatedName("i")
   final int[] field444;

   class33() {
      this.field444 = new int[4096];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lad;I)V",
      garbageValue = "-1673673141"
   )
   final void method377(class44 var1) {
      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field444[var2 * 64 + var3] = var1.method659(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-37520770"
   )
   final int method376(int var1, int var2) {
      return this.field444[var1 * 64 + var2];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1218769080"
   )
   public static byte[] method378() {
      byte[] var0 = new byte[24];

      try {
         class167.randomDat.seek(0L);
         class167.randomDat.read(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1637554704"
   )
   static void method385(String var0, String var1, String var2) {
      class90.loginMessage1 = var0;
      class90.loginMessage2 = var1;
      class90.loginMessage3 = var2;
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1404896621"
   )
   static final void method384() {
      if(Tile.soundSystem1 != null) {
         Tile.soundSystem1.method2222();
      }

      if(OwnWorldComparator.soundSystem0 != null) {
         OwnWorldComparator.soundSystem0.method2222();
      }

   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "19"
   )
   static final void method379(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class177.menuAction(var1, var2, var3, var4, var5, var6, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
      }
   }
}
