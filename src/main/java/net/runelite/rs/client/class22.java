package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("d")
public class class22 extends class203 {
   @ObfuscatedName("l")
   String[] field574;
   @ObfuscatedName("f")
   int[] field576;
   @ObfuscatedName("j")
   static class192 field577 = new class192(128);
   @ObfuscatedName("m")
   int[] field578;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1762647129
   )
   int field579;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -322882069
   )
   int field580;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -124980065
   )
   int field581;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 80997489
   )
   int field583;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = 1154894055
   )
   protected static int field585;
   @ObfuscatedName("bi")
   static class167 field586;

   @ObfuscatedName("w")
   public static void method614() {
      class40.field952.method3806();
      class40.field907.method3806();
      class40.field908.method3806();
      class40.field909.method3806();
   }

   @ObfuscatedName("dk")
   static String method617(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(client.field279 == 1) {
         var0 = var0 + "-wtrc";
      } else if(2 == client.field279) {
         var0 = var0 + "-wtqa";
      } else if(3 == client.field279) {
         var0 = var0 + "-wtwip";
      } else if(client.field279 == 5) {
         var0 = var0 + "-wti";
      } else if(4 == client.field279) {
         var0 = "local";
      }

      String var3 = "";
      if(class11.field165 != null) {
         var3 = "/p=" + class11.field165;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + client.field283 + "/a=" + class52.field1146 + var3 + "/";
   }

   @ObfuscatedName("m")
   public static class39 method618(int var0) {
      class39 var1 = (class39)class39.field879.method3808((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class39.field903.method3352(9, var0);
         var1 = new class39();
         var1.field869 = var0;
         if(null != var2) {
            var1.method809(new class118(var2));
         }

         var1.method840();
         class39.field879.method3805(var1, (long)var0);
         return var1;
      }
   }
}
