import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
public class class261 {
   @ObfuscatedName("r")
   public static final class261 field3624;
   @ObfuscatedName("a")
   public static final class261 field3628;
   @ObfuscatedName("v")
   public static final class261 field3625;
   @ObfuscatedName("e")
   public static final class261 field3626;
   @ObfuscatedName("j")
   public static final class261 field3622;
   @ObfuscatedName("eg")
   static RSSocket field3623;
   @ObfuscatedName("n")
   public static final class261 field3621;
   @ObfuscatedName("l")
   final String field3627;
   @ObfuscatedName("s")
   String field3630;

   static {
      field3628 = new class261("PLAIN11", "p11_full");
      field3622 = new class261("PLAIN12", "p12_full");
      field3621 = new class261("BOLD12", "b12_full");
      field3624 = new class261("VERDANA11", "verdana_11pt_regular");
      field3625 = new class261("VERDANA13", "verdana_13pt_regular");
      field3626 = new class261("VERDANA15", "verdana_15pt_regular");
   }

   class261(String var1, String var2) {
      this.field3627 = var1;
      this.field3630 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)LPreferences;",
      garbageValue = "1601250515"
   )
   static Preferences method4654() {
      FileOnDisk var0 = null;
      Preferences var1 = new Preferences();

      try {
         var0 = class152.getPreferencesFile("", Varcs.field1515.field3198, false);
         byte[] var2 = new byte[(int)var0.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.read(var2, var3, var2.length - var3);
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
            var0.close();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[Lclass261;",
      garbageValue = "-1843484348"
   )
   public static class261[] method4649() {
      return new class261[]{field3626, field3622, field3628, field3621, field3624, field3625};
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "1021176354"
   )
   static final void method4647(Actor var0) {
      if(var0.field1261 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1248 + 1 > class112.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field1261 - var0.field1260;
         int var2 = Client.gameCycle - var0.field1260;
         int var3 = var0.field1256 * 128 + var0.field1218 * 64;
         int var4 = var0.field1258 * 128 + var0.field1218 * 64;
         int var5 = var0.field1257 * 128 + var0.field1218 * 64;
         int var6 = var0.field1222 * 128 + var0.field1218 * 64;
         var0.x = (var2 * var5 + var3 * (var1 - var2)) / var1;
         var0.y = (var6 * var2 + var4 * (var1 - var2)) / var1;
      }

      var0.field1272 = 0;
      var0.orientation = var0.field1262;
      var0.angle = var0.orientation;
   }
}
