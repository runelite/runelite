import java.io.IOException;
import java.security.SecureRandom;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("AttackOption_dependsOnCombatLevels")
   AttackOption_dependsOnCombatLevels(0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("AttackOption_alwaysRightClick")
   AttackOption_alwaysRightClick(1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("AttackOption_leftClickWhereAvailable")
   AttackOption_leftClickWhereAvailable(2),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("AttackOption_hidden")
   AttackOption_hidden(3);

   @ObfuscatedName("sp")
   @Export("__cj_sp")
   static short[] __cj_sp;
   @ObfuscatedName("ay")
   @Export("__cj_ay")
   static String __cj_ay;
   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("__cj_bo")
   static IndexedSprite[] __cj_bo;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1461217963
   )
   @Export("id")
   final int id;

   private AttackOption(int var3) {
      this.id = var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Ljava/security/SecureRandom;",
      garbageValue = "-1732522161"
   )
   static SecureRandom method2034() {
      SecureRandom var0 = new SecureRandom();
      var0.nextInt();
      return var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "-189314181"
   )
   public static int method2033(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      byte var7 = 0;
      byte var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = (char)var7;
            boolean var10 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var14;
         if(var8 != 0) {
            var14 = (char)var8;
            boolean var11 = false;
         } else {
            var14 = var1.charAt(var6++);
         }

         byte var16;
         if(var9 == 198) {
            var16 = 69;
         } else if(var9 == 230) {
            var16 = 101;
         } else if(var9 == 223) {
            var16 = 115;
         } else if(var9 == 338) {
            var16 = 69;
         } else if(var9 == 339) {
            var16 = 101;
         } else {
            var16 = 0;
         }

         var7 = var16;
         byte var12;
         if(var14 == 198) {
            var12 = 69;
         } else if(var14 == 230) {
            var12 = 101;
         } else if(var14 == 223) {
            var12 = 115;
         } else if(var14 == 338) {
            var12 = 69;
         } else if(var14 == 339) {
            var12 = 101;
         } else {
            var12 = 0;
         }

         var8 = var12;
         var9 = class12.method155(var9, var2);
         var14 = class12.method155(var14, var2);
         if(var9 != var14 && Character.toUpperCase(var9) != Character.toUpperCase(var14)) {
            var9 = Character.toLowerCase(var9);
            var14 = Character.toLowerCase(var14);
            if(var14 != var9) {
               return CollisionMap.method3631(var9, var2) - CollisionMap.method3631(var14, var2);
            }
         }
      }

      int var15 = Math.min(var3, var4);

      int var17;
      char var18;
      for(var17 = 0; var17 < var15; ++var17) {
         char var19 = var0.charAt(var17);
         var18 = var1.charAt(var17);
         if(var18 != var19 && Character.toUpperCase(var19) != Character.toUpperCase(var18)) {
            var19 = Character.toLowerCase(var19);
            var18 = Character.toLowerCase(var18);
            if(var19 != var18) {
               return CollisionMap.method3631(var19, var2) - CollisionMap.method3631(var18, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var20 = 0; var20 < var15; ++var20) {
            var18 = var0.charAt(var20);
            char var13 = var1.charAt(var20);
            if(var18 != var13) {
               return CollisionMap.method3631(var18, var2) - CollisionMap.method3631(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "12521922"
   )
   public static byte[] method2032() {
      byte[] var0 = new byte[24];

      try {
         class168.randomDat.seek(0L);
         class168.randomDat.readFill(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var3) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }
}
