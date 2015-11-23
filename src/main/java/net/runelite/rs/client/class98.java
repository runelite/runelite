package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cn")
@Implements("ItemLayer")
public final class class98 {
   @ObfuscatedName("a")
   @Export("top")
   class84 field1657;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1612412647
   )
   @Export("x")
   int field1658;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -551432189
   )
   @Export("y")
   int field1659;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -1867909679
   )
   static int field1660;
   @ObfuscatedName("m")
   @Export("middle")
   class84 field1661;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 298308091
   )
   @Export("hash")
   int field1662;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1607886499
   )
   @Export("flags")
   int field1663;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2093829273
   )
   @Export("height")
   int field1664;
   @ObfuscatedName("u")
   @Export("bottom")
   class84 field1665;
   @ObfuscatedName("mo")
   @Export("clanMembers")
   static class24[] field1667;

   @ObfuscatedName("bo")
   static final void method2216(class2 var0, int var1, int var2, int var3) {
      if(var0 != class0.field12) {
         if(client.field416 < 400) {
            String var4;
            if(var0.field37 == 0) {
               var4 = var0.field32[0] + var0.field34 + var0.field32[1] + class124.method2833(var0.field53, class0.field12.field53) + " " + " (" + "level-" + var0.field53 + ")" + var0.field32[2];
            } else {
               var4 = var0.field32[0] + var0.field34 + var0.field32[1] + " " + " (" + "skill-" + var0.field37 + ")" + var0.field32[2];
            }

            int var5;
            if(client.field398 == 1) {
               class25.method674("Use", client.field428 + " " + "->" + " " + class74.method1617(16777215) + var4, 14, var1, var2, var3);
            } else if(client.field546) {
               if(8 == (class138.field2124 & 8)) {
                  class25.method674(client.field432, client.field433 + " " + "->" + " " + class74.method1617(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(client.field328[var5] != null) {
                     short var6 = 0;
                     if(client.field328[var5].equalsIgnoreCase("Attack")) {
                        if(client.field276 == class20.field560) {
                           continue;
                        }

                        if(class20.field565 == client.field276 || class20.field559 == client.field276 && var0.field53 > class0.field12.field53) {
                           var6 = 2000;
                        }

                        if(class0.field12.field50 != 0 && 0 != var0.field50) {
                           if(class0.field12.field50 == var0.field50) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(client.field404[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = var6 + client.field402[var5];
                     class25.method674(client.field328[var5], class74.method1617(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < client.field416; ++var5) {
               if(client.field419[var5] == 23) {
                  client.field422[var5] = class74.method1617(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("j")
   public static void method2217(class166 var0, class166 var1, boolean var2, class223 var3) {
      class221.field3164 = var0;
      class51.field1091 = var1;
      class102.field1750 = var2;
      class51.field1092 = class221.field3164.method3322(10);
      class51.field1113 = var3;
   }
}
