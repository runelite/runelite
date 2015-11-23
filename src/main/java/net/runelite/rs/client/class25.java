package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("b")
@Implements("World")
public class class25 {
   @ObfuscatedName("u")
   @Export("worldList")
   static class25[] field615;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -504177203
   )
   static int field616 = 0;
   @ObfuscatedName("t")
   static int[] field619 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("k")
   static class18 field620;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -696630233
   )
   @Export("id")
   int field621;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 89944673
   )
   int field622;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -158435857
   )
   static int field623 = 0;
   @ObfuscatedName("z")
   @Export("address")
   String field624;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = -407630143
   )
   static int field625;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -634971913
   )
   @Export("playerCount")
   int field626;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 60515985
   )
   @Export("mask")
   int field627;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1783113473
   )
   int field629;
   @ObfuscatedName("pa")
   public static class135 field630;
   @ObfuscatedName("i")
   static int[] field632 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("p")
   String field633;

   @ObfuscatedName("s")
   boolean method643() {
      return 0 != (4 & this.field622);
   }

   @ObfuscatedName("k")
   boolean method644() {
      return (2 & this.field622) != 0;
   }

   @ObfuscatedName("e")
   boolean method645() {
      return 0 != (536870912 & this.field622);
   }

   @ObfuscatedName("t")
   boolean method660() {
      return (1 & this.field622) != 0;
   }

   @ObfuscatedName("m")
   public static boolean method669(char var0) {
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 != 0) {
            char[] var1 = class164.field2646;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var3 == var0) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @ObfuscatedName("w")
   boolean method672() {
      return 0 != (8 & this.field622);
   }

   @ObfuscatedName("j")
   public static class47 method673(int var0) {
      class47 var1 = (class47)class47.field1047.method3808((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class47.field1046.method3352(14, var0);
         var1 = new class47();
         if(var2 != null) {
            var1.method1018(new class118(var2));
         }

         class47.field1047.method3805(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bz")
   static final void method674(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!client.field500) {
         if(client.field416 < 500) {
            client.field297[client.field416] = var0;
            client.field422[client.field416] = var1;
            client.field419[client.field416] = var2;
            client.field415[client.field416] = var3;
            client.field417[client.field416] = var4;
            client.field418[client.field416] = var5;
            ++client.field416;
         }

      }
   }
}
