import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class32 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1293117343
   )
   int field721;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 754500939
   )
   int field722;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1678647595
   )
   int field724;
   @ObfuscatedName("v")
   String field725;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 590591205
   )
   int field726;

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1943946429"
   )
   static final void method688(String var0) {
      if(null != var0) {
         if((Client.friendCount < 200 || Client.field521 == 1) && Client.friendCount < 400) {
            String var1 = class112.method2486(var0, class43.field996);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = class112.method2486(var3.name, class43.field996);
                  if(var4 != null && var4.equals(var1)) {
                     Widget.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(null != var3.previousName) {
                     var5 = class112.method2486(var3.previousName, class43.field996);
                     if(var5 != null && var5.equals(var1)) {
                        Widget.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = class112.method2486(var6.name, class43.field996);
                  if(null != var4 && var4.equals(var1)) {
                     Widget.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(null != var6.previousName) {
                     var5 = class112.method2486(var6.previousName, class43.field996);
                     if(var5 != null && var5.equals(var1)) {
                        Widget.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class112.method2486(class165.localPlayer.name, class43.field996).equals(var1)) {
                  Widget.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.field324.method2828(61);
                  Client.field324.method2556(class31.method685(var0));
                  Client.field324.method2562(var0);
               }
            }
         } else {
            Widget.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Ljava/lang/String;Ljava/lang/String;B)Lclass227;",
      garbageValue = "124"
   )
   public static class227 method689(class170 var0, class170 var1, String var2, String var3) {
      int var4 = var0.method3327(var2);
      int var5 = var0.method3325(var4, var3);
      return class218.method3986(var0, var1, var4, var5);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-573725883"
   )
   public static int method690() {
      return ++class143.mouseIdleTicks - 1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "-9"
   )
   public static void method691(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method691(var0, var1, var2, var5 - 1);
         method691(var0, var1, 1 + var5, var3);
      }

   }
}
