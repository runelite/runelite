import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 462737933
   )
   static int field238;
   @ObfuscatedName("j")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = 515073809
   )
   static int field240;
   @ObfuscatedName("dn")
   static byte[][] field242;
   @ObfuscatedName("x")
   @Export("name")
   String name;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 981256389
   )
   public static int field245;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "1957983815"
   )
   static final void method216(CipherBuffer var0) {
      var0.method3085();
      int var1 = Client.localInteractingIndex;
      Player var2 = class22.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field276 = var1;
      int var3 = var0.method3097(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - CombatInfoListHolder.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method245() << 6);
      var2.pathY[0] = var6 - class3.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method245() << 6);
      class31.plane = var2.field291 = var4;
      if(null != class45.field923[var1]) {
         var2.method244(class45.field923[var1]);
      }

      class45.field934 = 0;
      class45.field925[++class45.field934 - 1] = var1;
      class45.field921[var1] = 0;
      class45.field926 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method3097(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class45.field928[var7] = var11 + (var9 << 28) + (var10 << 14);
            class45.field929[var7] = 0;
            class45.field930[var7] = -1;
            class45.field927[++class45.field926 - 1] = var7;
            class45.field921[var7] = 0;
         }
      }

      var0.method3082();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
      garbageValue = "-2109874921"
   )
   public static String method217(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return var3 == null?"null":var3.toString();
      } else {
         int var8 = var2 + var1;
         int var4 = 0;

         for(int var9 = var1; var9 < var8; ++var9) {
            CharSequence var6 = var0[var9];
            if(var6 == null) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var5 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var8; ++var10) {
            CharSequence var7 = var0[var10];
            if(null == var7) {
               var5.append("null");
            } else {
               var5.append(var7);
            }
         }

         return var5.toString();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIZIZB)V",
      garbageValue = "60"
   )
   static void method218(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = World.worldList[var9];
            int var12 = class3.method48(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class3.method48(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var14;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method218(var0, var7 - 1, var2, var3, var4, var5);
         method218(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1176036886"
   )
   public static int method219(String var0) {
      return var0.length() + 2;
   }
}
